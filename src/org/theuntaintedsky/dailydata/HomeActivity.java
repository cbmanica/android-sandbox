package org.theuntaintedsky.dailydata;

import android.app.*;
import android.os.*;
import android.view.*;
import org.theuntaintedsky.dailydata.data.*;

public class HomeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        // TODO do the query
        final DatabaseManager openHelper = new DatabaseManager(this);
    }
}
