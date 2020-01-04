package com.bandarproperti.activity.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.bandarproperti.config.RequestInterface;
import com.bandarproperti.helper.DateFormatHelper;
import com.bandarproperti.helper.SharedPrefHelper;
import com.bandarproperti.request.ApiClient;
import com.bandarproperti.utils.MessageDialogUtils;

/**
 * Created by arief on 06-May-17.
 */

public abstract class BaseFragment extends Fragment {

    public RequestInterface serviceInterface, requestInterface;
    public ApiClient apiClient;
    public SharedPrefHelper preference;

    public ProgressDialog progressDialog;
    public MessageDialogUtils dialogUtils;
    public DateFormatHelper dateFormatHelper;

    public boolean sentToSettings = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        apiClient = new ApiClient(getActivity().getApplicationContext());
        serviceInterface = ApiClient.createService(RequestInterface.class);
        requestInterface = apiClient.getClient().create(RequestInterface.class);

        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setCancelable(false);

        preference = new SharedPrefHelper(getActivity());
        dialogUtils = new MessageDialogUtils(getActivity());

        dateFormatHelper = new DateFormatHelper();
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

    public void showToast(String message)
    {
        Toast.makeText(getActivity().getApplicationContext(), message, Toast.LENGTH_LONG).show();
    }
}
