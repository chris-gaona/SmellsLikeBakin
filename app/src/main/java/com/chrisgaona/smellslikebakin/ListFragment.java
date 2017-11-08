package com.chrisgaona.smellslikebakin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chrisgaona on 11/7/17.
 */

public class ListFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // boolean says whether to attach this to the viewgroup...error will be thrown if not used because it will be added twice
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        return view;
    }
}
