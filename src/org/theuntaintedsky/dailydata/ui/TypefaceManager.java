package org.theuntaintedsky.dailydata.ui;

import android.content.res.*;
import android.graphics.*;
import android.util.*;
import android.widget.*;

import java.util.*;
import java.util.concurrent.*;

/**
 * <p/>
 * This class highlights a major deficiency in the Android framework.
 *
 * @author <a href="mailto: C. Benson Manica <benson.manica@turner.com>">C. Benson Manica</a>
 * @version $Revision: 1.0 Created 8/11/12 10:41 AM<br/> Copyright 2012 Turner Broadcasting, Inc.<br/> All
 *          rights reserved.<br/>
 */
public class TypefaceManager {
    public enum Types {
        DEFAULT, DEFAULT_LARGE
    }

    private static final Map<Types, Typeface> hash = new ConcurrentHashMap<Types, Typeface>(new EnumMap<Types, Typeface>(Types.class));

    public static Typeface getTypeface(AssetManager manager, Types type) {
        Typeface ret = hash.get(type);
        if (ret == null) {
            if (manager == null) {
                throw new IllegalStateException("Asset manager not passed and typeface not cached");
            }
            switch (type) {
                case DEFAULT:
                case DEFAULT_LARGE:
                default:
                    ret = Typeface.createFromAsset(manager, "league_gothic.ttf");
                    break;
            }
            hash.put(type, ret);
        }
        return ret;
    }

    public static void applyTypeface(AssetManager manager, Types type, TextView... textViews) {
        for (TextView textView : textViews) {
            textView.setTypeface(getTypeface(manager, type));
            switch (type) {
                case DEFAULT:
                default:
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PT, 10);
                    break;
                case DEFAULT_LARGE:
                    textView.setTextSize(TypedValue.COMPLEX_UNIT_PT, 14);
                    break;
            }
        }
    }
}

