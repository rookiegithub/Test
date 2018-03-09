package com.micbook.zhangqian.micbook;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;

import java.util.ArrayList;

/**
 * Created by zhangqian on 2018/1/2.
 */

public class viewPageTest extends FragmentStatePagerAdapter {

    ArrayList<Fragment> mFragments;

    public viewPageTest(FragmentManager fm, ArrayList<Fragment> fragments) {
        super(fm);
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
        //return null;
    }

    @Override
    public int getCount() {
        return mFragments.size();
        //return 3;
    }
    public int getItemPosition(Object object){
        return PagerAdapter.POSITION_NONE;
    }
//    public void removeItem(int index){
//        mFragments.remove(index);
//        notifyDataSetChanged();
//    }
public void removeItem(int index) {
    mFragments.remove(index);
    notifyDataSetChanged();
}
}
