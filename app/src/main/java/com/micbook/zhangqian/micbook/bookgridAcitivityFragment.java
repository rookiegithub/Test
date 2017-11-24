package com.micbook.zhangqian.micbook;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

/**
 * Created by zhangqian on 2017/10/17.
 */

public class bookgridAcitivityFragment extends Fragment {

    private Context mContext;

    int type = 1;
    int[] book_images = {
            R.mipmap.badao,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.shenmu,
            R.mipmap.badao,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.shenmu,
            R.mipmap.badao,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.shenmu
    };
    String[] book_names = {
            "霸道总裁","黑衣舰队",
            "夜幕降临","神墓","a","b","c","d","e","f","g","h"
    };

    public bookgridAcitivityFragment(Context context){
        mContext = context;
    }
    public bookgridAcitivityFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_bookgrid,container,false);

        GridView gv = (GridView)view.findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(mContext,book_names,book_images,type));
        gv.setSelector(new ColorDrawable(Color.TRANSPARENT));//

        return view;
    }
}
