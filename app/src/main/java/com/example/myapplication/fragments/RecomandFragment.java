package com.example.myapplication.fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.base.BaseFragment;


public class RecomandFragment extends BaseFragment {

    @Override
    public View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.fragment_recomand, container,false);
        return view;
    }
}
