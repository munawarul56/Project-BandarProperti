package com.bandarproperti;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class activity_welcome_screen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        Button btnMasuk = findViewById(R.id.btnMasuk);
        Button btnDaftar = findViewById(R.id.btnDaftar);

        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent masuk = new Intent(activity_welcome_screen.this, MasukActivity.class);
                activity_welcome_screen.this.startActivity(masuk);
            }
        });

        btnDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent daftar = new Intent(activity_welcome_screen.this, DaftarActivity.class);
                activity_welcome_screen.this.startActivity(daftar);
            }
        });
    }
}
