package com.bandarproperti.activity.ui;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bandarproperti.R;
import com.bandarproperti.activity.PropertyDetailsActivity;
import com.bandarproperti.activity.ui.home.HomeViewModel;
import com.bandarproperti.adapters.PropertyAdapter;
import com.bandarproperti.helper.RecyclerViewOnItemClick;

/**
 * A simple {@link Fragment} subclass.
 */
public class PropertyListFragment extends BaseFragment {

    private RecyclerView recyclerView;
    private SwipeRefreshLayout refreshLayout;

    HomeViewModel propertyViewModel;
    PropertyAdapter propertyAdapter;

    Bundle bundle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_property_list, container, false);

        bundle = this.getArguments();

        propertyViewModel = new HomeViewModel(getActivity().getApplication(), bundle.getInt("id", 0));

        refreshLayout = root.findViewById(R.id.refreshLayout);
        recyclerView = root.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager( getContext());
        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setItemAnimator(new DefaultItemAnimator());

        propertyAdapter = new PropertyAdapter(getActivity());

        init();

        refreshLayout.setOnRefreshListener(() -> {
            refreshLayout.setRefreshing(true);
            propertyViewModel.refresh();
        });

        recyclerView.addOnItemTouchListener(new RecyclerViewOnItemClick(getActivity(), (view, position) -> {
            CardView rootView   = (CardView) view;
            TextView id         = (TextView) rootView.getChildAt(0);

            Intent details = new Intent(getActivity(), PropertyDetailsActivity.class);
            details.putExtra("id", id.getText().toString().trim());
            startActivity(details);
        }));

        return root;
    }

    public void init()
    {
        refreshLayout.setRefreshing(true);

        propertyViewModel.getPropertyList().observe(getActivity(), pagedList -> {
            propertyAdapter.submitList(pagedList);
            refreshLayout.setRefreshing(false);
        });

        propertyViewModel.getNetworkState().observe(getActivity(), networkState -> {
            propertyAdapter.setNetworkState(networkState);
        });

        recyclerView.setAdapter(propertyAdapter);
    }
}
