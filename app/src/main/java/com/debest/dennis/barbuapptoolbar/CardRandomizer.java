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
        rulesArray.add(context.getString(R.string.card_clubs_ace)); //Ace
        rulesArray.add(context.getString(R.string.card_clubs_2)); // 2
        rulesArray.add(context.getString(R.string.cards_clubs_3)); // 3
        rulesArray.add(context.getString(R.string.card_clubs_4)); // 4
        rulesArray.add(context.getString(R.string.cards_clubs_5)); // 5
        rulesArray.add(context.getString(R.string.cards_clubs_6)); // 6
        rulesArray.add(context.getString(R.string.cards_clubs_7)); // 7
        rulesArray.add(context.getString(R.string.cards_clubs_8)); // 8
        rulesArray.add(context.getString(R.string.cards_clubs_9)); //9
        rulesArray.add(context.getString(R.string.cards_clubs_10)); //10
        rulesArray.add(context.getString(R.string.cards_clubs_jack)); //jack
        rulesArray.add(context.getString(R.string.cards_clubs_queen)); // queen
        rulesArray.add(context.getString(R.string.cards_clubs_king)); //king

        //Diamonds
        rulesArray.add(context.getString(R.string.card_diamonds_ace)); //Ace
        rulesArray.add(context.getString(R.string.card_diamonds_2)); // 2
        rulesArray.add(context.getString(R.string.cards_diamonds_3)); // 3
        rulesArray.add(context.getString(R.string.card_diamonds_4)); // 4
        rulesArray.add(context.getString(R.string.cards_diamonds_5)); // 5
        rulesArray.add(context.getString(R.string.cards_diamonds_6)); // 6
        rulesArray.add(context.getString(R.string.cards_diamonds_7)); // 7
        rulesArray.add(context.getString(R.string.cards_diamonds_8)); // 8
        rulesArray.add(context.getString(R.string.cards_diamonds_9)); //9
        rulesArray.add(context.getString(R.string.cards_diamonds_10)); //10
        rulesArray.add(context.getString(R.string.cards_diamonds_jack)); //jack
        rulesArray.add(context.getString(R.string.cards_diamonds_queen)); // queen
        rulesArray.add(context.getString(R.string.cards_diamonds_king)); //king

        //Hearts
        rulesArray.add(context.getString(R.string.card_hearts_ace)); //Ace
        rulesArray.add(context.getString(R.string.card_hearts_2)); // 2
        rulesArray.add(context.getString(R.string.cards_hearts_3)); // 3
        rulesArray.add(context.getString(R.string.card_hearts_4)); // 4
        rulesArray.add(context.getString(R.string.cards_hearts_5)); // 5
        rulesArray.add(context.getString(R.string.cards_hearts_6)); // 6
        rulesArray.add(context.getString(R.string.cards_hearts_7)); // 7
        rulesArray.add(context.getString(R.string.cards_hearts_8)); // 8
        rulesArray.add(context.getString(R.string.cards_hearts_9)); //9
        rulesArray.add(context.getString(R.string.cards_hearts_10)); //10
        rulesArray.add(context.getString(R.string.cards_hearts_jack)); //jack
        rulesArray.add(context.getString(R.string.cards_hearts_queen)); // queen
        rulesArray.add(context.getString(R.string.cards_hearts_king)); //king

        //Spades
        rulesArray.add(context.getString(R.string.card_spades_ace)); //Ace
        rulesArray.add(context.getString(R.string.card_spades_2)); // 2
        rulesArray.add(context.getString(R.string.cards_spades_3)); // 3
        rulesArray.add(context.getString(R.string.card_spades_4)); // 4
        rulesArray.add(context.getString(R.string.cards_spades_5)); // 5
        rulesArray.add(context.getString(R.string.cards_spades_6)); // 6
        rulesArray.add(context.getString(R.string.cards_spades_7)); // 7
        rulesArray.add(context.getString(R.string.cards_spades_8)); // 8
        rulesArray.add(context.getString(R.string.cards_spades_9)); //9
        rulesArray.add(context.getString(R.string.cards_spades_10)); //10
        rulesArray.add(context.getString(R.string.cards_spades_jack)); //jack
        rulesArray.add(context.getString(R.string.cards_spades_queen)); // queen
        rulesArray.add(context.getString(R.string.cards_spades_king)); //king
        //Joker
        rulesArray.add(context.getString(R.string.cards_joker));

    return rulesArray;
    }

}
