package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.myapplication.adapters.ContentAdapter;
import com.example.myapplication.adapters.IndicatorAdapter;

import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.ViewPagerHelper;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;

public class MainActivity extends AppCompatActivity {

    private static final String TAG="MainActivity";
    private MagicIndicator mMagicIndicator;
    private IndicatorAdapter indicatorAdapter;
    private ViewPager mContentviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        initEevent();
    }

    private void initEevent() {
        indicatorAdapter.setOnIndicatorTapClicListener(new IndicatorAdapter.OnIndicatorTapClicListener() {
            @Override
            public void onTabclick(int index) {
                if (mContentviewpager != null) {
                    mContentviewpager.setCurrentItem(index);
                }
            }
        });
    }

    private void initview() {
        mMagicIndicator = this.findViewById(R.id.main_indicator);
        mMagicIndicator.setBackgroundColor(this.getResources().getColor(R.color.main_color));
        CommonNavigator commonNavigator=new CommonNavigator(this);
        //设置indicator适配器
        indicatorAdapter=new IndicatorAdapter(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(indicatorAdapter);
        //viewpager
        mContentviewpager = this.findViewById(R.id.contentpager);
        //设置viewpager适配器
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        ContentAdapter contentAdapter=new ContentAdapter(supportFragmentManager);
        mContentviewpager.setAdapter(contentAdapter);
        //绑定指示器和viewpager
        mMagicIndicator.setNavigator(commonNavigator);
        ViewPagerHelper.bind( mMagicIndicator,mContentviewpager);
    }


}
