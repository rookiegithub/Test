package com.micbook.zhangqian.micbook;
import android.content.ContentValues;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.view.NestedScrollingChild;
import android.support.v4.widget.NestedScrollView;
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

import com.sothree.slidinguppanel.SlidingUpPanelLayout;

import static cn.bmob.v3.BmobRealTimeData.TAG;


/**
 * Created by zhangqian on 2017/10/17.
 */

public class messageAcitivityFragment extends Fragment {

    private Context mContext;
    private TextView mTextView;
    LinearLayout headview;
    int type_1 = 1;
    int [] book_image = {
            R.mipmap.medll,
            R.mipmap.bookln1,
            R.mipmap.bookhelp,
            R.mipmap.bookln,
            R.mipmap.weal,
            R.mipmap.hopeful,
    };
    String[] book_names = {
            "我的动态","广场吐槽",
            "书荒助手","吸睛神评",
            "福利大发送","敬请期待",

    };
    String[] book_info = {
            "神墓的世界","黑衣舰队的队长",
            "夜幕降临的时候","霸道总裁的裁缝"
    };
    String[] book_author = {
            "排骨","牛肉",
            "牡蛎","龙虾"
    };
    String[] fun_name = {
            "个人信息","消息中心",
            "文件管理","历史记录",
            "我的收藏"
    };
    private SlidingUpPanelLayout mLayout;

//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        mContext = context;
//    }

//    public messageAcitivityFragment(Context context){
//        mContext = context;
//    }
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
long time = System.currentTimeMillis();
        Log.i(TAG, "message1: "+time);
        headview = (LinearLayout) LayoutInflater.from(mContext).inflate(R.layout.slidingpaneup_layout,null);
//        headview = (RelativeLayout) LayoutInflater.from(mContext).inflate(R.layout.find_layout,null);
        final RelativeLayout he = (RelativeLayout)headview.findViewById(R.id.head_find);
//        final FrameLayout he1 = (FrameLayout)headview.findViewById(R.id.head);
//        final ListView listV = (ListView)headview.findViewById(R.id.list);

        View view = LayoutInflater.from(mContext).inflate(R.layout.layout2,null);
        //View view = LayoutInflater.from(mContext).inflate(R.layout.layout2,null);
        GridView gridView = (GridView)view.findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAdapter(mContext,book_names,book_image,2));
        //gridView.setAdapter(new ImageAdapter(mContext,book_names,book_image,2));
        ListView listView = (ListView)headview.findViewById(R.id.list);
        listView.addHeaderView(view);
        listView.setAdapter(new ImageAdapter(mContext,9));

        mLayout = (SlidingUpPanelLayout)headview.findViewById(R.id.sliding_layout);
        mLayout.addPanelSlideListener(new SlidingUpPanelLayout.PanelSlideListener() {
            @Override
            public void onPanelSlide(View panel, float slideOffset) {
                if(slideOffset == 1.0){
                    he.setBackgroundColor(Color.parseColor("#FFFFFF"));
                }else {
                    he.setBackgroundColor(Color.parseColor("#DCDCDC"));
                }
            }
            @Override
            public void onPanelStateChanged(View panel, SlidingUpPanelLayout.PanelState previousState, SlidingUpPanelLayout.PanelState newState) {

            }
        });
        long time1 = System.currentTimeMillis();
        Log.i(TAG, "message1: "+time1);
        Log.i(TAG, "message: "+(time1-time));
//        int a =new NestedScrollView(mScrollview).getScrollY();
//View headview1 = LayoutInflater.from(mContext).inflate(R.layout.layout1,null);
//        GridView gv = (GridView)headview.findViewById(R.id.renqigridview);
//        gv.setAdapter(new ImageAdapter(mContext,book_names,book_image,type_1));


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
