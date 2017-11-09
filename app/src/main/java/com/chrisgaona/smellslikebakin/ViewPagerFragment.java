package com.chrisgaona.smellslikebakin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by chrisgaona on 11/9/17.
 */

public class ViewPagerFragment extends Fragment {

    public static final String KEY_RECIPE_INDEX = "KEY_RECIPE_INDEX";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // gets argument from bundle created on MainActivity
        int index = getArguments().getInt(KEY_RECIPE_INDEX);
        getActivity().setTitle(Recipes.names[index]);

        View view = inflater.inflate(R.layout.fragment_viewpager, container, false);
        return view;
    }

    @Override
    public void onStop() {
        super.onStop();
        // resets the title name on fragment stop
        getActivity().setTitle(getResources().getString(R.string.app_name));
    }
}
