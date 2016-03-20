package com.debest.dennis.barbuapptoolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by p8744 on 16/03/2016.
 */
public class RulesActivity extends AppCompatActivity{
    CardRandomizer cardRandomizer = new CardRandomizer();
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Force app into fullscreen mode
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_rules);

        //set action bar titles if action bar is set
        if(getSupportActionBar()!=null)
            getSupportActionBar().setTitle(R.string.action_bar_title_rules);

        //Create array lists
        ArrayList<Integer> cardList;
        ArrayList<String> ruleList;

        //get values for the arraylists
        cardList = cardRandomizer.getIDs(context);
        ruleList = cardRandomizer.getRules(context);

        //set our personalized adapter
        ListAdapter listAdapter = new RuleAdapter(this,ruleList, cardList);

        ListView listView = (ListView) findViewById(R.id.rule_list_view);

        listView.setAdapter(listAdapter);

    }

}
