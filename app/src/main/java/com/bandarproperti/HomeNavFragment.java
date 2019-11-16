package com.bandarproperti;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandarproperti.adapter.Menu_Adapter;

import java.util.ArrayList;


public class HomeNavFragment extends Fragment {

    public static HomeNavFragment newInstance() {
        return new HomeNavFragment();
    }

//    private RecyclerView recyclerView;
//    private Menu_Adapter adapter;
//    private ArrayList<MenuModel> menuArrayList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home_nav, container, false);
        return view;

//        // Menu Adapter
//        addData();
//        recyclerView = findViewById(R.id.recycler_view);
//        adapter = new Menu_Adapter(menuArrayList);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(HomeNavFragment.this);
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);

    }



//    void addData() {
//        menuArrayList = new ArrayList<>();
//        menuArrayList.add(new MenuModel("Perumahan Damai Lestari", "img.jpg", "123456789", "Rp.300.000.000",
//                "Pango Raya,", "Banda Aceh", "BP-234R", "3", "2",
//                "1", "200-300m", "150-200m", "Perumahan Komplek Damai Lestari adalah perumahan semi minimalis yang ada pada desa pango raya",
//                "-", "-"));
//        menuArrayList.add(new MenuModel("Perumahan Ina Resident", "img.jpg", "123456789", "Rp.500.000.000",
//                "Ulee Kareng,", "Banda Aceh", "BP-263R", "4", "3",
//                "1", "300-450m", "200-300m", "Perumahan Ina Resident adalah perumahan semi  yang berlokasi di ULee Kareng",
//                "-", "-"));
//    }

}
