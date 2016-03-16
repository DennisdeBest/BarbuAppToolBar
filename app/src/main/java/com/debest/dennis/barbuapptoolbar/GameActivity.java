package com.debest.dennis.barbuapptoolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

/**
 * Created by p8744 on 16/03/2016.
 */
public class GameActivity extends AppCompatActivity {

    CardRandomizer cardRandomizer = new CardRandomizer();
    Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        final ImageView imgView = (ImageView) findViewById(R.id.card);
        int back_id = getResources().getIdentifier("com.debest.dennis.barbuapptoolbar:drawable/" + "back", null, null);
        imgView.setImageResource(back_id);
            imgView.setOnClickListener(new View.OnClickListener() {
                //Set variables
                int id;
                String rule;
                //Create arraylist
                ArrayList<Integer> cardList = new ArrayList<Integer>();
                ArrayList<String> ruleList = new ArrayList<String>();
                //ArrayList<String> randomRuleList = new ArrayList<String>();
                //HashMap<Integer, String > idsAndRules = new HashMap<Integer, String>();
                //Get counter textview
                TextView Counter = (TextView) findViewById(R.id.counter);
                TextView RuleTextView = (TextView) findViewById(R.id.rule_text_view);

                @Override
                //Action to perform on click
                public void onClick(View v) {
                    Counter.setText("New Game");
                    Random rand = new Random();
                    //if the list is empty set it to getIds
                    if (cardList.size() == 0) {
                        id = getResources().getIdentifier("com.debest.dennis.barbuapptoolbar:drawable/" + "back", null, null);
                        cardList = cardRandomizer.getIDs(context);
                        ruleList = cardRandomizer.getRules(context);
                        //idsAndRules = cardRandomizer.cardAndRule(cardList, ruleList);
                        imgView.setImageResource(id);
                        RuleTextView.setText("");
                        for(int i = 0; i< cardList.size(); i++){
                            String name = getResources().getResourceEntryName(cardList.get(i));
                            Log.e("name", "" + name);
                        }

                    }
                    //else pick a random card, display it on the image view and remove it from the array
                    else {
                        int r = rand.nextInt(cardList.size());
                        id = cardList.get(r);
                        rule = ruleList.get(r);
                        String name = getResources().getResourceEntryName(id);
                        Log.e("name", "" + name);
                        //Log.e("Array", "" + cardList);
                        Log.e("rule : ", "rule : " + rule);
                        cardList.remove(r);
                        ruleList.remove(r);
                        Counter.setText("Cartes restantes : " + Integer.toString(cardList.size()));
                        RuleTextView.setText(rule);
                    }

                    imgView.setImageResource(id);
                }
            });
        }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
