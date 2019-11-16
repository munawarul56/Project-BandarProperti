package com.bandarproperti;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MasukActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masuk);

        Button btn = findViewById(R.id.btnMasukLogin);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Masuklogin = new Intent(MasukActivity.this, ProfilActivity.class);
                MasukActivity.this.startActivity(Masuklogin);
            }
        });
    }
}