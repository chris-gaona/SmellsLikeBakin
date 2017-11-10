package com.chrisgaona.smellslikebakin;

/**
 * Created by chrisgaona on 11/10/17.
 */

public class IngredientsFragment extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
