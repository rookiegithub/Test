package com.micbook.zhangqian.micbook;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static android.content.ContentValues.TAG;


/**
 * Created by zhangqian on 2017/10/17.
 */

public class BookDetailsFragment extends Fragment {

    LayoutInflater inflater;
    public Context mContext;
    public String[]  str;
    public int[] images;
    private int type;
//    public viewPageAdapter(Context context, String[] str, int[] images, int type) {
//        mContext = context;
//        this.str = str;
//        this.images = images;
//        this.type = type;
//    }
//
//    @Override
//    public int getCount() {
//        if(images==null){
//            return str.length;
//        }else {
//            return images.length;
//        }
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return 0;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//          ViewHolder holder;
//        if(convertView == null){
//            holder = new ViewHolder();
//            convertView = inflater.from(mContext).inflate(R.layout.adapter_booklayout, null);
//
//            holder.iv = (ImageView) convertView.findViewById(R.id.adapter_image1);
//            holder.tv = (TextView) convertView.findViewById(R.id.adapter_text1);
//
//            convertView.setTag(holder);
//
//        }else {
//            holder = (ViewHolder) convertView.getTag();
//        }
//
////        holder.iv.setImageResource(images[position]);
//        holder.tv.setText(str[position]);
//
//        return convertView;
//    }
//     static class ViewHolder {
//
//        public ImageView iv;
//        public TextView tv;
//
//    }

}
