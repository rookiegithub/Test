package com.micbook.zhangqian.micbook;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.micbook.holder.MZViewHolder;
import com.micbook.holder.MZHolderCreator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqian on 2017/10/25.
 */

public class bannerInit {

    public static final int []BANNER = new int[]{R.mipmap.banner1,R.mipmap.banner2,R.mipmap.banner3,R.mipmap.banner4,R.mipmap.banner5};
    private MZBannerView1 mMZBanner;

    void initView(View view, final Context context) {

        mMZBanner = (MZBannerView1) view.findViewById(R.id.banner);
        mMZBanner.setBannerPageClickListener(new MZBannerView1.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(context,"点击:"+position, Toast.LENGTH_LONG).show();
            }
        });
        List<Integer> bannerList = new ArrayList<>();
        for(int i=0;i<BANNER.length;i++){
            bannerList.add(BANNER[i]);
        }

        mMZBanner.setPages(bannerList, new MZHolderCreator<bannerInit.BannerViewHolder>() {
            @Override
            public bannerInit.BannerViewHolder createViewHolder() {
                return new bannerInit.BannerViewHolder();
            }
        });
        mMZBanner.start();
    }

    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }

}
