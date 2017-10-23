package com.micbook.zhangqian.micbook;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;

import android.support.design.widget.TabLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;


/**
 * Created by zhangqian on 2017/10/17.
 */

public class messageAcitivityFragment extends Fragment {

    private Context mContext;
    private TextView mTextView;

    public messageAcitivityFragment(Context context){
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mz_mode_not_cover,container,false);

//        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.title1);
//        tabLayout.addTab(tabLayout.newTab().setText("书城"));
//        tabLayout.addTab(tabLayout.newTab().setText("消息"));
       // ViewPager viewPager = (ViewPager)view.findViewById(R.id.vp_pager);
        //tabLayout.setSelected(true);
//        tabLayout.setScrollContainer(true);
//        tabLayout.setTabGravity(100);
        //tabLayout.setupWithViewPager(viewPager);
//        mTextView = (TextView)view.findViewById(R.id.text_fragment);
//        mTextView.setText(mContext);
        return view;
    }

    public void  initview(){

    }

}
