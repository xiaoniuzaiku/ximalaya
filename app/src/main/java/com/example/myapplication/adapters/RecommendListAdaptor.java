package com.example.myapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.R;
import com.squareup.picasso.Picasso;
import com.ximalaya.ting.android.opensdk.model.album.Album;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import butterknife.BindView;
import butterknife.ButterKnife;

/*
PACKAGE_NAME:com.example.myapplication.adapters
DATE:2020/1/7
${}
*/public class RecommendListAdaptor extends RecyclerView.Adapter<RecommendListAdaptor.InnerHolder> {
    List<Album> mData=new ArrayList<>();
    @NonNull
    @Override
    public RecommendListAdaptor.InnerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recommend,parent,false);
        return new InnerHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecommendListAdaptor.InnerHolder holder, int position) {
        holder.itemView.setTag(position);
        holder.setdata(mData.get(position));
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setdatas(List<Album> albumList) {
        mData.clear();
        mData.addAll(albumList);
        notifyDataSetChanged();
    }

    public class InnerHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.ablum_cover)
         ImageView mAblumCover;
        @BindView(R.id.ablum_title_tv)
         TextView mAblumTitleTv;
        @BindView(R.id.album_description_tv)
         TextView mAlbumDescriptionTv;
        @BindView(R.id.album_play_count)
         TextView mAlbumPlayCount;
        @BindView(R.id.album_content_size)
         TextView mAlbumContentSize;

        public InnerHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void setdata(Album album) {
            mAblumTitleTv.setText(album.getAlbumTitle());
            mAlbumDescriptionTv.setText(album.getAlbumIntro());
            mAlbumPlayCount.setText(album.getPlayCount()+"");
            mAlbumContentSize.setText(album.getIncludeTrackCount()+"");
            Picasso.with(itemView.getContext()).load(album.getCoverUrlLarge()).into(mAblumCover);
        }
    }
}
