package com.debest.dennis.barbuapptoolbar;

import android.content.Context;
import android.support.annotation.NonNull;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by p8744 on 16/03/2016.
 */
public class CardRandomizer {
    public ArrayList<Integer> getIDs(Context context){

        ArrayList<Integer> res = new ArrayList<>();
        final R.drawable drawableResources = new R.drawable();
        final Class<R.drawable> c = R.drawable.class;
        final Field[] fields = c.getDeclaredFields();

        for (int i = 0, max = fields.length; i < max; i++) {
            final int resourceId;
            try {
                resourceId = fields[i].getInt(drawableResources);
                String name = context.getResources().getResourceEntryName(resourceId);
                //Use regex to filter out system ressources
                if (name.matches("(clubs|joker|spades|diamonds|hearts).*"))
                    res.add(resourceId);
            } catch (Exception e) {
                continue;
            }
        }
        //return the resulting array
        return res;
    }

    public ArrayList<String> getRules(Context context){
        ArrayList<String> rulesArray = new ArrayList<>();
        //Clubs
        rulesArray.add("Tu bois 10"); //10
        rulesArray.add("Tu bois 2"); // 2
        rulesArray.add("Tu bois 3"); // 3
        rulesArray.add("Tu bois 4"); // 4
        rulesArray.add("Tu bois 5"); // 5
        rulesArray.add("Tu bois 6"); // 6
        rulesArray.add("Tu bois 7"); // 7
        rulesArray.add("Tu bois 8"); // 8
        rulesArray.add("Tu bois 9"); //9
        rulesArray.add("Cul sec"); //ace
        rulesArray.add("Dans Ma valise"); //jack
        rulesArray.add("Je n'ai jamais"); //king
        rulesArray.add("Invente une règles"); // queen
        //Diamonds
        rulesArray.add("Tu distribu 10"); //10
        rulesArray.add("Tu distribu 2"); // 2
        rulesArray.add("Tu distribu 3"); // 3
        rulesArray.add("Tu distribu 4"); // 4
        rulesArray.add("Tu distribu 5"); // 5
        rulesArray.add("Tu distribu 6"); // 6
        rulesArray.add("Tu distribu 7"); // 7
        rulesArray.add("Tu distribu 8"); // 8
        rulesArray.add("Tu distribu 9"); //9
        rulesArray.add("Cul sec"); //ace
        rulesArray.add("Dans Ma valise"); //jack
        rulesArray.add("Je n'ai jamais"); //king
        rulesArray.add("Invente une règles"); // queen
        //Hearts
        rulesArray.add("Tu distribu 10"); //10
        rulesArray.add("Tu distribu 2"); // 2
        rulesArray.add("Tu distribu 3"); // 3
        rulesArray.add("Tu distribu 4"); // 4
        rulesArray.add("Tu distribu 5"); // 5
        rulesArray.add("Tu distribu 6"); // 6
        rulesArray.add("Tu distribu 7"); // 7
        rulesArray.add("Tu distribu 8"); // 8
        rulesArray.add("Tu distribu 9"); //9
        rulesArray.add("Cul sec"); //ace
        rulesArray.add("Dans Ma valise"); //jack
        rulesArray.add("Je n'ai jamais"); //king
        rulesArray.add("Invente une règles"); // queen
        //joker
        rulesArray.add("joker");
        //Spades
        rulesArray.add("Tu bois 10"); //10
        rulesArray.add("Tu bois 2"); // 2
        rulesArray.add("Tu bois 3"); // 3
        rulesArray.add("Tu bois 4"); // 4
        rulesArray.add("Tu bois 5"); // 5
        rulesArray.add("Tu bois 6"); // 6
        rulesArray.add("Tu bois 7"); // 7
        rulesArray.add("Tu bois 8"); // 8
        rulesArray.add("Tu bois 9"); //9
        rulesArray.add("Cul sec"); //ace
        rulesArray.add("Dans Ma valise"); //jack
        rulesArray.add("Je n'ai jamais"); //king
        rulesArray.add("Invente une règles"); // queen

    return rulesArray;
    }

    public HashMap<Integer, String> cardAndRule(ArrayList<Integer> Ids, ArrayList<String> rules) {
        HashMap<Integer, String> idAndRule = new HashMap<Integer, String>();


        for(int i = 0; i< Ids.size(); i++){
            idAndRule.put(Ids.get(i), rules.get(i));
        }

        return idAndRule;
    }


}
