package com.bandarproperti.helper;

import android.Manifest;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.bandarproperti.config.Constants;
import com.bandarproperti.models.Customer;

import java.util.HashMap;

/**
 * Created by arief on 05-May-17.
 */

public class SharedPrefHelper {

    private SharedPreferences preferences;
    private Editor editor;

    public SharedPrefHelper(Context context){
        Context context1 = context;
        int PRIVATE_MODE = 0;
        preferences = context.getSharedPreferences(Constants.PrefManager.SHARED_PREFRENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    //Permission
    public void setPermissionStatus(){
        editor.putBoolean(Manifest.permission.ACCESS_FINE_LOCATION, true);
        editor.commit();
    }

    public boolean getPermissionStatus(){
        return preferences.getBoolean(Manifest.permission.ACCESS_FINE_LOCATION, false);
    }

    public boolean isLoggedIn(){
        return preferences.getBoolean(Constants.PrefManager.IS_LOGGED_IN, false);
    }

    public void logOut(){
        editor.putBoolean(Constants.PrefManager.IS_LOGGED_IN, false);
        editor.putInt(Constants.PrefManager.USER_ID, 0);
        editor.putString(Constants.PrefManager.USER_NAME, "");
        editor.putString(Constants.PrefManager.USER_PASSWORD, "");
        editor.putString(Constants.PrefManager.USER_EMAIL, "");
        editor.putString(Constants.PrefManager.USER_PHONE, "");
        editor.putString(Constants.PrefManager.USER_GENDER, "");
        editor.putString(Constants.PrefManager.USER_PICTURE, "");
        editor.putString(Constants.PrefManager.USER_ADDRESS, "");
        editor.putString(Constants.PrefManager.USER_CREATED_AT, "");
        editor.commit();
    }

    public void setLogin(Customer user, boolean isLoggedIn){
        editor.putBoolean(Constants.PrefManager.IS_LOGGED_IN, isLoggedIn);
        editor.putInt(Constants.PrefManager.USER_ID, user.getId());
        editor.putString(Constants.PrefManager.USER_NAME, user.getName());
        editor.putString(Constants.PrefManager.USER_PASSWORD, user.getPassword());
        editor.putString(Constants.PrefManager.USER_EMAIL, user.getEmail());
        editor.putString(Constants.PrefManager.USER_PHONE, user.getPhone());
        editor.putString(Constants.PrefManager.USER_GENDER, user.getGender());
        editor.putString(Constants.PrefManager.USER_PICTURE, user.getPicture());
        editor.putString(Constants.PrefManager.USER_ADDRESS, user.getAddress());
        editor.putString(Constants.PrefManager.USER_CREATED_AT, user.getCreated_at());
        editor.commit();
    }

    public HashMap<String, String> getUseProfile(){
        HashMap<String, String> user = new HashMap<>();

        user.put(Constants.PrefManager.USER_NAME, preferences.getString(Constants.PrefManager.USER_NAME, ""));
        user.put(Constants.PrefManager.USER_EMAIL, preferences.getString(Constants.PrefManager.USER_EMAIL, ""));
        user.put(Constants.PrefManager.USER_PHONE, preferences.getString(Constants.PrefManager.USER_PHONE, ""));
        user.put(Constants.PrefManager.USER_PASSWORD, preferences.getString(Constants.PrefManager.USER_PASSWORD, ""));
        user.put(Constants.PrefManager.USER_GENDER, preferences.getString(Constants.PrefManager.USER_GENDER, ""));
        user.put(Constants.PrefManager.USER_PICTURE, preferences.getString(Constants.PrefManager.USER_PICTURE, ""));
        user.put(Constants.PrefManager.USER_ADDRESS, preferences.getString(Constants.PrefManager.USER_ADDRESS, ""));
        user.put(Constants.PrefManager.USER_CREATED_AT, preferences.getString(Constants.PrefManager.USER_CREATED_AT, ""));

        return user;
    }

    public int getUserId() {
        return preferences.getInt(Constants.PrefManager.USER_ID, 0);
    }

    public void putTransType(int trans_type)
    {
        editor.putInt(Constants.PrefManager.TRANS_TYPE, trans_type);
        editor.commit();
    }

    public int getTransType()
    {
        return preferences.getInt(Constants.PrefManager.TRANS_TYPE, 0);
    }

    public void putBookingData(String date, String time)
    {
        editor.putString(Constants.PrefManager.BOOKING_DATE, date);
        editor.putString(Constants.PrefManager.BOOKING_TIME, time);
        editor.commit();
    }
}
