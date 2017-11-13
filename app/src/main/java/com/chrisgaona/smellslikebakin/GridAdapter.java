package com.chrisgaona.smellslikebakin;

/**
 * Created by chrisgaona on 11/13/17.
 */

public class GridAdapter extends RecyclerAdapter {

    // moved much of the functionality to RecyclerAdapter
    private final GridFragment.OnRecipeSelectedInterface mListener;

    //unique to ListAdapter is the following:
    // 1. listener
    // 2. layout id
    // 3. what to do when recipe is clicked
    public GridAdapter(GridFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.grid_item;
    }

    @Override
    protected void onRecipeSelected(int index) {
        mListener.onGridRecipeSelected(index);
    }
}
