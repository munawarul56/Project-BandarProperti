package com.bandarproperti.activity.ui.dashboard;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bandarproperti.R;
import com.bandarproperti.activity.PropertyDetailsActivity;
import com.bandarproperti.activity.ui.BaseFragment;
import com.bandarproperti.adapters.PropertySearchAdapter;
import com.bandarproperti.databinding.FragmentDashboardBinding;
import com.bandarproperti.helper.RecyclerViewOnItemClick;
import com.bandarproperti.models.Property;
import com.bandarproperti.models.PropertyFavorite;
import com.bandarproperti.response.PropertyResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DashboardFragment extends BaseFragment {

    private FragmentDashboardBinding dashboardBinding;

    private PropertySearchAdapter propertyAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorit, container, false);

        if(!preference.isLoggedIn())
        {
            dashboardBinding.loginLayout.setVisibility(View.VISIBLE);
            dashboardBinding.refreshLayout.setVisibility(View.GONE);
            dashboardBinding.emptyLayout.setVisibility(View.GONE);
        }
        else
        {
            dashboardBinding.refreshLayout.setVisibility(View.VISIBLE);
            dashboardBinding.loginLayout.setVisibility(View.GONE);

            LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
            dashboardBinding.recyclerview.setLayoutManager(layoutManager);

            getFavorite();

            dashboardBinding.recyclerview.addOnItemTouchListener(new RecyclerViewOnItemClick(getContext(), (view, position) -> {
                CardView rootView   = (CardView) view;
                TextView id         = (TextView) rootView.getChildAt(0);

                Intent details = new Intent(getContext(), PropertyDetailsActivity.class);
                details.putExtra("id", id.getText().toString().trim());
                startActivity(details);
            }));
        }

        dashboardBinding.refreshLayout.setOnRefreshListener(() -> getFavorite());

        return dashboardBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();

        if(preference.isLoggedIn())
        getFavorite();
    }

    public void getFavorite()
    {
        dashboardBinding.emptyLayout.setVisibility(View.GONE);
        dashboardBinding.refreshLayout.setRefreshing(true);

        PropertyFavorite favorite = new PropertyFavorite();
        favorite.setCustomer_id(preference.getUserId());

        Call<PropertyResponse> responseCall = requestInterface.getPropertyFavorites(favorite);
        responseCall.enqueue(new Callback<PropertyResponse>() {
            @Override
            public void onResponse(Call<PropertyResponse> call, Response<PropertyResponse> response) {
                dashboardBinding.refreshLayout.setRefreshing(false);
                if(response.isSuccessful())
                {
                    List<Property> properties = response.body().getProperties();

                    if(properties.size() > 0)
                    {
                        dashboardBinding.recyclerview.setVisibility(View.VISIBLE);
                        propertyAdapter = new PropertySearchAdapter(getActivity(), properties);
                        dashboardBinding.recyclerview.setAdapter(propertyAdapter);
                    }
                    else
                    {
                        dashboardBinding.recyclerview.setVisibility(View.GONE);
                        dashboardBinding.emptyLayout.setVisibility(View.VISIBLE);
                    }
                }
                else
                {
                    dashboardBinding.recyclerview.setVisibility(View.GONE);
                    dashboardBinding.emptyLayout.setVisibility(View.VISIBLE);
                    showToast("Gagal ambil data, coba lagi");
                }
            }

            @Override
            public void onFailure(Call<PropertyResponse> call, Throwable t) {
                dashboardBinding.recyclerview.setVisibility(View.GONE);
                dashboardBinding.emptyLayout.setVisibility(View.VISIBLE);
                dashboardBinding.refreshLayout.setRefreshing(false);
                showToast("Gagal tekoneksi ke server, coba lagi");
            }
        });
    }
}