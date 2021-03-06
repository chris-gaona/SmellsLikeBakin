package com.chrisgaona.smellslikebakin;

/**
 * Created by chrisgaona on 11/8/17.
 */

public class ListAdapter extends RecyclerAdapter {

    // moved much of the functionality to RecyclerAdapter
    private final ListFragment.OnRecipeSelectedInterface mListener;

    //unique to ListAdapter is the following:
    // 1. listener
    // 2. layout id
    // 3. what to do when recipe is clicked
    public ListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.list_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onListRecipeSelected(index);
    }
}
