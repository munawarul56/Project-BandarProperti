package com.bandarproperti.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.bandarproperti.R;
import com.bandarproperti.SignInActivity;
import com.bandarproperti.config.Constants;

/**
 * Created by arief on 03-May-17.
 */

public class MessageDialogUtils {
    private Context context;

    public MessageDialogUtils(Context context){
        this.context = context;
    }

    public void showRequestPermissionDialog(String title, String message, final String[] permission, final int requestCode){
        LayoutInflater layoutInflater = LayoutInflater.from((Activity) context);
        View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder((Activity) context);
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setCancelable(false);

        TextView titleText = (TextView) promptView.findViewById(R.id.title);
        titleText.setText(title);

        TextView messageText = (TextView) promptView.findViewById(R.id.message);
        messageText.setText(message);
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
                ActivityCompat.requestPermissions((Activity) context, permission, requestCode);
            }
        });

        alertDialogBuilder.show();
    }

    public void showRequestPermissionDialogWithSetting(){
        LayoutInflater layoutInflater = LayoutInflater.from((Activity) context);
        View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder((Activity) context);
        alertDialogBuilder.setView(promptView);

        TextView titleText = (TextView) promptView.findViewById(R.id.title);
        titleText.setText("Pesan Permission");

        TextView messageText = (TextView) promptView.findViewById(R.id.message);
        messageText.setText("Aplikasi ini membutuhkan izin Lokasi, Penyimpanan, SMS dan Telepon");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                Intent intent = new Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                Uri uri = Uri.fromParts("package", ((Activity) context).getApplication().getPackageName(), null);
                intent.setData(uri);
                ((Activity) context).startActivityForResult(intent, Constants.PermissionCode.PERMISSION_SETTING_CODE);
            }
        });
        alertDialogBuilder.show();
    }

    public void showDialogPermissionWarning(){
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Pesan Permission");
        builder.setMessage("Aplikasi tidak memiliki izin untuk melakukan tindakan ini");
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alert = builder.create();
        alert.show();
    }

    public void showDialogPermissionLocation(){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptView);

        TextView title = (TextView) promptView.findViewById(R.id.title);
        title.setText("Pesan Permission");

        TextView message = (TextView) promptView.findViewById(R.id.message);
        message.setText("Izin lokasi diperlukan untuk menggunakan lokasi perangkat");

        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
                ActivityCompat.requestPermissions((Activity) context, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, Constants.PermissionCode.PERMISSION_REQUEST_CODE);
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void noInternetDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptView);

        alertDialogBuilder.setCancelable(false);

        TextView title = (TextView) promptView.findViewById(R.id.title);
        title.setText("Tidak ada koneksi internet!");

        TextView message = (TextView) promptView.findViewById(R.id.message);
        message.setText("Anda tidak terhubung ke internet, pastikan Wi-Fi atau mobile data diaktifkan!");

        alertDialogBuilder.setPositiveButton("COBA LAGI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = context.getPackageManager()
                        .getLaunchIntentForPackage( context.getPackageName() );
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void noLocationEnabledDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptView);

        TextView title = (TextView) promptView.findViewById(R.id.title);
        title.setText("Izinkan Aplikasi ini mengakses lokasi Anda saat Anda menggunakan aplikasi ini?");

        TextView message = (TextView) promptView.findViewById(R.id.message);
        message.setText("Lokasi Anda akan digunakan dalam layanan Aplikasi ini seperti pencarian, petunjuk arah, dan navigasi");

        alertDialogBuilder.setCancelable(false);

        alertDialogBuilder.setPositiveButton("Izinkan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                context.startActivity(intent);
            }
        });

        alertDialogBuilder.setNegativeButton("Jangan Izinkan", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void showInternetDialog(){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setCancelable(false);

        TextView title = (TextView) promptView.findViewById(R.id.title);
        title.setText("Tidak ada koneksi internet!");

        TextView message = (TextView) promptView.findViewById(R.id.message);
        message.setText("Anda tidak terhubung ke internet, pastikan pemilik wifi atau mobile diaktifkan!");

        alertDialogBuilder.setPositiveButton("COBA LAGI", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = context.getPackageManager()
                        .getLaunchIntentForPackage( context.getPackageName() );
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        });

        alertDialogBuilder.setNegativeButton("KELUAR", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                System.exit(0);
            }
        });

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void showStandartMessageDialog(String title, String message) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setCancelable(false);

        TextView titleText = (TextView) promptView.findViewById(R.id.title);
        titleText.setText(title);

        TextView messageText = (TextView) promptView.findViewById(R.id.message);
        messageText.setText(message);

        alertDialogBuilder.setPositiveButton("OK", (dialogInterface, i) -> dialogInterface.dismiss());

        AlertDialog alert = alertDialogBuilder.create();
        alert.show();
    }

    public void showRequiredLoginDialog(final Context context){
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View promptView = layoutInflater.inflate(R.layout.login_dialogbox, null);
        final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setView(promptView);
        alertDialogBuilder.setCancelable(false);

        Button buttonOK = (Button) promptView.findViewById(R.id.btnLogin);
        Button buttonCancel = (Button) promptView.findViewById(R.id.btnCancel);

        final AlertDialog alert = alertDialogBuilder.create();

        buttonOK.setOnClickListener(view -> {
            alert.dismiss();
            context.startActivity(new Intent(context, SignInActivity.class));
        });

        buttonCancel.setOnClickListener(view -> {
            alert.dismiss();
        });

        alert.show();
    }
}
