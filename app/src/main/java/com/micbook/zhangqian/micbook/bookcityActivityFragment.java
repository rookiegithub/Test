package com.micbook.zhangqian.micbook;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.micbook.holder.MZHolderCreator;
import com.micbook.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqian on 2017/10/17.
 */

public class bookcityActivityFragment extends Fragment {

    public static final String TAG = "MZModeBannerFragment";
    public static final int []BANNER = new int[]{R.mipmap.banner1,R.mipmap.banner2,R.mipmap.banner3,R.mipmap.banner4,R.mipmap.banner5};
    private MZBannerView1 mMZBanner;

    private void initView(View view) {

        mMZBanner = (MZBannerView1) view.findViewById(R.id.banner);
        mMZBanner.setBannerPageClickListener(new MZBannerView1.BannerPageClickListener() {
            @Override
            public void onPageClick(View view, int position) {
                Toast.makeText(mContext,"点击:"+position, Toast.LENGTH_LONG).show();
            }
        });
        List<Integer> bannerList = new ArrayList<>();
        for(int i=0;i<BANNER.length;i++){
            bannerList.add(BANNER[i]);
        }

        mMZBanner.setPages(bannerList, new MZHolderCreator<bookcityActivityFragment.BannerViewHolder>() {
            @Override
            public bookcityActivityFragment.BannerViewHolder createViewHolder() {
                return new bookcityActivityFragment.BannerViewHolder();
            }
        });

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


    private Context mContext;
    int type = 2;
    int[] cate_images = {
            R.mipmap.badao,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.shenmu
    };
    String[] cate_names = {
            "我是男生","我是女生",
            "热门排行","完本畅读"
    };
    public bookcityActivityFragment(Context context){
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mz_mode_not_cover,null);

        GridView gv = (GridView)view.findViewById(R.id.bookCitygridview);
        gv.setAdapter(new ImageAdapter(mContext,cate_names,cate_images,type));

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.title1);
        tabLayout.addTab(tabLayout.newTab().setText("书城"));
        tabLayout.addTab(tabLayout.newTab().setText("消息"));
        initView(view);
        return view;
    }
    public void onPause() {
        super.onPause();
        mMZBanner.pause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mMZBanner.start();
    }
}
