package org.theuntaintedsky.dailydata;

import android.database.*;
import android.os.*;
import android.support.v4.app.*;
import android.support.v4.content.*;
import android.support.v4.widget.CursorAdapter;
import android.support.v4.widget.SimpleCursorAdapter;
import android.view.*;
import android.widget.*;
import org.theuntaintedsky.dailydata.data.table.*;
import org.theuntaintedsky.dailydata.ui.*;

/**
 * <p/>
 * <!-- insert class description here -->
 *
 * @author <a href="mailto: C. Benson Manica <benson.manica@turner.com>">C. Benson Manica</a>
 * @version $Revision: 1.0 Created 8/11/12 2:26 PM<br/> Copyright 2012 Turner Broadcasting, Inc.<br/> All
 *          rights reserved.<br/>
 */
public class HomeFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener {
    private CursorAdapter adapter;

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        return new CursorLoader(getActivity(), DataDescriptor.URI, new String[]{DataDescriptor.Columns.ID, DataDescriptor.Columns.DESCRIPTION}, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor cursor) {
        // Swap the new cursor in.  (The framework will take care of closing the
        // old cursor once we return.)
        adapter.swapCursor(cursor);

        // The list should now be shown.
//        if (isResumed()) {
//            setListShown(true);
//        } else {
//            setListShownNoAnimation(true);
//        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        adapter.swapCursor(null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, android.view.ViewGroup container, Bundle savedInstanceState) {
        final View ret = inflater.inflate(R.layout.home_fragment, container, false);
        TypefaceManager.applyTypeface(getActivity().getAssets(), TypefaceManager.Types.DEFAULT, (TextView) ret.findViewById(R.id.home_add_button));
        return ret;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Give some text to display if there is no data.  In a real
        // application this would come from a resource.
//        setEmptyText("You have no collections.  Add some!");

        // We have a menu item to show in action bar.
//        setHasOptionsMenu(true);

        adapter = new SimpleCursorAdapter(getActivity(),
                R.layout.home_fragment_list_item, null,
                new String[]{DataDescriptor.Columns.DESCRIPTION},
                new int[]{R.id.home_fragment_list_description}, 0);
        setListAdapter(adapter);
//        setListShown(false);
        getLoaderManager().initLoader(0, null, this);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        final Cursor cursor = adapter.getCursor();
        cursor.moveToPosition(i);
        ((MainActivity) getActivity()).loadEditCollectionFragment(cursor.getInt(0));
    }
}
