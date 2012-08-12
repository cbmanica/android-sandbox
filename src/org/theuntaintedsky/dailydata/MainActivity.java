package org.theuntaintedsky.dailydata;

import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import org.theuntaintedsky.dailydata.data.*;

public class MainActivity extends FragmentActivity {
    private Fragment homeFragment = null;
    private Fragment editCollectionFragment = null;
    private boolean homeInserted = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);

        final DatabaseManager manager = new DatabaseManager(this);
        manager.close();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        homeInserted = false;
        homeFragment = null;
        editCollectionFragment = null;
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (!homeInserted) {
            homeFragment = new HomeFragment();
            final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.main_fragment_container, homeFragment, "home");
            transaction.commit();
            homeInserted = true;
        }
    }

    public void addDataPoint(View view) {
//        final android.content.ContentValues values = new android.content.ContentValues();
//        values.put(DataDescriptor.Columns.DESCRIPTION, "Hello, world!");
//        getContentResolver().insert(DataDescriptor.URI, values);
        loadEditCollectionFragment();
    }

    protected void loadEditCollectionFragment() {
        if (editCollectionFragment == null) {
            editCollectionFragment = new EditCollectionFragment();
        }
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
//        transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left);
        transaction.remove(homeFragment);
        transaction.add(R.id.main_fragment_container, editCollectionFragment, "editCollection");
        transaction.addToBackStack("tag").commit();
    }
}
