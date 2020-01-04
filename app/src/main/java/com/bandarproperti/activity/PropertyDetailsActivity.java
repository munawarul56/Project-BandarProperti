package com.bandarproperti.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.text.Html;
import android.view.View;

import com.bandarproperti.R;
import com.bandarproperti.adapters.MyCustomPagerAdapter;
import com.bandarproperti.databinding.ActivityPropertyDetailsBinding;
import com.bandarproperti.models.Property;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertyDetailsActivity extends BaseActivity implements OnMapReadyCallback{

    private final String TAG = PropertyDetailsActivity.class.getSimpleName();

    private ActivityPropertyDetailsBinding activityBinding;
    private Bundle bundle;

    String images[];
    MyCustomPagerAdapter myCustomPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityBinding = DataBindingUtil.setContentView(this, R.layout.activity_property_details);

        bundle = getIntent().getExtras();

        initData();
        btnAction();
    }

    @Override
    public void onResume() {
        super.onResume();
        activityBinding.shimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        activityBinding.shimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

    private void btnAction()
    {
        activityBinding.toolbar.toolbarBack.setOnClickListener(view -> {
            onBackPressed();
        });

        activityBinding.toolbar.toolbarFavoritBtn.setOnClickListener(view -> {
            if (preference.isLoggedIn())
            {

            }
            else
            {
                activityBinding.toolbar.toolbarFavoritBtn.setLiked(false);
                messageDialogUtils.showRequiredLoginDialog(PropertyDetailsActivity.this);
            }
        });

        activityBinding.btnChat.setOnClickListener(view -> {
            Intent intentChat = new Intent();
            intentChat.setAction(Intent.ACTION_VIEW);
            intentChat.addCategory(Intent.CATEGORY_BROWSABLE);
            intentChat.setData(Uri.parse("https://wa.me/6282273713871"));
            startActivity(intentChat);
        });


        activityBinding.btnCall.setOnClickListener(view -> {
            Intent intentCall = new Intent();
            intentCall.setAction(Intent.ACTION_DIAL);
            intentCall.setData(Uri.parse("tel:082273713871"));
            startActivity(intentCall);
        });
    }

    public void initData()
    {
        Integer id = Integer.parseInt(bundle.getString("id"));
        activityBinding.shimmerViewContainer.setVisibility(View.VISIBLE);

        Call<Property> propertyCall = requestInterface.getPropertyDetail(id);
        propertyCall.enqueue(new Callback<Property>() {
            @Override
            public void onResponse(Call<Property> call, Response<Property> response) {
                if(response.isSuccessful())
                {
                    activityBinding.shimmerViewContainer.setVisibility(View.GONE);
                    activityBinding.shimmerViewContainer.stopShimmerAnimation();

                    Property property = response.body();

                    images = myHelper.GetStringGalleryArray(property.getGalleries());

                    myCustomPagerAdapter = new MyCustomPagerAdapter(PropertyDetailsActivity.this, images);
                    activityBinding.sliderViewpager.setAdapter(myCustomPagerAdapter);

                    activityBinding.sliderTotal.setText(String.valueOf(images.length));
                    activityBinding.sliderViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {

                            activityBinding.sliderNo.setText("" + (position +1));
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });

                    activityBinding.toolbar.toolbarTitle.setText(property.getName());
                    activityBinding.propertyName.setText(property.getName());
                    activityBinding.propertyStatus.setText(property.getStatus());
                    activityBinding.propertyAddress.setText(property.getAddress());
                    activityBinding.propertyPrice.setText("Rp. " + currencyFormatHelper.localFormatView(property.getPrice()));
                    activityBinding.propertyUnitPrice.setText(property.getPrice_postfix());
                    activityBinding.propertyBed.setText(String.valueOf(property.getBedrooms()));
                    activityBinding.propertyBath.setText(String.valueOf(property.getBathrooms()));
                    activityBinding.propertyGerage.setText(String.valueOf(property.getGerages()));
                    activityBinding.propertyType.setText(property.getType());
                    activityBinding.propertySize.setText(String.valueOf(property.getArea_size()));
                    activityBinding.propertyCreated.setText(dateFormatHelper.dateTimeDayNowViewParser(property.getCreated_at()));
                    activityBinding.propertyYear.setText(property.getYear_build());
                    activityBinding.propertyDesc.setText(Html.fromHtml(property.getDesc()));

                    activityBinding.scrollView.setVisibility(View.VISIBLE);
                }
                else
                {
                    showToast("Gagal mengambil data..");
                }
            }

            @Override
            public void onFailure(Call<Property> call, Throwable t) {
                showToast(t.getLocalizedMessage());
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng sydney = new LatLng(-33.852, 151.211);
        googleMap.addMarker(new MarkerOptions().position(sydney)
                .title("Marker in Sydney"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}
