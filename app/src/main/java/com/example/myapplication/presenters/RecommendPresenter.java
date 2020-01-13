package com.example.myapplication.presenters;

import com.example.myapplication.interfaces.IRecommendPresenter;
import com.example.myapplication.interfaces.IRecommendViewCallback;
import com.example.myapplication.utils.Constants;
import com.example.myapplication.utils.logutils;
import com.ximalaya.ting.android.opensdk.constants.DTransferConstants;
import com.ximalaya.ting.android.opensdk.datatrasfer.CommonRequest;
import com.ximalaya.ting.android.opensdk.datatrasfer.IDataCallBack;
import com.ximalaya.ting.android.opensdk.model.album.Album;
import com.ximalaya.ting.android.opensdk.model.album.GussLikeAlbumList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.security.auth.callback.Callback;

/*
PACKAGE_NAME:com.example.myapplication.presenters
DATE:2020/1/9
${}
*/public class RecommendPresenter implements IRecommendPresenter {
    private RecommendPresenter(){
    }
    private static RecommendPresenter sInstance=null;
private static final String TAG="RecommendPresenter";
private List<IRecommendViewCallback> mCallbacks=new ArrayList<>();
    /**
     * get single instance
     * @return
     */
    public static RecommendPresenter getInstance(){
        if (sInstance == null) {
            synchronized (RecommendPresenter.class){
                if (sInstance == null) {
                    sInstance=new RecommendPresenter();
                }
            }
        }
        return sInstance;
    }
    //获取数据方法
    @Override
    public void getRecommendList() {
        onLoading();
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
//                        updateRecommendUi(albumList);
                        handlerRecommendList(albumList);
                    }
                }
            }

            @Override
            //数据获取失败
            public void onError(int i, String s) {
                handlererror();

            }
        });
    }

    private void handlererror() {
        onNetworkErro();
    }


    private void handlerRecommendList(List<Album> albumList) {
        logutils.d(TAG,"handlerRecommendList"+albumList);
        //通知ui更新
        //通知UI更新
        if(albumList != null) {
            //测试，清空一下，让界面显示空
            //albumList.clear();
            if(albumList.size() == 0) {
                for(IRecommendViewCallback callback : mCallbacks) {
                    callback.onEmpty();
                }
            } else {
                for(IRecommendViewCallback callback : mCallbacks) {
                    callback.onRecommendListLoad(albumList);
                }
            }
        }

    }

    @Override
    public void pull2RefreshMore() {

    }

    @Override
    public void loadMore() {

    }

    @Override
    public void onNetworkErro() {
        if (mCallbacks != null) {
            for (IRecommendViewCallback callback : mCallbacks) {
                callback.onNetworkErro();
            }
        }
    }

    @Override
    public void onEmpty() {

    }

    @Override
    public void onLoading() {
        for(IRecommendViewCallback callback : mCallbacks) {
            callback.onLoading();
        }
    }

    @Override
    public void registerViewCallback(IRecommendViewCallback callback) {
        if (!mCallbacks.contains(callback)) {
            mCallbacks.add(callback);
        }
    }

    @Override
    public void unRegisterViewCallback(IRecommendViewCallback callback) {
        if (!mCallbacks.contains(callback)) {
            mCallbacks.remove(callback);
        }
    }
}
