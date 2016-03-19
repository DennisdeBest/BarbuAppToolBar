package com.debest.dennis.barbuapptoolbar;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by p8744 on 16/03/2016.
 */
public class rule_adapter extends ArrayAdapter<String> {

    //set Arraylist
    public ArrayList<Integer> cardIds;

    //constructor gets 2 Arraylists one for the rule string and the other for the id int
    public rule_adapter(Context context, ArrayList<String> rules, ArrayList<Integer> cardIds) {
        super(context, R.layout.rule_item_layout, rules);

        this.cardIds = cardIds;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View view = layoutInflater.inflate(R.layout.rule_item_layout, parent, false);
        //get the rules at the position in the array of the row that was clicked
        String rule = getItem(position);
        //get the textview for rule and set the rule
        TextView textView = (TextView) view.findViewById(R.id.row_card_rule_text);

        textView.setText(rule);
        //get the imageView and set the image ressource as the one in the cardIds array at the position of the row that was clicked
        ImageView imageView = (ImageView) view.findViewById(R.id.row_card_image);

        imageView.setImageResource(cardIds.get(position));

        return view;


    }
}
