package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.FitCenter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.CropTransformation;

import static android.content.ContentValues.TAG;


/**
 * Created by zhangqian on 2017/10/17.
 */

public class bookgridAcitivityFragment extends Fragment {

    private Context mContext;
TextView textView;
    ImageView imageView;
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
    String[] book_names = {"霸道总裁霸道总裁霸道总裁霸道总裁霸道总裁","黑衣舰队",
            "夜幕降临","神墓","a","b","c","d","e","f","g","h"} ;
//    ArrayList<String> book_names = new ArrayList<>(Arrays.asList("霸道总裁霸道总裁霸道总裁霸道总裁霸道总裁","黑衣舰队",
//            "夜幕降临","神墓","a","b","c","d","e","f","g","h")) ;

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
        getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        View view = inflater.inflate(R.layout.activity_bookgrid,null);

        GridView gv = (GridView)view.findViewById(R.id.gridview);
//        ImageAdapter adapter = ne ImageAdapter(mContext,book_names,book_images,type);
//        gv.setAdapter(adapter);
        gv.setAdapter(new ImageAdapter(mContext,book_names,book_images,type));
        //adapter.notifyDataSetChanged();
        gv.setSelector(new ColorDrawable(Color.TRANSPARENT));//

        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(),ContainerActivity.class);
                getActivity().startActivity(intent);
                Toast.makeText(getActivity(),"成功",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }



}
