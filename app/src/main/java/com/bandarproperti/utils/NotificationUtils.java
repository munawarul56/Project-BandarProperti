package com.bandarproperti.utils;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import com.bandarproperti.R;
import com.bandarproperti.activity.MainActivity;

/**
 * Created by arief on 11-Jul-17.
 */

public class NotificationUtils {

    private Context context;

    NotificationCompat.Builder notification;
    NotificationManager notificationManager;
    private PendingIntent pendingIntent;

    public NotificationUtils(Context context){
        this.context = context;

        notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notification = new NotificationCompat.Builder(context);
        pendingIntent = PendingIntent.getActivity(context, 0, new Intent(context, MainActivity.class), PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public void showNotification(String title, String message){
        notification.setSmallIcon(R.mipmap.ic_launcher);
        notification.setContentTitle(title);
        notification.setContentText(message);
        notification.setContentIntent(pendingIntent);
        notification.setAutoCancel(true);
        notificationManager.notify(0, notification.build());
    }
}
