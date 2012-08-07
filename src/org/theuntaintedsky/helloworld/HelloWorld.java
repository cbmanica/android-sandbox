package org.theuntaintedsky.helloworld;

import android.app.*;
import android.os.*;
import android.view.*;

public class HelloWorld extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
    }
}
