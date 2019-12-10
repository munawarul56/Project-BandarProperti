package com.bandarproperti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.scwang.wave.MultiWaveHeader;

public class MainActivity extends AppCompatActivity {

    TextView btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MultiWaveHeader waveHeader = findViewById(R.id.wave);

        waveHeader.setVelocity(1);
        waveHeader.setProgress(1);
        waveHeader.isRunning();
        waveHeader.setGradientAngle(45);
        waveHeader.setWaveHeight(40);


        btnSignIn = findViewById(R.id.btnSignIn);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(MainActivity.this,SignInActivity.class);
                startActivity(intent);


            }
        });


    }
}
