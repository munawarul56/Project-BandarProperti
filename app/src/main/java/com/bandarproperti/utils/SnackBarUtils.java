package com.bandarproperti.utils;

import android.app.Activity;
import android.support.design.widget.Snackbar;
import android.view.View;

/**
 * Created by arief on 14-Oct-16.
 */

public class SnackBarUtils {
    private static SnackBarUtils mInstance = null;
    private Snackbar mSnackBar;

    public SnackBarUtils() {
    }

    public static SnackBarUtils getInstance() {
        if (mInstance == null) {
            mInstance = new SnackBarUtils();
        }
        return mInstance;
    }

    public void hideSnackBar() {
        if (mSnackBar != null && mSnackBar.isShown()) {
            mSnackBar.dismiss();
        }
    }

    public void showSnackBar(Activity activity, String message) {
        mSnackBar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View sbView = mSnackBar.getView();
        mSnackBar.show();
    }

    public void showErrorSnackBar(Activity activity, String message) {
        mSnackBar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);
        View sbView = mSnackBar.getView();
        sbView.setBackgroundResource(android.R.color.holo_red_light);
        mSnackBar.show();
    }
}

