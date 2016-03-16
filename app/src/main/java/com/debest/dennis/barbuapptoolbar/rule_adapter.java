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

    public ArrayList<Integer> cardIds;

    public rule_adapter(Context context, ArrayList<String> rules, ArrayList<Integer> cardIds) {
        super(context, R.layout.rule_item_layout, rules);

        this.cardIds = cardIds;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(getContext());

        View view = layoutInflater.inflate(R.layout.rule_item_layout, parent, false);

        String rule = getItem(position);

        TextView textView = (TextView) view.findViewById(R.id.row_card_rule_text);

        textView.setText(rule);

        ImageView imageView = (ImageView) view.findViewById(R.id.row_card_image);

        imageView.setImageResource(cardIds.get(position));

        return view;


    }
}
