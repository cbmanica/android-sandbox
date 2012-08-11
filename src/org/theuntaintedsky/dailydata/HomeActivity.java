package org.theuntaintedsky.dailydata;

import android.database.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.content.*;
import android.view.*;
import android.widget.*;
import org.theuntaintedsky.dailydata.data.*;
import org.theuntaintedsky.dailydata.data.table.*;
import org.theuntaintedsky.dailydata.ui.*;

public class HomeActivity extends android.app.Activity implements LoaderManager.LoaderCallbacks<Cursor> {
    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return null;  // TODO
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        // TODO
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        // TODO
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);

        final DatabaseManager manager = new DatabaseManager(this);
        manager.close();

        // Create an empty adapter we will use to display the loaded data.
//        mAdapter = new SimpleCursorAdapter(getActivity(),
//                android.R.layout.simple_list_item_2, null,
//                new String[]{},
//                new int[]{android.R.id.text1, android.R.id.text2}, 0);
        CursorLoader foo;
        final Cursor cursor = getContentResolver().query(DataDescriptor.URI, new String[]{DataDescriptor.Columns.DESCRIPTION}, null, null, null);
        final android.content.ContentValues values = new android.content.ContentValues();
        values.put(DataDescriptor.Columns.DESCRIPTION, "Hello, world!");
        getContentResolver().insert(DataDescriptor.URI, values);
        cursor.requery(); // sigh, they changed everything I knew...
        TypefaceManager.applyTypeface(getAssets(), TypefaceManager.Types.DEFAULT_LARGE, (TextView) findViewById(R.id.hello_view));
    }
}
