package com.micbook.zhangqian.micbook;

import android.annotation.TargetApi;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * Created by zhangqian on 2017/10/17.
 */


public class meAcitivityFragment extends Fragment {

       private Context mContext;
       private TextView mTextView;

//    public meAcitivityFragment(Context context){
//          mContext = context;
//    }
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
//    public meAcitivityFragment() {
//
//    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        long time = System.currentTimeMillis();
        Log.i(TAG, "meActivity: "+time);

        int type = 2;
        int[] images = {
                R.mipmap.shoucang,
                R.mipmap.bayou,
                R.mipmap.huancun,
                R.mipmap.lishi
        };
        String[] names = {
                "收藏","吧友",
                "下载","历史"
        };

        View view = inflater.inflate(R.layout.activity_me,container,false);

        GridView gv = (GridView)view.findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(mContext,names,images,type));
        long time1 = System.currentTimeMillis();
        Log.i(TAG, "meActivity1: "+time1);
        Log.i(TAG, "meActivity: "+(time1-time));
        return view;
    }
}
