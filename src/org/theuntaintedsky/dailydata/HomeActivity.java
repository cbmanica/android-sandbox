package org.theuntaintedsky.dailydata;

import android.app.*;
import android.content.*;
import android.content.res.*;
import android.database.*;
import android.graphics.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.widget.*;
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
        final AssetManager assetManager = getAssets();
        final Typeface lg = Typeface.createFromAsset(assetManager, "league_gothic.ttf");
        ((TextView) findViewById(R.id.hello_view)).setTypeface(lg);
        ((TextView) findViewById(R.id.hello_view)).setTextSize(TypedValue.COMPLEX_UNIT_PT, 16);

    }
}
