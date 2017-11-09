package com.chrisgaona.smellslikebakin;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface {

    public static final String LIST_FRAGMENT = "LIST_FRAGMENT";
    public static final String VIEWPAGER_FRAGMENT = "VIEWPAGER_FRAGMENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // this following line makes sure we have access to variables and other stuff we need from our mainactivity
        // uses keys now for fragments LIST_FRAGMENT
        ListFragment savedFragment = (ListFragment) getFragmentManager().findFragmentByTag(LIST_FRAGMENT);

        // if we didn't have this savedInstanceState check...
        // when we rotate the app it will create a new fragment over the old fragment every time
        if (savedFragment == null) {
            ListFragment fragment = new ListFragment();
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            // uses keys now for fragments LIST_FRAGMENT
            fragmentTransaction.add(R.id.placeHolder, fragment, LIST_FRAGMENT);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onListRecipeSelected(int index) {
        ViewPagerFragment fragment = new ViewPagerFragment();

        // creates bundle
        Bundle bundle = new Bundle();
        bundle.putInt(ViewPagerFragment.KEY_RECIPE_INDEX, index);
        fragment.setArguments(bundle);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // use replace to change to another fragment
        // uses keys now for fragments VIEWPAGER_FRAGMENT
        fragmentTransaction.replace(R.id.placeHolder, fragment, VIEWPAGER_FRAGMENT);
        // use addToBackStack method to stack fragment on top of each other
        // so the back button can be used to go to the last fragment on the stack
        // pass in null because we will only need to go back one transaction at a time
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
