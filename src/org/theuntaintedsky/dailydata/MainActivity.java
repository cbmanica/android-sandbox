package org.theuntaintedsky.dailydata;

import android.os.*;
import android.support.v4.app.*;
import android.view.*;
import android.widget.*;
import org.theuntaintedsky.dailydata.data.*;
import org.theuntaintedsky.dailydata.data.table.*;
import org.theuntaintedsky.dailydata.ui.*;

public class MainActivity extends FragmentActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main_activity);

        final DatabaseManager manager = new DatabaseManager(this);
        manager.close();

        TypefaceManager.applyTypeface(getAssets(), TypefaceManager.Types.DEFAULT, (TextView) findViewById(R.id.hello_view));

    }

    public void addDataPoint(View view) {
        final android.content.ContentValues values = new android.content.ContentValues();
        values.put(DataDescriptor.Columns.DESCRIPTION, "Hello, world!");
        getContentResolver().insert(DataDescriptor.URI, values);
    }
}
