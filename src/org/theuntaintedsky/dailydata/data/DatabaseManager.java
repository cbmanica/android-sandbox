package org.theuntaintedsky.dailydata.data;

import android.content.*;
import android.database.sqlite.*;
import org.theuntaintedsky.dailydata.data.table.*;

/**
 * <p/>
 * <!-- insert class description here -->
 *
 * @author <a href="mailto: C. Benson Manica <benson.manica@turner.com>">C. Benson Manica</a>
 * @version $Revision: 1.0 Created 8/9/12 8:59 PM<br/> Copyright 2012 Turner Broadcasting, Inc.<br/> All
 *          rights reserved.<br/>
 */
public class DatabaseManager extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dd.db";
    private static final int DATABASE_VERSION = 1;

    public DatabaseManager(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        System.out.println("PORK Creating the open helper");
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        DataDescriptor.instance().create(database);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        DataDescriptor.instance().upgrade(db, oldVersion, newVersion);
    }
}
