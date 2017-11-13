package com.chrisgaona.smellslikebakin;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chrisgaona on 11/13/17.
 */

public class GridFragment extends Fragment {

    public interface OnRecipeSelectedInterface {
        void onGridRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // adding a simple listener for the onClick
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        // boolean says whether to attach this to the viewgroup...error will be thrown if not used because it will be added twice
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        // passes listener into the ListAdapter
        GridAdapter gridAdapter = new GridAdapter(listener);
        recyclerView.setAdapter(gridAdapter);

        // DisplayMetrics gives us information of display such as size & density
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        // complicated way to calculate how much space each column should take up on tablet
        // stores width of device in density pixels
        // density are pixels over dp
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        // divide the device width by 200, which is the set width of our grid_item layout item
        int numColumns = (int) (dpWidth / 200);

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity(), numColumns);
        // attach layout manager to recycler view
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
