package com.bandarproperti.activity.ui.notifications;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.annotation.NonNull;
import android.widget.TextView;

import com.bandarproperti.R;
import com.bandarproperti.activity.SignInActivity;
import com.bandarproperti.activity.ui.BaseFragment;
import com.bandarproperti.config.Constants;
import com.bandarproperti.databinding.FragmentNotificationBinding;

import java.util.Map;

public class NotificationsFragment extends BaseFragment {

    private FragmentNotificationBinding notificationBinding;

    Map<String, String> user;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_akun, container, false);

        user = preference.getUseProfile();

        if(preference.isLoggedIn())
        {
            notificationBinding.accountEmail.setText(user.get(Constants.PrefManager.USER_EMAIL));
            notificationBinding.accountName.setText(user.get(Constants.PrefManager.USER_NAME));

            notificationBinding.signOutBtn.setVisibility(View.VISIBLE);
            notificationBinding.loginBtn.setVisibility(View.GONE);
            notificationBinding.signOutBtn.setOnClickListener(view -> {
                LayoutInflater layoutInflater = LayoutInflater.from(getActivity());
                View promptView = layoutInflater.inflate(R.layout.message_dialog, null);
                final AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
                alertDialogBuilder.setView(promptView);
                alertDialogBuilder.setCancelable(false);

                TextView titleText = (TextView) promptView.findViewById(R.id.title);
                titleText.setText("Konfirmasi");

                TextView messageText = (TextView) promptView.findViewById(R.id.message);
                messageText.setText("Anda akan logout?");

                alertDialogBuilder.setPositiveButton("YA", (dialogInterface, i) -> {
                    preference.logOut();
                    notificationBinding.signOutBtn.setVisibility(View.GONE);
                    notificationBinding.loginBtn.setVisibility(View.VISIBLE);

                    notificationBinding.accountEmail.setText("-");
                    notificationBinding.accountName.setText("-");
                });

                alertDialogBuilder.setNegativeButton("TIDAK", (dialogInterface, i) -> dialogInterface.dismiss());

                AlertDialog alert = alertDialogBuilder.create();
                alert.show();
            });
        }
        else
        {
            notificationBinding.accountEmail.setText("-");
            notificationBinding.accountName.setText("-");

            notificationBinding.signOutBtn.setVisibility(View.GONE);
            notificationBinding.loginBtn.setVisibility(View.VISIBLE);
            notificationBinding.loginBtn.setOnClickListener(view -> {
                startActivity(new Intent(getActivity(), SignInActivity.class));
            });
        }

        return notificationBinding.getRoot();
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}