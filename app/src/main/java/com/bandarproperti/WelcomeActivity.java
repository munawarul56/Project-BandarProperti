package com.bandarproperti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        Button btnMasuk = findViewById(R.id.btnMasuk);
        Button btnDaftar = findViewById(R.id.btnDaftar);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masuk = new Intent(WelcomeActivity.this, MasukActivity.class);
                WelcomeActivity.this.startActivity(masuk);
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(WelcomeActivity.this, DaftarActivity.class);
                WelcomeActivity.this.startActivity(daftar);
            }
        });
    }
}
