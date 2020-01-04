package com.bandarproperti.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.bandarproperti.MyApp;
import com.bandarproperti.config.RequestInterface;
import com.bandarproperti.helper.CurrencyFormatHelper;
import com.bandarproperti.helper.DateFormatHelper;
import com.bandarproperti.helper.MyHelper;
import com.bandarproperti.helper.NetworkHelper;
import com.bandarproperti.helper.SharedPrefHelper;
import com.bandarproperti.request.ApiClient;
import com.bandarproperti.utils.MessageDialogUtils;
import com.bandarproperti.utils.NotificationUtils;

public class BaseActivity extends AppCompatActivity implements NetworkHelper.ConnectivityReceiverListener {

    public RequestInterface serviceInterface, requestInterface;
    public ApiClient apiClient;
    public SharedPrefHelper preference;

    public CurrencyFormatHelper currencyFormatHelper;
    public DateFormatHelper dateFormatHelper;

    public Bundle bundle;

    public MessageDialogUtils messageDialogUtils;
    public NotificationUtils notificationUtils;
    public ProgressDialog progressDialog;
    public MyHelper myHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiClient = new ApiClient(this);
        serviceInterface = ApiClient.createService(RequestInterface.class);
        requestInterface = apiClient.getClient().create(RequestInterface.class);

        preference = new SharedPrefHelper(this);

        currencyFormatHelper = new CurrencyFormatHelper();
        dateFormatHelper = new DateFormatHelper();

        messageDialogUtils = new MessageDialogUtils(this);
        notificationUtils = new NotificationUtils(this);
        bundle = getIntent().getExtras();

        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        myHelper = new MyHelper();

        checkConnection();
    }

    @Override
    protected void onResume() {
        super.onResume();

        MyApp.getInstance().setConnectivityListener(this);

        checkConnection();
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        isConnected(isConnected);
    }

    private void checkConnection() {
        isConnected(NetworkHelper.isConnected());
    }

    private void isConnected(final boolean isConnected) {
        if (!isConnected) {
            if(!isFinishing()){
                messageDialogUtils.noInternetDialog();
            }
        }
    }

//    public void goHome(){
//        Intent mainIntent = new Intent(this, MainActivity.class);
//        startActivity(mainIntent);
//    }
//
//    public void goLogin(){
//        Intent loginIntent = new Intent(this, LoginActivity.class);
//        startActivity(loginIntent);
//    }
//
//    public void goRegister(){
//        Intent registerIntent = new Intent(this, RegisterActivity.class);
//        startActivity(registerIntent);
//    }

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    public void showProgress(String message){
        progressDialog.setMessage(message);
        if (!progressDialog.isShowing())
            progressDialog.show();
    }

    public void hideProgress() {
        if (progressDialog.isShowing())
            progressDialog.dismiss();
    }
}
