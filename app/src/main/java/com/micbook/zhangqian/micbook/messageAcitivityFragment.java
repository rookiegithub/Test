package com.micbook.zhangqian.micbook;

import android.app.Fragment;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;

import android.widget.AbsListView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        headview = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.find_layout,null);
        final RelativeLayout he = (RelativeLayout)headview.findViewById(R.id.head_find);
        final ListView listView = (ListView)headview.findViewById(R.id.list);

        View headview1 = LayoutInflater.from(mContext).inflate(R.layout.layout1,null);
        GridView gv = (GridView)headview1.findViewById(R.id.renqigridview);
        gv.setAdapter(new ImageAdapter(mContext,book_names,book_image,type_1));


        listView.addHeaderView(headview1);
        listView.setAdapter(new ImageAdapter(mContext,book_names,book_image,type_1));

        listView.setOnTouchListener(new OnTouchListener() {
            float downY = 0;
            float moveY=0;
            @Override
            public boolean onTouch(View v, MotionEvent event) {



                switch (event.getAction()){

                    case MotionEvent.ACTION_UP:
                        Log.i(TAG, "onTouch4: "+event.getY());
                        moveY = Math.abs(downY-event.getY());

                        Log.i(TAG, "onCreateView: "+moveY);

                        break;
                    case MotionEvent.ACTION_DOWN:
                        downY = event.getY();

                        //Log.i(TAG, "onTouch2: "+downY);
                        break;
//                    case MotionEvent.ACTION_UP:
//                        float moveZ =downY- event.getY();
//                        Log.i(TAG, "onTouch3: "+moveZ);

                }
                if(moveY>=220){
                    he.setBackgroundColor(Color.parseColor("#FFB6C1"));
                    Toast.makeText(mContext,"下滑"+moveY,Toast.LENGTH_LONG).show();
                }else {
                    he.setBackgroundColor(Color.parseColor("#DCDCDC"));
                }
                return false;

            }
        }) ;


//            @Override
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                int oldvisibleItem=0;
//                if( oldvisibleItem>=1 ){
//                    headview.setBackgroundColor(Color.parseColor("#FFFFFF"));
//
//                    Toast.makeText(mContext,"下滑"+oldvisibleItem,Toast.LENGTH_LONG).show();
//                }else if(oldvisibleItem==firstVisibleItem){
//
//                    Toast.makeText(mContext,"等于，应该变色"+oldvisibleItem,Toast.LENGTH_LONG).show();
//                }else {
//                    headview.setBackgroundColor(Color.parseColor("#DCDCDC"));
//
//                    Toast.makeText(mContext,"上滑"+oldvisibleItem,Toast.LENGTH_LONG).show();
//
//                }
//                oldvisibleItem = firstVisibleItem;
//                Log.i(TAG, "onScroll: "+oldvisibleItem);
//
//            }

//        LinearLayout invis = (LinearLayout)view.findViewById(R.id.invis);
//       String[] strs=new String[100];
//
//        for(int i = 0; i < 20; i++){
//           strs[i] = "data-----" +i;
//};
//
//        ListView lv = (ListView)view.findViewById(R.id.lv);
//        View header = View.inflate(getActivity(), R.layout.rankadapter_layout, null);//头部内容
//        lv.addHeaderView(header);//添加头部
//        lv.addHeaderView(View.inflate(getActivity(), R.layout.rankhead_layout, null));//ListView条目中的悬浮部分 添加到头部
//
////        lv.setAdapter(new listviewAdapter(this,

//                android.R.layout.simple_list_item_1,strs));
//        final int c = 200;
//        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
//            int offset=0;
//                                         @Override
//                                         public void onScrollStateChanged(AbsListView view, int scrollState) {
//
//                                         }
//
//                                         @Override
//                                         public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
//                                             if (firstVisibleItem == 0) {
//                                                 View firstItem = listView.getChildAt(0);
//                                                 if(firstItem !=null){
//                                                     offset = 0 - firstItem.getTop();
//                                                 }
//
//                                             } else {
//
//                                                 offset =c;
//                                             }
//                                             float percent = (offset * 1f) / (c * 1f);
//                                             if(percent >=0 && percent <=1){
//                                                 he.setAlpha(percent);
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
