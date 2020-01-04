package com.bandarproperti.adapters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bandarproperti.activity.ui.PropertyListFragment;
import com.bandarproperti.models.Status;

import java.util.List;

/**
 * Created by wolfsoft3 on 24/7/18.
 */

public class TabHomepageAdapter extends FragmentStatePagerAdapter {
    List<Status> statuses;

    public TabHomepageAdapter(FragmentManager fm, List<Status> statuses) {
        super(fm);
        this.statuses  = statuses;
    }

    @Override
    public Fragment getItem(int position) {
        PropertyListFragment tab1 = new PropertyListFragment();

        Bundle bundle1 = new Bundle();
        bundle1.putInt("id", statuses.get(position).getId());

        tab1.setArguments(bundle1);
        return tab1;
    }

    @Override
    public int getCount() {
        return statuses.size();
    }
}
