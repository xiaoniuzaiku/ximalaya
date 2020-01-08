package com.example.myapplication.fragments;

import android.graphics.Rect;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication.R;
import com.example.myapplication.adapters.RecommendListAdaptor;
import com.example.myapplication.base.BaseFragment;
import com.example.myapplication.utils.Constants;
import com.example.myapplication.utils.logutils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.DiscoveryRecommendAlbumsList;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import net.lucode.hackware.magicindicator.buildins.UIUtil;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class RecomandFragment extends BaseFragment {

    private static final String TAG = "RecomandFragment";
    private View mRootview;
    private RecyclerView mRecommendRV;
    private RecommendListAdaptor mRecommendListAdaptor;

    @Override
    public View onSubViewLoaded(LayoutInflater layoutInflater, ViewGroup container) {
        mRootview = layoutInflater.inflate(R.layout.fragment_recomand, container,false);
        //加载recycleview
        mRecommendRV = mRootview.findViewById(R.id.recommend_list);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        mRecommendRV.setLayoutManager(linearLayoutManager);
        //设置适配器
        mRecommendListAdaptor = new RecommendListAdaptor();
        mRecommendRV.setAdapter(mRecommendListAdaptor);
        mRecommendRV.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                outRect.bottom= UIUtil.dip2px(view.getContext(),5);
                outRect.top=UIUtil.dip2px(view.getContext(),5);
                outRect.left=UIUtil.dip2px(view.getContext(),5);
                outRect.right=UIUtil.dip2px(view.getContext(),5);
            }
        });
        //获取数据回来
        getRecommandData();
        //返回view，给界面显示
        return mRootview;
    }

    private void getRecommandData() {
        //封装参数
        Map<String, String> map = new HashMap<>();
        //显示一页多少条信息
        map.put(DTransferConstants.LIKE_COUNT, Constants.RECOMMAND_COUNT+"");
        CommonRequest.getGuessLikeAlbum(map, new IDataCallBack<GussLikeAlbumList>() {
            @Override
            //数据获取成功
            public void onSuccess(GussLikeAlbumList gussLikeAlbumList) {
                if (gussLikeAlbumList != null) {
                    List<Album> albumList = gussLikeAlbumList.getAlbumList();
                    if (albumList != null) {
                        logutils.d(TAG,"size-->"+albumList.size());
                        //更新UI;
                        updateRecommendUi(albumList);
                    }
                }
            }

            @Override
            //数据获取失败
            public void onError(int i, String s) {
                logutils.d(TAG,"error-->"+i);
                logutils.d(TAG,"errormsg-->"+s);
            }
        });
    }

    private void updateRecommendUi(List<Album> albumList) {
        mRecommendListAdaptor.setdatas(albumList);
    }
}
