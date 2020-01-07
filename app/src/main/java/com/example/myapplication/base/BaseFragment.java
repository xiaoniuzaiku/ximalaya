package com.example.myapplication.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/*
PACKAGE_NAME:com.example.myapplication.fragments
DATE:2020/1/7
${}
*/public abstract class BaseFragment extends Fragment {
    private View mrootview;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mrootview=onSubViewLoaded(inflater,container);
        return mrootview;
    }


    public abstract View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container);
}
