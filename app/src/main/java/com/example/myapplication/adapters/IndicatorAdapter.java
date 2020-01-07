package com.example.myapplication.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.View;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;

import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.CommonNavigatorAdapter;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.abs.IPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.indicators.LinePagerIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.ColorTransitionPagerTitleView;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.SimplePagerTitleView;

/*
PACKAGE_NAME:com.example.myapplication.adapters
DATE:2020/1/6
${}
*/public class IndicatorAdapter extends CommonNavigatorAdapter {

    private final String[] mStringArray;
    private OnIndicatorTapClicListener mMOnTabClickListener;

    public IndicatorAdapter(Context context) {
        mStringArray = context.getResources().getStringArray(R.array.mainstring);
    }

    @Override
    public int getCount() {
        if (mStringArray != null) {
            return mStringArray.length;
        }
        return 0;
    }

    @Override
    public IPagerTitleView getTitleView(Context context, final int index) {
        SimplePagerTitleView simplePagerTitleView = new ColorTransitionPagerTitleView(context);
        simplePagerTitleView.setText(mStringArray[index]);
        simplePagerTitleView.setNormalColor(Color.parseColor("#88ffffff"));
        simplePagerTitleView.setSelectedColor(Color.WHITE);
        simplePagerTitleView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //mViewPager.setCurrentItem(index);
                //TODO设置viewpage的点击事件
                if (mMOnTabClickListener != null) {
                    mMOnTabClickListener.onTabclick(index);
                }
            }
        });
        return simplePagerTitleView;
    }

    @Override
    public IPagerIndicator getIndicator(Context context) {
        LinePagerIndicator indicator = new LinePagerIndicator(context);
        indicator.setColors(Color.parseColor("#40c4ff"));
        return indicator;
    }
    public void setOnIndicatorTapClicListener(OnIndicatorTapClicListener listener){
        this.mMOnTabClickListener = listener;
    }
    //设置indicator按钮与fragment的联动，暴露接口
    public interface OnIndicatorTapClicListener{
        void onTabclick(int index);
    }
}
