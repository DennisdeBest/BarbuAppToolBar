package com.debest.dennis.barbuapptoolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by p8744 on 16/03/2016.
 */
public class GameActivity extends AppCompatActivity {
    //initialize a new cardRandomizer and the context
    CardRandomizer cardRandomizer = new CardRandomizer();
    Context context = this;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);

        //if an action bar is set change it's title
        if(getSupportActionBar()!=null)
        getSupportActionBar().setTitle(R.string.action_bar_title_game);

        //Get the name of the previous activity
        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("previousActivity");

        //get the image view
        final ImageView imgView = (ImageView) findViewById(R.id.card);
        //find the back of the card image ressource and set it to the image view
        int back_id = getResources().getIdentifier("com.debest.dennis.barbuapptoolbar:drawable/" + "back", null, null);
        imgView.setImageResource(back_id);

        //set a listenener on the image view
            imgView.setOnClickListener(new View.OnClickListener() {
                //Set variables
                int id;
                String rule;
                //Create arraylist
                ArrayList<Integer> cardList = new ArrayList<Integer>();
                ArrayList<String> ruleList = new ArrayList<String>();

                //get textviews
                TextView Counter = (TextView) findViewById(R.id.counter);
                TextView RuleTextView = (TextView) findViewById(R.id.rule_text_view);

                @Override
                //Action to perform on click
                public void onClick(View v) {

                    //set textview
                    Counter.setText(R.string.new_game);

                    //Set a new random
                    Random rand = new Random();
                    //if the list is empty set it to getIds
                    if (cardList.size() == 0) {
                        id = getResources().getIdentifier("com.debest.dennis.barbuapptoolbar:drawable/" + "back", null, null);
                        cardList = cardRandomizer.getIDs(context);
                        ruleList = cardRandomizer.getRules(context);
                        imgView.setImageResource(id);
                        RuleTextView.setText("");

                    }
                    //else pick a random card, display it on the image view and remove it from the array
                    else {
                        int r = rand.nextInt(cardList.size());
                        id = cardList.get(r);
                        rule = ruleList.get(r);
                        cardList.remove(r);
                        ruleList.remove(r);
                        Counter.setText(getString(R.string.cards_left) + Integer.toString(cardList.size()));
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

        return super.onOptionsItemSelected(item);
    }

}
