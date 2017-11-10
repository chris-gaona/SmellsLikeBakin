package com.chrisgaona.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chrisgaona on 11/9/17.
 */

public class ViewPagerFragment extends Fragment {

    public static final String KEY_RECIPE_INDEX = "KEY_RECIPE_INDEX";
    public static final String KEY_IS_INGREDIENTS = "KEY_IS_INGREDIENTS";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // gets argument from bundle created on MainActivity
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);

        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);

        Bundle bundle = new Bundle();
        final CheckBoxesFragment ingredientsFragment = new CheckBoxesFragment();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        bundle.putBoolean(KEY_IS_INGREDIENTS, true);
        ingredientsFragment.setArguments(bundle);

        final CheckBoxesFragment directionsFragment = new CheckBoxesFragment();
        bundle.putInt(KEY_RECIPE_INDEX, index);
        bundle.putBoolean(KEY_IS_INGREDIENTS, false);
        directionsFragment.setArguments(bundle);

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        // dealing with fragments within fragments...need to use childFragmentManager
        viewPager.setAdapter(new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public android.support.v4.app.Fragment getItem(int position) {
                return position == 0 ? ingredientsFragment : directionsFragment;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return position == 0 ? "Ingredients" : "Directions";
            }

            @Override
            public int getCount() {
                // viewpager hosts 2 fragment (ingredients or directions)
                return 2;
            }
        });

        // wires up tabLayout with viewPager
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(viewPager);

        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        // resets the title name on fragment stop
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
