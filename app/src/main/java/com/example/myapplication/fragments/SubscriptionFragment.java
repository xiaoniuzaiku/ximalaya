package com.example.myapplication.fragments;


import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubscriptionFragment extends BaseFragment {

    public SubscriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.fragment_subscription, container,false);
        return view;
    }


}
