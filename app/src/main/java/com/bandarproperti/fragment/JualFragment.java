package com.bandarproperti.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bandarproperti.R;


public class JualFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view_frag1 = inflater.inflate(R.layout.fragment_jual, container, false);
        return view_frag1;
    }

}
