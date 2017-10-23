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
    private TextView mTextView;

    int type = 1;
    int[] book_images = {
            R.mipmap.badao,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.shenmu
    };
    String[] book_names = {
            "霸道总裁","黑衣舰队",
            "夜幕降临","神墓"
    };
    public bookgridAcitivityFragment(Context context){
        mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_bookgrid,container,false);

        GridView gv = (GridView)view.findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(mContext,book_names,book_images,type));
        gv.setSelector(new ColorDrawable(Color.TRANSPARENT));//
//        mTextView = (TextView)view.findViewById(R.id.text_fragment);
//        mTextView.setText(mContext);

        return view;
    }
}
