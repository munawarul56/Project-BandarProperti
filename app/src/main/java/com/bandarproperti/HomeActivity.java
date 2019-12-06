package com.bandarproperti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.ArrayList;

import com.bandarproperti.Adapters.PropertyRecyclerAdapter;
import com.bandarproperti.ModelClasses.PropertyRecyclerModel;

public class HomeActivity extends AppCompatActivity {

    private ArrayList<PropertyRecyclerModel> homeListModelClassArrayList;
    private RecyclerView recyclerView;
    private PropertyRecyclerAdapter mAdapter;
    TextView refine;

    private String propertyName[]={"Royal De Khansa Residence","Property Name","Property Name"};
    private String type[]={"Type 65","14 Street/3rd Block","14 Street/3rd Block"};
    private String street2[]={"Desa Kalut,Ingin Jaya, Aceh Besar","Super Build-up Area:1060 Sq.Ft","Super Build-up Area:1060 Sq.Ft"};
    private String amount[]={"Rp.465.000.000,-","$2200","$2200"};
    private String bedcount[]={"2","3","3"};
    private String carParking[]={"2","1","1"};
    private String swimmingpool[]={"1","1","1"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        HomeActivity.this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

       refine=(TextView)findViewById(R.id.refine);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);

       refine.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent intent = new Intent(HomeActivity.this,PropertyDetailsActivity.class);
               startActivity(intent);
           }
       });

        homeListModelClassArrayList = new ArrayList<>();

        for (int i = 0; i < propertyName.length; i++) {
            PropertyRecyclerModel beanClassForRecyclerView_contacts = new PropertyRecyclerModel(propertyName[i], type[i],street2[i],amount[i],bedcount[i],carParking[i],swimmingpool[i]);

            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
        }
        mAdapter = new PropertyRecyclerAdapter(HomeActivity.this,homeListModelClassArrayList);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(HomeActivity.this
        );
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);

    }
}