package com.bandarproperti.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.CompoundButton;

import com.bandarproperti.R;
import com.bandarproperti.config.Constants;
import com.bandarproperti.config.RequestInterface;
import com.bandarproperti.databinding.ActivitySignInBinding;
import com.bandarproperti.helper.SharedPrefHelper;
import com.bandarproperti.models.Customer;
import com.bandarproperti.request.ApiClient;
import com.bandarproperti.response.CustomerResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignInActivity extends AppCompatActivity {

//     EditText PassInput;
//     CheckBox ShowPass;

    private ActivitySignInBinding signInBinding;

    RequestInterface requestInterface;
    ApiClient apiClient;

    private ProgressDialog progressDialog;
    private SharedPrefHelper preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      EditText  PassInput =  findViewById(R.id.customerPassword);
//      CheckBox  ShowPass =  findViewById(R.id.showpass);


//        ShowPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if (!isChecked) {
//                    PassInput.setTransformationMethod(PasswordTransformationMethod.getInstance());
//                } else {
//                    PassInput.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//                }
//
//            }
//        });



        signInBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_in);

        setUp();

        signInBinding.customerRegisterBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, SignUpActivity.class));
            finish();
        });

        signInBinding.customerLoginBtn.setOnClickListener(view -> {
            loginValidation();
        });
    }

    private void setUp()
    {
        progressDialog = new ProgressDialog(this);
        progressDialog.setCancelable(false);

        apiClient = new ApiClient(this);
        requestInterface = apiClient.getClient().create(RequestInterface.class);

        preference = new SharedPrefHelper(this);
    }

    private void loginValidation()
    {
        if(signInBinding.customerEmail.getText().toString().isEmpty())
        {
            signInBinding.customerEmail.setError("Masukkan email");
        }
        else if(signInBinding.customerPassword.getText().toString().isEmpty())
        {
            signInBinding.customerPassword.setError("Masukkan password");
        }
        else
        {
            sendLoginRequest(signInBinding.customerEmail.getText().toString().trim(), signInBinding.customerPassword.getText().toString().trim());
        }
    }

    public void sendLoginRequest(String email, String password)
    {
        showProgress("Mengirim login..");

        Customer customer = new Customer();
        customer.setEmail(email);
        customer.setPassword(password);

        Call<CustomerResponse> responseCall = requestInterface.login(customer);
        responseCall.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                hideProgress();

                if(response.code() == 200)
                {
                    showToast("Login berhasil..");

                    Customer cust = response.body().getCustomer();
                    preference.setLogin(cust, true);

                    startActivity(new Intent(SignInActivity.this, MainActivity.class));
                    finish();

                }
                else if(response.code() == 401)
                {
                    try{
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());
                        showToast(jsonObject.getString("message"));
                    }
                    catch (JSONException | IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    showToast("Login gagal, coba lagi!");
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                Log.e(Constants.TAG.LoginTag, "Response : " + t.getLocalizedMessage());
                hideProgress();

                showToast("Gagal terkoneksi ke server");
            }
        });
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

    public void showToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
