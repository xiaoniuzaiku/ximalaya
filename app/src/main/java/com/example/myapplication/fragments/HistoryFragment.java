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
public class HistoryFragment extends BaseFragment {


    public HistoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        View view = layoutInflater.inflate(R.layout.fragment_history,container,false);
        return view;
    }
}
