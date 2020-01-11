package com.bandarproperti;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class FavoritActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorit);

        //Inisiasi & Assign Variable
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        //Set Home Selected
        bottomNavigationView.setSelectedItemId(R.id.favorit);

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){

                    case R.id.beranda:
                        startActivity(new Intent(getApplicationContext(),HomeActivity.class));
//                        overridePendingTransition(0,0);
                        return true;

                    case R.id.favorit:
                        return true;


                    case R.id.akun:
                        startActivity(new Intent(getApplicationContext(),AkunActivity.class));
//                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });

    }
}
