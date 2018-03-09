package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.hw.txtreaderlib.ui.HwTxtPlayActivity;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;



/**
 * Created by zhangqian on 2017/10/17.
 */

public class BookDetilFragment extends Fragment implements View.OnClickListener {

    private Context mContext;
    TextView textView;
    ImageView imageView;
    private TextView read;
    int type = 1;
    private List<Integer> mDatas = new ArrayList<>(Arrays.asList(
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
    ));

    ArrayList<String> book_names = new ArrayList<>(Arrays.asList("霸道总裁霸道总裁霸道总裁霸道总裁霸道总裁","黑衣舰队",
            "夜幕降临","神墓","a","b","c","d","e","f","g","h")) ;

    int[] user_image = {
            R.mipmap.shenmu,
            R.mipmap.badao,
            R.mipmap.blur,
            R.mipmap.ic_launcher,
            R.mipmap.banner5,
            R.mipmap.touxiang
    };
    String[] user_nick={
            "我是王二小",
            "我姓张，却张不出你喜欢的模样",
            "莫问我是谁",
            "风雨中",
            "梦里花落知多少",
            "一帘时光"
    };
    String[] user_comment={
            "很棒棒喔",
            "作者写得很好，很不错，值得一看",
            "强烈推荐，力荐！！",
            "看完让我泪流满面~",
            "我想知道，最后的结局，男主和女主在一起了吗？",
            "虐！虐！！虐！！！"
    };
    String[] num_reply={
            "5","9","6","8","15","53"
    };
    String[] num_praise={
            "50","30","40","60","80","89"
    };
    String[] user_devices={
            "Android","iOS","Android","iOS","Android","iOS"
    };
    //    public bookgridAcitivityFragment(Context context){
//        mContext = context;
//    }
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }
    //    public bookgridAcitivityFragment(){
//    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        final View view = inflater.inflate(R.layout.bookdetail_layout,container,false);

        Glide.with(this).load(R.mipmap.blur)
                .bitmapTransform(new BlurTransformation(mContext,70),new CenterCrop(mContext))
                .into((ImageView) view.findViewById(R.id.book_blur));
        Glide.with(this).load(R.mipmap.blur)
                .bitmapTransform(new CropTransformation(mContext))
                .into((ImageView) view.findViewById(R.id.book_cover));
        final micBookOnScrollView relativeLayout = (micBookOnScrollView) view.findViewById(R.id.scrollView);
        relativeLayout.setFocusableInTouchMode(true);
        relativeLayout.requestFocus();

        final RelativeLayout relativelayout1 = (RelativeLayout) view.findViewById(R.id.head);
        LinearLayout linearLayout = (LinearLayout)view.findViewById(R.id.bookdetail_bottom);
        relativeLayout.setScrollViewListener(new micBookOnScrollView.ScrollViewListener() {
            @Override
            public void onScrollChanged(micBookOnScrollView scrollView, int x, int y, int oldx, int oldy) {

                //int animtop = relativeLayout.getTop() -y;

//                int d = scrollView.getHeight()-c;
//                Log.i(TAG, "onScrollChanged: "+d);
                RelativeLayout re = (RelativeLayout)view.findViewById(R.id.head_layout);
//                RelativeLayout.LayoutParams parms = (RelativeLayout.LayoutParams)relativelayout1.getLayoutParams();
//
//                parms.height = relativelayout1.getHeight()-y;
//                relativelayout1.setLayoutParams(parms);
                if(y>= dp2px(getContext(),115)){
                    relativelayout1.setVisibility(View.GONE);
                    re.setBackgroundColor(Color.parseColor("#F6F6F6"));
                }else {
                    re.setBackgroundColor(Color.TRANSPARENT);
                    relativelayout1.setVisibility(View.VISIBLE);

                }

            }
//            int c = 205;
//            int offset = 0;
//            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount){
//                if(firstVisibleItem == 0){
//                    View firstItem = relativelayout1.getChildAt(0);
//                    if(firstItem != null){
//                         offset = 0 - firstItem.getTop();
//                    }
//                }else {
//                    offset = c;
//                }
//            }
        });
        ListView listView = (ListView)view.findViewById(R.id.comment);

        listView.setAdapter(new ImageAdapter(getActivity(),user_nick,user_comment,user_image,num_reply,num_praise,user_devices,10));
        micBookListView.setListViewHeightBasedOnChildren(listView);
//        HorizontalScrollView horizontalScrollView = (HorizontalScrollView)view.findViewById(R.id.slide);

        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.recycler);
        recyclerView.addItemDecoration(new spaceItemDecoration(0,0,20,20));
        int spanCount = 1;
//        RecyclerView linearLayout = new RecyclerView(getActivity());
//        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(spanCount,StaggeredGridLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(new micBookReryclerView(mDatas,book_names));

        //micBookListView.setListViewHeightBasedOnChildren(listView1);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        read = (TextView)getActivity().findViewById(R.id.read);
//        read.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                micBookUitl.toastShow(mContext,"成功");
//            }
//        });

        read.setOnClickListener(this);
    }

    private String FilePath = Environment.getExternalStorageDirectory() + "//Download//" +"/神墓.txt";
    public void onClick(View view){
    switch (view.getId()){
        case R.id.read:
            if(!new File(FilePath).exists()){
                micBookUitl.toastShow(mContext,"文件不存在");
            }else {
                HwTxtPlayActivity.loadTxtFile(getActivity(), FilePath);
            }
            break;

default:
    micBookUitl.toastShow(mContext,"失敗");
    }
}

    public static int dp2px(Context context, float dpVal)
    {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,

                dpVal, context.getResources().getDisplayMetrics());

    }

//
//    @Override
//    public void onClick(View view) {
//
//    }
}
