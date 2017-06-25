package com.t3h.nitefoodie.common;

import android.app.Application;
import android.content.Context;

/**
 * Created by thinhquan on 6/24/17.
 */

public class MVPApp extends Application{
    private static Context mContextApp;

    @Override
    public void onCreate() {
        super.onCreate();
        mContextApp = this;
    }

    public static Context getContextApp() {
        return mContextApp;
    }
}
