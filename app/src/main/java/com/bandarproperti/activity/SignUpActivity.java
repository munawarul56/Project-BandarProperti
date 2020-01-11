package com.bandarproperti.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.bandarproperti.R;
import com.bandarproperti.config.Constants;
import com.bandarproperti.config.RequestInterface;
import com.bandarproperti.databinding.ActivitySignUpBinding;
import com.bandarproperti.helper.SharedPrefHelper;
import com.bandarproperti.models.Customer;
import com.bandarproperti.request.ApiClient;
import com.bandarproperti.response.CustomerResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity extends AppCompatActivity {

    private ActivitySignUpBinding signUpBinding;

    RequestInterface requestInterface;
    ApiClient apiClient;

    private ProgressDialog progressDialog;
    private SharedPrefHelper preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        signUpBinding = DataBindingUtil.setContentView(this, R.layout.activity_sign_up);

        setUp();

        signUpBinding.customerLoginBtn.setOnClickListener(view -> {
            startActivity(new Intent(this, SignInActivity.class));
            finish();
        });

        signUpBinding.customerRegisterBtn.setOnClickListener(view -> {
            registrationValidation();
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

    private void registrationValidation()
    {
        if(signUpBinding.customerName.getText().toString().isEmpty())
        {
            signUpBinding.customerName.setError("Masukkan nama");
        }
        else if(signUpBinding.customerEmail.getText().toString().isEmpty())
        {
            signUpBinding.customerEmail.setError("Masukkan email");
        }
        else if(signUpBinding.customerPassword.getText().toString().isEmpty())
        {
            signUpBinding.customerPassword.setError("Masukkan password");
        }
        else
        {
            sendRegistration(signUpBinding.customerName.getText().toString().trim(), signUpBinding.customerEmail.getText().toString().trim(), signUpBinding.customerPassword.getText().toString().trim());
        }
    }

    private void sendRegistration(String name, String email, String password)
    {
        showProgress("Mengirim registrasi..");

        final Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPassword(password);

        Call<CustomerResponse> responseCall = requestInterface.register(customer);
        responseCall.enqueue(new Callback<CustomerResponse>() {
            @Override
            public void onResponse(Call<CustomerResponse> call, Response<CustomerResponse> response) {
                hideProgress();

                if(response.code() == 201)
                {
                    showToast("Pendaftaran berhasil..");

                    Customer cust = response.body().getCustomer();
                    preference.setLogin(cust, true);

                    startActivity(new Intent(SignUpActivity.this, MainActivity.class));
                    finish();

                }
                else if(response.code() == 401)
                {
                    try{
                        JSONObject jsonObject = new JSONObject(response.errorBody().string());

                        JSONArray errorArray = new JSONArray(jsonObject.getString("message"));

                        for (int i = 0; i < errorArray.length(); i++) {
                            String message = errorArray.getString(i);

                            showToast(message);
                        }
                    }
                    catch (JSONException | IOException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    showToast("Pendaftaran gagal, coba lagi!");
                }
            }

            @Override
            public void onFailure(Call<CustomerResponse> call, Throwable t) {
                Log.e(Constants.TAG.RegisterTag, "Response : " + t.getLocalizedMessage());
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
