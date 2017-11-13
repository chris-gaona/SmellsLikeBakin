package com.chrisgaona.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chrisgaona on 11/13/17.
 */

public class DualPaneFragment extends Fragment {
    private static final String INGREDIENTS_FRAGMENT = "INGREDIENTS_FRAGMENT";
    private static final String DIRECTIONS_FRAGMENT = "DIRECTIONS_FRAGMENT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // gets argument from bundle created on MainActivity
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);

        View view = inflater.inflate(R.layout.fragment_dualpane, container, false);

        Bundle bundle = new Bundle();
        FragmentManager fragmentManager = getChildFragmentManager();

        IngredientsFragment savedIngredientsFragment = (IngredientsFragment) fragmentManager.findFragmentByTag(INGREDIENTS_FRAGMENT);
        if (savedIngredientsFragment == null) {
            // if it is null, create a new one
            IngredientsFragment ingredientsFragment = new IngredientsFragment();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            ingredientsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.leftPlaceholder, ingredientsFragment, INGREDIENTS_FRAGMENT)
                    .commit();
        }

        DirectionsFragment savedDirectionsFragment = (DirectionsFragment) fragmentManager.findFragmentByTag(DIRECTIONS_FRAGMENT);
        if (savedDirectionsFragment == null) {
            // if it is null, create a new one
            DirectionsFragment directionsFragment = new DirectionsFragment();
            bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
            directionsFragment.setArguments(bundle);
            fragmentManager.beginTransaction()
                    .add(R.id.rightPlaceholder, directionsFragment, DIRECTIONS_FRAGMENT)
                    .commit();
        }

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        // resets the title name on fragment stop
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
