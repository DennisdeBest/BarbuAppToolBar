package com.debest.dennis.barbuapptoolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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
        ListAdapter listAdapter = new rule_adapter(this,ruleList, cardList);

        ListView listView = (ListView) findViewById(R.id.rule_list_view);

        listView.setAdapter(listAdapter);

    }

}
