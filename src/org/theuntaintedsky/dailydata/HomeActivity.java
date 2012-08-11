package org.theuntaintedsky.dailydata;

import android.app.*;
import android.content.*;
import android.database.*;
import android.os.*;
import android.view.*;
import org.theuntaintedsky.dailydata.data.*;
import org.theuntaintedsky.dailydata.data.table.*;

public class HomeActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        final DatabaseManager manager = new DatabaseManager(this);
        manager.close();
        final Cursor cursor = getContentResolver().query(DataDescriptor.URI, new String[]{DataDescriptor.Columns.DESCRIPTION}, null, null, null);
        System.out.println("PORK 1 it worked?  Got back " + cursor.getCount());
        final ContentValues values = new ContentValues();
        values.put(DataDescriptor.Columns.DESCRIPTION, "Hello, world!");
        getContentResolver().insert(DataDescriptor.URI, values);
        cursor.requery(); // sigh, they changed everything I knew...
        System.out.println("PORK 2 it worked?  Got back " + cursor.getCount());
    }
}
