package com.bandarproperti;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.MenuItem;
import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;

import com.bandarproperti.adapter.Menu_Adapter;


public class MenuActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    private RecyclerView recyclerView;
    private Menu_Adapter adapter;
    private ArrayList<MenuModel> menuArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        //Bottom Navigation
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flContent, HomeNavFragment.newInstance())
                    .commit();
        }
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

//        //TapLayout & ViewPager
//        final TabLayout tabLayout = findViewById(R.id.tab_layout);
//        final ViewPager viewPager = findViewById(R.id.pager);
//        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
//
//        //Adapter ViewPager
//        viewPager.setAdapter(pagerAdapter);
//
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
//
//        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                viewPager.setCurrentItem(tab.getPosition());
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//            }
//        });

        // Menu Adapter
        addData();

        recyclerView = findViewById(R.id.recycler_view);
        adapter = new Menu_Adapter(menuArrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MenuActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.home:
                fragment = HomeNavFragment.newInstance();
                break;
            case R.id.favorite:
                fragment = FavoriteNavFragment.newInstance();
                break;
            case R.id.account:
                fragment = AccountNavFragment.newInstance();
                break;
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.flContent, fragment)
                .commit();

        return false;
    }

    void addData() {
        menuArrayList = new ArrayList<>();
        menuArrayList.add(new MenuModel("Perumahan Damai Lestari", "img.jpg", "123456789", "Rp.300.000.000",
                "Pango Raya,", "Banda Aceh", "BP-234R", "3", "2",
                "1", "200-300m", "150-200m", "Perumahan Komplek Damai Lestari adalah perumahan semi minimalis yang ada pada desa pango raya",
                "-", "-"));
    }
}