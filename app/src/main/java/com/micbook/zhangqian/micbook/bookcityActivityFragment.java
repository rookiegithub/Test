package com.micbook.zhangqian.micbook;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;


/**
 * Created by zhangqian on 2017/10/17.
 */

public class bookcityActivityFragment extends Fragment {

    private Context mContext;
    //String head = "本周Top5";
    public bookcityActivityFragment(Context context) {
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        RelativeLayout linearLayout = (RelativeLayout) inflater.inflate(R.layout.baner_list, null);
        ViewPager viewPager = (ViewPager) linearLayout.findViewById(R.id.viewPage);
        viewPageAdapter viewPageAdapter = new viewPageAdapter(getActivity());
        viewPager.setAdapter(viewPageAdapter);

        TabLayout tablayout = (TabLayout) linearLayout.findViewById(R.id.title1);
        tablayout.setupWithViewPager(viewPager);//viewPager绑定标签
        tablayout.getTabAt(0).setText("推荐");
        tablayout.getTabAt(1).setText("排行");
        tablayout.getTabAt(2).setText("分类");

        return linearLayout;

    }
}
