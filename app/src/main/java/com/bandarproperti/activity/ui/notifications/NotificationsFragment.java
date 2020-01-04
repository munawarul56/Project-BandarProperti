package com.bandarproperti.activity.ui.notifications;

import android.content.Intent;
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
import com.bandarproperti.SignInActivity;
import com.bandarproperti.databinding.FragmentNotificationBinding;

public class NotificationsFragment extends Fragment {

    private FragmentNotificationBinding notificationBinding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_notifications, container, false);

        notificationBinding.loginBtn.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(), SignInActivity.class));
        });

        return notificationBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}