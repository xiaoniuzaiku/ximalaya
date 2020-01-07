package com.example.myapplication.adapters;

import com.example.myapplication.utils.FragmentCreator;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

/*
PACKAGE_NAME:com.example.myapplication.adapters
DATE:2020/1/6
${}viewpager对fragment的适配器
*/public class ContentAdapter extends FragmentStatePagerAdapter {

    public ContentAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }



    @NonNull
    @Override
    public Fragment getItem(int position) {
        return FragmentCreator.getFragment(position);
    }

    @Override
    public int getCount() {
        return FragmentCreator.PAGE_COUNT;
    }
}
