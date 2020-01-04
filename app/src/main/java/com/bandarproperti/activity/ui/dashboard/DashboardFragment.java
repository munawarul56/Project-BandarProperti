package com.bandarproperti.activity.ui.dashboard;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.support.annotation.Nullable;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;

import com.bandarproperti.R;
import com.bandarproperti.databinding.FragmentDashboardBinding;

public class DashboardFragment extends Fragment {

    private FragmentDashboardBinding dashboardBinding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_dashboard, container, false);

        return dashboardBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}