package com.bandarproperti;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.text.TextUtils;

import com.bandarproperti.helper.NetworkHelper;

/**
 * Created by arief on 08-Apr-17.
 */

public class MyApp extends Application {

    private static MyApp mInstance;

    @Override
    public void onCreate() {
        super.onCreate();

        mInstance = this;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }

    public static synchronized MyApp getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(NetworkHelper.ConnectivityReceiverListener listener) {
        NetworkHelper.connectivityReceiverListener = listener;
    }
}
