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

    //Get IDs method for populating an arrayList with the ressources IDs of all cards by using their names
    public ArrayList<Integer> getIDs(Context context){
        //set up an arraylist for the result to be returned
        ArrayList<Integer> res = new ArrayList<>();

        //set-up variables to cycle through every drawable ressource
        final R.drawable drawableResources = new R.drawable();
        final Class<R.drawable> c = R.drawable.class;
        final Field[] fields = c.getDeclaredFields();

        for (int i = 0, max = fields.length; i < max; i++) {
            final int resourceId;
            try {
                resourceId = fields[i].getInt(drawableResources);
                String name = context.getResources().getResourceEntryName(resourceId);
                //Use regex to filter out system ressources
                if (name.matches("(club|diamond|hearts|spades|x_joker).*"))
                    res.add(resourceId);
            } catch (Exception e) {
                continue;
            }
        }


        //return the resulting array
        return res;
    }
    //method for populating an arraylist of strings with the rules
    public ArrayList<String> getRules(Context context){
        ArrayList<String> rulesArray = new ArrayList<>();
        //Clubs
        rulesArray.add("Bois un cul sec"); //Ace
        rulesArray.add("Bois 2 gorgées"); // 2
        rulesArray.add("Bois 3 gorgées"); // 3
        rulesArray.add("Bois 4 gorgées"); // 4
        rulesArray.add("Bois 5 gorgées"); // 5
        rulesArray.add("Bois 6 gorgées"); // 6
        rulesArray.add("Dans ma valise"); // 7
        rulesArray.add("J'ai déja"); // 8
        rulesArray.add("Invente une règle"); //9
        rulesArray.add("Une suite"); //10
        rulesArray.add("Tu est le roi des pouces"); //jack
        rulesArray.add("Les dames boivent"); // queen
        rulesArray.add("Les hommes boivent"); //king

        //Diamonds
        rulesArray.add("Distribues un cul sec"); //Ace
        rulesArray.add("Distribues 2 gorgées"); // 2
        rulesArray.add("Distribues 3 gorgées"); // 3
        rulesArray.add("Distribues 4 gorgées"); // 4
        rulesArray.add("Distribues 5 gorgées"); // 5
        rulesArray.add("Distribues 6 gorgées"); // 6
        rulesArray.add("Dans ma valise"); // 7
        rulesArray.add("Je n'ai jamais"); // 8
        rulesArray.add("Invente une règle"); //9
        rulesArray.add("Une suite"); //10
        rulesArray.add("Tu est le roi des pouces"); //jack
        rulesArray.add("Les dames boivent"); // queen
        rulesArray.add("Les hommes boivent"); //king
        //Hearts
        rulesArray.add("Distribues un cul sec"); //Ace
        rulesArray.add("Distribues 2 gorgées"); // 2
        rulesArray.add("Distribues 3 gorgées"); // 3
        rulesArray.add("Distribues 4 gorgées"); // 4
        rulesArray.add("Distribues 5 gorgées"); // 5
        rulesArray.add("Distribues 6 gorgées"); // 6
        rulesArray.add("Dans ma valise"); // 7
        rulesArray.add("Je n'ai jamais"); // 8
        rulesArray.add("Invente une règle"); //9
        rulesArray.add("Une suite"); //10
        rulesArray.add("Tu est le roi des pouces"); //jack
        rulesArray.add("Les dames boivent"); // queen
        rulesArray.add("Les hommes boivent"); //king
        //Spades
        rulesArray.add("Bois un cul sec"); //Ace
        rulesArray.add("Bois 2 gorgées"); // 2
        rulesArray.add("Bois 3 gorgées"); // 3
        rulesArray.add("Bois 4 gorgées"); // 4
        rulesArray.add("Bois 5 gorgées"); // 5
        rulesArray.add("Bois 6 gorgées"); // 6
        rulesArray.add("Dans ma valise"); // 7
        rulesArray.add("J'ai déja"); // 8
        rulesArray.add("Invente une règle"); //9
        rulesArray.add("Une suite"); //10
        rulesArray.add("Tu est le roi des pouces"); //jack
        rulesArray.add("Les dames boivent"); // queen
        rulesArray.add("Les hommes boivent"); //king
        //Joker
        rulesArray.add("cul sec général");

    return rulesArray;
    }

}
