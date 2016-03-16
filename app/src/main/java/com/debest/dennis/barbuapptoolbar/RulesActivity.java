package com.debest.dennis.barbuapptoolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        ArrayList<Integer> cardList = new ArrayList<Integer>();
        ArrayList<String> ruleList = new ArrayList<String>();

        cardList = cardRandomizer.getIDs(context);
        ruleList = cardRandomizer.getRules(context);

        //String[] test = new String[] {"test", "test2", "test3"};

        ListAdapter listAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,ruleList);

        ListView listView = (ListView) findViewById(R.id.rule_list_view);

        listView.setAdapter(listAdapter);

    }
}
