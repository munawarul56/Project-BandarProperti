package com.bandarproperti;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import com.bandarproperti.Adapters.MyCustomPagerAdapter;
import com.bandarproperti.Adapters.PropertyImageAdapter;
import com.bandarproperti.ModelClasses.PropertyImageModel;

public class PropertyDetailsActivity extends AppCompatActivity implements OnMapReadyCallback{
    ViewPager viewPager;

    private final static String TAG ="CALL";
    int request_code = 1;

    int images[] = {R.drawable.property,R.drawable.property,R.drawable.property,R.drawable.property};
    MyCustomPagerAdapter myCustomPagerAdapter;

    private TextView imageNo;


//
//    private ArrayList<PropertyImageModel> homeListModelClassArrayList;
//    private RecyclerView recyclerView1;
//    private PropertyImageAdapter mAdapter;
//     private Integer image[]={R.drawable.property,R.drawable.property,R.drawable.property,
//             R.drawable.property,R.drawable.property,R.drawable.property};
//     private String imageNo[]={"1","2","3","4","5","6"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_details);

        ImageButton btnChat = findViewById(R.id.btnChat);
        ImageButton btnCall = findViewById(R.id.btnCall);


        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentChat = new Intent();
                intentChat.setAction(Intent.ACTION_VIEW);
                intentChat.addCategory(Intent.CATEGORY_BROWSABLE);
                intentChat.setData(Uri.parse("https://wa.me/6282273713871"));
                startActivity(intentChat);
            }
            });


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentCall = new Intent();
                intentCall.setAction(Intent.ACTION_DIAL);
                intentCall.setData(Uri.parse("tel:082273713871"));
                startActivity(intentCall);
            }
        });

        viewPager = findViewById(R.id.viewpager);
        imageNo = (TextView)findViewById(R.id.imageNo);

        myCustomPagerAdapter = new MyCustomPagerAdapter(PropertyDetailsActivity.this, images);
        viewPager.setAdapter(myCustomPagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                imageNo.setText("" + (position +1));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        // Retrieve the content view that renders the map.

        // Get the SupportMapFragment and request notification
        // when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
////
//        recyclerView1 = (RecyclerView)findViewById(R.id.recyclerView1);
//        homeListModelClassArrayList = new ArrayList<>();
//
//        for (int i = 0; i < image.length; i++) {
//            PropertyImageModel beanClassForRecyclerView_contacts = new PropertyImageModel(image[i],imageNo[i]);
//
//            homeListModelClassArrayList.add(beanClassForRecyclerView_contacts);
//        }
//        mAdapter = new PropertyImageAdapter(PropertyDetailsActivity.this,homeListModelClassArrayList);
//
//        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(PropertyDetailsActivity.this,LinearLayoutManager.HORIZONTAL, false);
//        recyclerView1.setLayoutManager(mLayoutManager);
//        recyclerView1.setItemAnimator(new DefaultItemAnimator());
//        recyclerView1.setAdapter(mAdapter);

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
