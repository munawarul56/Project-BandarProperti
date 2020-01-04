package com.bandarproperti.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;

import com.bandarproperti.R;
import com.bandarproperti.adapters.PropertySearchAdapter;
import com.bandarproperti.databinding.ActivityPropertySearchBinding;
import com.bandarproperti.helper.RecyclerViewOnItemClick;
import com.bandarproperti.models.Property;
import com.bandarproperti.response.PropertyApiSearchResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PropertySearchActivity extends BaseActivity {

    private ActivityPropertySearchBinding searchBinding;
    private PropertySearchAdapter propertySearchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        searchBinding = DataBindingUtil.setContentView(this, R.layout.activity_property_search);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        searchBinding.recyclerview.setLayoutManager(layoutManager);
        searchBinding.recyclerview.setItemAnimator(new DefaultItemAnimator());

        searchBinding.toolbar.textSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editable.length() == 0)
                {
                    searchBinding.toolbar.clearSearch.setVisibility(View.GONE);
                    searchProperty("");
                }

                if(editable.length() >= 3)
                {
                    searchBinding.toolbar.clearSearch.setVisibility(View.VISIBLE);
                    searchProperty(editable.toString());
                }
            }
        });

        searchBinding.toolbar.clearSearch.setOnClickListener(view -> {
            searchBinding.toolbar.textSearch.setText("");
            searchBinding.toolbar.clearSearch.setVisibility(View.GONE);
            searchProperty("");
        });

        searchBinding.recyclerview.addOnItemTouchListener(new RecyclerViewOnItemClick(this, (view, position) -> {
            CardView rootView   = (CardView) view;
            TextView id         = (TextView) rootView.getChildAt(0);

            Intent details = new Intent(this, PropertyDetailsActivity.class);
            details.putExtra("id", id.getText().toString().trim());
            startActivity(details);
        }));
    }

    private void searchProperty(String query)
    {
        searchBinding.shimmerViewContainer.startShimmerAnimation();
        searchBinding.shimmerViewContainer.setVisibility(View.VISIBLE);
        searchBinding.recyclerview.setVisibility(View.GONE);
        searchBinding.emptyLayout.setVisibility(View.GONE);

        Call<PropertyApiSearchResponse> apiSearchResponseCall = requestInterface.getPropertySearch(query);
        apiSearchResponseCall.enqueue(new Callback<PropertyApiSearchResponse>() {
            @Override
            public void onResponse(Call<PropertyApiSearchResponse> call, Response<PropertyApiSearchResponse> response) {
                if(response.isSuccessful())
                {
                    List<Property> properties = response.body().getProperty();

                    propertySearchAdapter = new PropertySearchAdapter(PropertySearchActivity.this, properties);
                    searchBinding.recyclerview.setAdapter(propertySearchAdapter);

                    searchBinding.shimmerViewContainer.stopShimmerAnimation();
                    searchBinding.shimmerViewContainer.setVisibility(View.GONE);
                    searchBinding.emptyLayout.setVisibility(View.GONE);
                    searchBinding.recyclerview.setVisibility(View.VISIBLE);
                }
                else
                {
                    searchBinding.shimmerViewContainer.stopShimmerAnimation();
                    searchBinding.shimmerViewContainer.setVisibility(View.GONE);
                    searchBinding.emptyLayout.setVisibility(View.VISIBLE);
                    searchBinding.recyclerview.setVisibility(View.GONE);

                    showToast("Gagal memuat data, coba lagi");
                }
            }

            @Override
            public void onFailure(Call<PropertyApiSearchResponse> call, Throwable t) {
                searchBinding.shimmerViewContainer.stopShimmerAnimation();
                searchBinding.shimmerViewContainer.setVisibility(View.GONE);
                searchBinding.emptyLayout.setVisibility(View.VISIBLE);
                searchBinding.recyclerview.setVisibility(View.GONE);

                showToast(t.getLocalizedMessage());
            }
        });
    }
}
