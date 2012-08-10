package org.theuntaintedsky.dailydata.data.provider;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.net.*;
import org.theuntaintedsky.dailydata.data.*;

/**
 * <p/>
 * <!-- insert class description here -->
 *
 * @author <a href="mailto: C. Benson Manica <benson.manica@turner.com>">C. Benson Manica</a>
 * @version $Revision: 1.0 Created 8/9/12 9:47 PM<br/> Copyright 2012 Turner Broadcasting, Inc.<br/> All
 *          rights reserved.<br/>
 */
public class DataDescriptorProvider extends ContentProvider {
    private static final String AUTHORITY = "org.theuntaintedsky.dailydata.provider." + DataDescriptorProvider.class.getSimpleName();
    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);

    private static final int DESCRIPTORS = 1;
    private static final int CHOICES = 2;
    private static final int POINTS = 3;

    static {
        uriMatcher.addURI(AUTHORITY, "descriptors", DESCRIPTORS);
    }

    private DatabaseManager manager = null;

    @Override
    public boolean onCreate() {
        return false;  // TODO
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        System.out.println("PORK Querying the provider");
        final SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        switch (uriMatcher.match(uri)) {
            case DESCRIPTORS:
                break;
            default:
                throw new IllegalArgumentException("Unknown URI " + uri);
        }

        final SQLiteDatabase db = manager.getReadableDatabase();
        final Cursor c = qb.query(db, projection, selection, selectionArgs, null, null, sortOrder);

        c.setNotificationUri(getContext().getContentResolver(), uri);
        return c;
    }

    @Override
    public String getType(Uri uri) {
        return null;  // TODO
    }

    @Override
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;  // TODO
    }

    @Override
    public int delete(Uri uri, String s, String[] strings) {
        return 0;  // TODO
    }

    @Override
    public int update(Uri uri, ContentValues contentValues, String s, String[] strings) {
        return 0;  // TODO
    }

    protected void obtain() {
        if (manager == null) {
            manager = new DatabaseManager(getContext());
        }
    }

    public void release() {
        manager.close();
        manager = null;
    }
}
