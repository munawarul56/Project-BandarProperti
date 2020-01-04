package com.bandarproperti.activity.ui.home;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.bandarproperti.R;
import com.bandarproperti.activity.PropertySearchActivity;
import com.bandarproperti.activity.ui.BaseFragment;
import com.bandarproperti.adapters.TabHomepageAdapter;
import com.bandarproperti.databinding.FragmentHomeBinding;
import com.bandarproperti.helper.CustomViewPager;
import com.bandarproperti.models.Status;
import com.bandarproperti.response.StatusResponse;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends BaseFragment {

    private FragmentHomeBinding homeBinding;

    TabHomepageAdapter adapter;
    List<Status> statuses;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);

        getStatus();

        homeBinding.toolbar.searchLayout.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), PropertySearchActivity.class));
        });

        return homeBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
        homeBinding.shimmerViewContainer.startShimmerAnimation();
    }

    @Override
    public void onPause() {
        homeBinding.shimmerViewContainer.stopShimmerAnimation();
        super.onPause();
    }

    private void getStatus()
    {
        homeBinding.shimmerViewContainer.setVisibility(View.VISIBLE);
        homeBinding.mainLayout.setVisibility(View.GONE);

        Call<StatusResponse> responseCall = requestInterface.getStatus();
        responseCall.enqueue(new Callback<StatusResponse>() {
            @Override
            public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                if(response.code() == 200)
                {
                    homeBinding.shimmerViewContainer.stopShimmerAnimation();
                    homeBinding.shimmerViewContainer.setVisibility(View.GONE);
                    homeBinding.mainLayout.setVisibility(View.VISIBLE);

                    statuses = response.body().getStatus();

                    for (int a=0; a<statuses.size(); a++)
                    {
                        homeBinding.tablayout1.addTab(homeBinding.tablayout1.newTab().setText("" + statuses.get(a).getName()));
                    }

                    adapter = new TabHomepageAdapter(getActivity().getSupportFragmentManager(), statuses);
                    homeBinding.viewpager1.setAdapter(adapter);
                    homeBinding.viewpager1.setOffscreenPageLimit(0);
                    homeBinding.viewpager1.setOnPageChangeListener(new CustomViewPager.OnPageChangeListener() {
                        @Override
                        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                        }

                        @Override
                        public void onPageSelected(int position) {
                            TabLayout.Tab tab = homeBinding.tablayout1.getTabAt(position);
                            tab.select();
                        }

                        @Override
                        public void onPageScrollStateChanged(int state) {

                        }
                    });
                    homeBinding.tablayout1.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

                        @Override
                        public void onTabSelected(TabLayout.Tab tab) {
                            homeBinding.viewpager1.setCurrentItem(tab.getPosition());
                        }

                        @Override
                        public void onTabUnselected(TabLayout.Tab tab) {

                        }

                        @Override
                        public void onTabReselected(TabLayout.Tab tab) {

                        }
                    });
                }
            }

            @Override
            public void onFailure(Call<StatusResponse> call, Throwable t) {

            }
        });
    }
}