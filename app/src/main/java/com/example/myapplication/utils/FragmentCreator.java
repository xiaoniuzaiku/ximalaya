package com.example.myapplication.utils;

import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.fragments.HistoryFragment;
import com.example.myapplication.fragments.RecomandFragment;
import com.example.myapplication.fragments.SubscriptionFragment;

import java.util.HashMap;
import java.util.Map;

/*
PACKAGE_NAME:com.example.myapplication.utils
DATE:2020/1/7
${}
*/public class FragmentCreator {
    public final static int INDEXY_RECOMMEND=0;
    public final static int INDEXY_HISTORY=1;
    public final static int INDEXY_SUBSCRIPTION=2;
    public final static int PAGE_COUNT=3;
    private static Map<Integer, BaseFragment> sCache=new HashMap<>();
    public static BaseFragment getFragment(int index){
        BaseFragment baseFragment = sCache.get(index);
        if (baseFragment != null) {
            return baseFragment;
        }
        switch (index){
            case INDEXY_HISTORY:
                baseFragment=new HistoryFragment();
                break;
            case INDEXY_RECOMMEND:
                baseFragment=new RecomandFragment();
                break;
            case INDEXY_SUBSCRIPTION:
                baseFragment=new SubscriptionFragment();
                break;
        }
        sCache.put(index,baseFragment);
        return baseFragment;
    }

}
