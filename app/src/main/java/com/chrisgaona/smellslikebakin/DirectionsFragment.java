package com.chrisgaona.smellslikebakin;

/**
 * Created by chrisgaona on 11/10/17.
 */

public class DirectionsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.directions[index].split("`");
    }
}
