package org.theuntaintedsky.dailydata.data.table;

import android.database.sqlite.*;

/**
 * <p/>
 * <!-- insert class description here -->
 *
 * @author <a href="mailto: C. Benson Manica <benson.manica@turner.com>">C. Benson Manica</a>
 * @version $Revision: 1.0 Created 8/9/12 9:55 PM<br/> Copyright 2012 Turner Broadcasting, Inc.<br/> All
 *          rights reserved.<br/>
 */
public class DataDescriptor {
    private static DataDescriptor _instance = null;
    public static final String TABLE = "descriptors";

    public interface Columns {
        static final String ID = "_id";
        static final String DESCRIPTION = "description";
    }

    private DataDescriptor() {
    }

    public static DataDescriptor instance() {
        if (_instance == null) {
            _instance = new DataDescriptor();
        }
        return _instance;
    }

    public void create(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE + "(" +
                Columns.ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                Columns.DESCRIPTION + " VARCHAR );"
        );
    }

    public void upgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // There's nothing to do here yet.
    }
}
