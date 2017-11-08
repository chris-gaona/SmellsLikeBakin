package com.chrisgaona.smellslikebakin;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chrisgaona on 11/7/17.
 */

public class ListFragment extends Fragment {

    public interface OnRecipeSelectedInterface {
        void onListRecipeSelected(int index);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        // adding a simple listener for the onClick
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        // boolean says whether to attach this to the viewgroup...error will be thrown if not used because it will be added twice
        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.listRecyclerView);

        // passes listener into the ListAdapter
        ListAdapter listAdapter = new ListAdapter(listener);
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        // attach layout manager to recycler view
        recyclerView.setLayoutManager(layoutManager);

        return view;
    }
}
