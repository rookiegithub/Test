package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.media.Image;
import android.renderscript.Type;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhangqian on 2017/10/16.
 */

public class ImageAdapter extends BaseAdapter {


    private Context mContext;
    private String [] name;
    private int [] images;
    private int type;

    public ImageAdapter(Context context,String[] name,int[] images,int type){
        mContext = context;
        this.name = name;
        this.images = images;
        this.type = type;
    }
    public int getCount() {
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        return images[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;
//        if (convertView == null) {

         if(type==1){
 //            ImageView   iv = new ImageView(mContext);
             view = convertView.inflate(mContext,R.layout.adapter_booklayout,null);
//             Log.i("iamge1", String.valueOf(images));
//             iv.setLayoutParams(new GridView.LayoutParams(100, 100));//设置ImageView对象布局 
//             iv.setAdjustViewBounds(false);//设置边界对齐 
//             iv.setScaleType(ImageView.ScaleType.CENTER_CROP);//设置刻度的类型 
//             iv.setPadding(8, 8, 8, 8);//设置间距

             ImageView iv = (ImageView) view.findViewById(R.id.adapter_image1);
             TextView tv = (TextView) view.findViewById(R.id.adapter_text1);

             iv.setImageResource(images[position]);
             tv.setText(name[position]);
        }else if(type == 2){

             view = convertView.inflate(mContext,R.layout.adapter_layout,null);

             ImageView iv = (ImageView) view.findViewById(R.id.adapter_image);
             TextView tv = (TextView) view.findViewById(R.id.adapter_text);

             iv.setImageResource(images[position]);
             tv.setText(name[position]);
         }
        return view;




//
//        } else {
//            view = (View) convertView;
//        }



        }


}
