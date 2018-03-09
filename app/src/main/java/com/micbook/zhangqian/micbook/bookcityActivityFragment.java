package com.micbook.zhangqian.micbook;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * Created by zhangqian on 2017/10/17.
 */

public class bookcityActivityFragment extends BasePageFragment {

    private Context mContext;
    //String head = "本周Top5";
//    public bookcityActivityFragment(Context context) {
//        mContext = context;
//    }
    private int position = 0;
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        mContext = context;
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        long time = System.currentTimeMillis();
        Log.i("ttt", "onCreateView ");
        RelativeLayout relativeLayout = (RelativeLayout) fetchData();
        long time1 = System.currentTimeMillis();
         return relativeLayout;

    }

    @Override
    public View fetchData() {

        Log.i("ttt", "fetchData ");
        RelativeLayout linearLayout = (RelativeLayout) LinearLayout.inflate(getActivity(),R.layout.baner_list, null);
        ViewPager viewPager = (ViewPager) linearLayout.findViewById(R.id.viewPage);
        ArrayList<Fragment> fragments = new ArrayList<>();

        recommendActivityFragment f = new recommendActivityFragment();
        rankActivityFragment f1 = new rankActivityFragment();
        cateActivityFragment f2 = new cateActivityFragment();
        fragments.add(f);
        fragments.add(f1);
        fragments.add(f2);

        //viewPageAdapter viewPageAdapter = new viewPageAdapter(getActivity().getSupportFragmentManager(),fragments);
        viewPageTest viewPageAdapter = new viewPageTest(getChildFragmentManager(),fragments);
        viewPager.setAdapter(viewPageAdapter);

        TabLayout tablayout = (TabLayout) linearLayout.findViewById(R.id.title1);
        tablayout.setupWithViewPager(viewPager);//viewPager绑定标签
        tablayout.getTabAt(0).setText("推荐");
        tablayout.getTabAt(1).setText("排行");
        tablayout.getTabAt(2).setText("分类");
        //Log.e("nana")
        return linearLayout;

    }

}
