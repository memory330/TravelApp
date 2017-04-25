package com.wxmylife.betty.base.base;

import android.app.Application;

/**
 * Created by wxmylife on 2017/4/20.
 */

public class BaseApplication extends Application {


    public static BaseApplication mInstance;

    @Override public void onCreate() {
        super.onCreate();
        mInstance = this;

    }


    public static BaseApplication getInstance() {

        return mInstance;
    }
}
