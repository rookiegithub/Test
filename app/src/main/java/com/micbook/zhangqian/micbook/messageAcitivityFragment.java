package com.micbook.zhangqian.micbook;
import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.nineoldandroids.view.ViewHelper;

import static cn.bmob.v3.BmobRealTimeData.TAG;


/**
 * Created by zhangqian on 2017/10/17.
 */

public class messageAcitivityFragment extends Fragment {

    private Context mContext;
    private TextView mTextView;
    RelativeLayout headview;
    int type_1 = 1;
    int [] book_image = {
            R.mipmap.shenmu,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.badao,
            R.mipmap.shenmu,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.badao,
            R.mipmap.shenmu,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.badao,
            R.mipmap.shenmu,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.badao,
            R.mipmap.shenmu,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.badao
    };
    String[] book_names = {
            "神墓","黑衣舰队",
            "夜幕降临","霸道总裁",
            "神墓","黑衣舰队",
            "夜幕降临","霸道总裁",
            "神墓","黑衣舰队",
            "夜幕降临","霸道总裁",
            "神墓","黑衣舰队",
            "夜幕降临","霸道总裁",
            "神墓","黑衣舰队",
            "夜幕降临","霸道总裁",
            "神墓","黑衣舰队",
            "夜幕降临","霸道总裁"
    };
    String[] book_info = {
            "神墓的世界","黑衣舰队的队长",
            "夜幕降临的时候","霸道总裁的裁缝"
    };
    String[] book_author = {
            "排骨","牛肉",
            "牡蛎","龙虾"
    };
    public messageAcitivityFragment(Context context){
        mContext = context;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        headview = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.find_layout,null);
        final RelativeLayout he = (RelativeLayout)headview.findViewById(R.id.head_find);
        final FrameLayout he1 = (FrameLayout)headview.findViewById(R.id.head);
//        final ListView listV = (ListView)headview.findViewById(R.id.list);

        //View headview1 = LayoutInflater.from(mContext).inflate(R.layout.layout1,null);
        GridView gv = (GridView)headview.findViewById(R.id.renqigridview);
        gv.setAdapter(new ImageAdapter(mContext,book_names,book_image,type_1));


//        listV.addHeaderView(headview1);
//        listV.setAdapter(new ImageAdapter(mContext,book_names,book_image,type_1));
//        final int c = 205;
//        he.getBackground().setAlpha(255);
//        he.setBackgroundColor(0xFFFFFFFF);
//        listV.setOnScrollListener(new AbsListView.OnScrollListener() {
//            int offset=0;
//                                         @Override
//                                         public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//                                         }
//                                         @Override
//                                         public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                                             if (firstVisibleItem == 0) {
//                                                 View firstItem = listV.getChildAt(0);
//                                                 if(firstItem !=null){
//                                                     offset = 0 - firstItem.getTop();
//                                                 }
//                                             } else {
//                                                 offset =c;
//                                             }
//                                             float percent = (offset * 1f) / (c * 1f);
//                                             if(percent >0 && percent <=1){
//                                                 int d = offset+50;
//                                                 Log.i(TAG, "onScrolla: "+d);
//                                                 String e = Integer.toHexString(d);//十进制转换为十六进制toHexString
//                                                 he.setBackgroundColor(Color.parseColor("#"+e+"FFFFFF"));//#是color颜色，e是透明通道，FFFFFF是颜色值，白色
//                                             }else if(percent==0){
//                                                 he.setBackgroundColor(0);
//                                             }
//                                         }
//
//                                     });

//        ListView listView = (ListView) view.findViewById(R.id.list);
//        listView.setAdapter(new ImageAdapter(mContext,book_info,book_names,book_image,book_author,type1));

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
        return headview;
        }

}
