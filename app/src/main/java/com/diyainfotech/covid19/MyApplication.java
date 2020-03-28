package com.diyainfotech.covid19;

import android.app.Application;
import android.content.Context;

/**
 * @author sanjaypatel
 */
public class MyApplication extends Application {
    private static MyApplication application;

    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }
    public static MyApplication getApplication() {
        return application;
    }
    public static Context getAppContext() {
        return application.getApplicationContext();
    }

}
