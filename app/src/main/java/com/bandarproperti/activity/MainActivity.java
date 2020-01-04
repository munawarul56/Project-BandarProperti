package com.bandarproperti.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.bandarproperti.R;
import com.bandarproperti.activity.ui.dashboard.DashboardFragment;
import com.bandarproperti.activity.ui.home.HomeFragment;
import com.bandarproperti.activity.ui.notifications.NotificationsFragment;

public class MainActivity extends BaseActivity {

    FragmentManager mFragmentManager;
    FragmentTransaction mFragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        BottomNavigationView navView = findViewById(R.id.nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(navView, navController);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_view);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mFragmentManager = getSupportFragmentManager();

        homeFragment();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                    mFragmentTransaction.replace(R.id.content, new HomeFragment());
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();
                    return true;
                case R.id.navigation_dashboard:
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                    mFragmentTransaction.replace(R.id.content, new DashboardFragment());
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();
                    return true;
                case R.id.navigation_notifications:
                    mFragmentTransaction = mFragmentManager.beginTransaction();
                    mFragmentTransaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left, R.anim.enter_from_left, R.anim.exit_to_right);
                    mFragmentTransaction.replace(R.id.content, new NotificationsFragment());
                    mFragmentTransaction.addToBackStack(null);
                    mFragmentTransaction.commit();
                    return true;
            }
            return false;
        }
    };

    public void homeFragment() {
        mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.content, new HomeFragment());
        mFragmentTransaction.commit();
    }
}
