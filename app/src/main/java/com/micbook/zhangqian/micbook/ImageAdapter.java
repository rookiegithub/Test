package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * Created by zhangqian on 2017/10/16.
 */

public class ImageAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private Context mContext;
    private String[] name;
    private int[] images;
    private String[] num_reply;
    private String[] num_praise;
    private String[] user_devices;
    private int type;
    private String[] book_info;
    private String[] book_name;
    private String[] book_author;
    private String[] str;
    private String[] str1;
    private String[] str2;
    private String[] str3;
    private String[] str4;
    private String[] str5;
    private String[] str6;
    private String[] str7;
    private int[] book_images;
    private int selectPosition = 0;

//    public ImageAdapter(Context context,String[] name,int[] images,int type){
//        mContext = context;
//        this.name = name;
//        this.images = images;
//        this.type = type;
//    }

    public void render(String[] str, int[] images, int type) {
        this.str = str;
        this.images = images;
        this.type = type;
        //notifyDataSetChanged();
    }

    public ImageAdapter(Context context, int type) {
        mContext = context;
        this.type = type;
    }

    public ImageAdapter(Context context, String[] str, int[] images, int type) {
        mContext = context;
        this.str = str;
        this.images = images;
        this.type = type;
    }

    public ImageAdapter(Context context, int type, String[] str2, String[] str3, String[] str4, String[] str5, String[] str6, String[] str7, int[] images) {

        mContext = context;
        this.type = type;
        this.images = images;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
        this.str5 = str5;
        this.str6 = str6;
        this.str7 = str7;

    }

    public ImageAdapter(Context context, int type, String[] str, String[] str1, String[] str2, String[] str3, int[] images) {

        mContext = context;
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.images = images;
        this.str2 = str2;
        this.str3 = str3;
//        this.str4 = str4;
//        this.str5 = str5;
//        this.str6 = str6;
//        this.str7 = str7;

    }

    public ImageAdapter(Context context, String[] user_nick, String[] user_comment, int[] user_image, String[] num_reply, String[] num_praise,String[] user_devices,int type) {
        mContext = context;
        str = user_nick;
        str1 = user_comment;
        images = user_image;
        this.num_reply = num_reply;
        this.num_praise = num_praise;
        this.user_devices = user_devices;
        this.type = type;
    }

    public ImageAdapter(Context context, int type, String[] str) {
        mContext = context;
        this.type = type;
        this.str = str;
    }

    public int getCount() {
        if (images == null) {
            if (str == null) {
                return 1;
            }
            return str.length;
        }
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        Log.i("getItem", "getItem: " + position);
        return position;
    }

    public void setSelectionPosition(int position) {
        selectPosition = position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (type == 1) {
            if(convertView==null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_booklayout, null);
                holder.iv = (ImageView) convertView.findViewById(R.id.adapter_image1);
                holder.tv = (TextView) convertView.findViewById(R.id.adapter_text1);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }


            holder.iv.setImageResource(images[position]);
            holder.tv.setText(str[position]);

 //           view = convertView.inflate(mContext, R.layout.adapter_booklayout, null);
//             Log.i("iamge1", String.valueOf(images));
//             iv.setLayoutParams(new GridView.LayoutParams(100, 100));//设置ImageView对象布局 
//             iv.setAdjustViewBounds(false);//设置边界对齐 
//             iv.setScaleType(ImageView.ScaleType.CENTER_CROP);//设置刻度的类型 
//             iv.setPadding(8, 8, 8, 8);//设置间距

//            ImageView iv = (ImageView) view.findViewById(R.id.adapter_image1);
//            TextView tv = (TextView) view.findViewById(R.id.adapter_text1);
//
//            iv.setImageResource(images[position]);
//            tv.setText(str[position]);
        } else if (type == 2) {
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_layout, null);

                //view = convertView.inflate(mContext, R.layout.adapter_layout, null);

                holder.iv = (ImageView) convertView.findViewById(R.id.adapter_image);
                holder.tv = (TextView) convertView.findViewById(R.id.adapter_text);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.iv.setImageResource(images[position]);
            holder.tv.setText(str[position]);
        } else if (type == 3) {
            // convertView = mInflater.from(mContext).inflate(R.layout.listview_layout,null);
            if(convertView == null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_layout, null);
                holder.iv = (ImageView) convertView.findViewById(R.id.images);
                holder.tv = (TextView) convertView.findViewById(R.id.book_name);
                holder.tv1 = (TextView) convertView.findViewById(R.id.book_info);
                holder.tv2 = (TextView) convertView.findViewById(R.id.author);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }

            holder.iv.setImageResource(book_images[position]);
            holder.tv.setText(book_name[position]);
            holder.tv1.setText(book_info[position]);
            holder.tv2.setText(book_author[position]);
        } else if (type == 4) {

            if(convertView == null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.rankadapter_layout, null);
                holder.iv = (ImageView) convertView.findViewById(R.id.title_image);
                holder.tv = (TextView) convertView.findViewById(R.id.end_book);
                holder.tv1 = (TextView) convertView.findViewById(R.id.end_bookInfo);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            //view = LayoutInflater.from(mContext).inflate(R.layout.rankadapter_layout, null);

//            TextView textView = (TextView) view.findViewById(R.id.end_book);
//            TextView textView1 = (TextView) view.findViewById(R.id.end_bookInfo);
//            ImageView imageView = (ImageView) view.findViewById(R.id.title_image);

            if (position < 2) {
                holder.tv.setText(str[position]);
                holder.tv.setTextColor(Color.parseColor("#9370DB"));
                holder.tv1.setText(str1[position]);
                holder.iv.setImageResource(images[position]);

            } else {
                holder.tv.setText(str[position]);
                holder.tv.setTextColor(Color.parseColor("#FFB6C1"));
                holder.tv1.setText(str1[position]);
                holder.iv.setImageResource(images[position]);

            }
        } else if (type == 5) {
            if(convertView == null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.rank_layout, null);
                holder.tv = (TextView) convertView.findViewById(R.id.head);
                holder.tv1 = (TextView) convertView.findViewById(R.id.book_name);
                holder.iv = (ImageView) convertView.findViewById(R.id.images);
                holder.tv2 = (TextView) convertView.findViewById(R.id.book_info);
                holder.tv3 = (TextView) convertView.findViewById(R.id.author);
                holder.tv4 = (TextView) convertView.findViewById(R.id.text);
                holder.tv5 = (TextView) convertView.findViewById(R.id.text_head);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.tv.setText(str2[position]);
            holder.tv1.setText(str3[position]);
            holder.tv2.setText(str4[position]);
            holder.tv3.setText(str5[position]);
            holder.tv4.setText(str6[position]);
            holder.tv5.setText(str7[position]);
            holder.iv.setImageResource(images[position]);

        } else if (type == 6) {
            if(convertView==null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.rankbottom_textlayout, null);
                holder.tv = (TextView) convertView.findViewById(R.id.first_rank);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
               holder.tv.setText(str[position]);
        } else if (type == 7) {
            if(convertView == null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.cate_layout, null);
                holder.tv = (TextView) convertView.findViewById(R.id.first_rank);
                holder.iv = (ImageView) convertView.findViewById(R.id.cateimage);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.tv.setText(str[position]);
            holder.iv.setImageResource(images[position]);
        } else if (type == 8) {
            if(convertView == null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.catehead_layout, null);
                holder.tv = (TextView) convertView.findViewById(R.id.first_rank);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            if (selectPosition == position) {
                holder.tv.setBackgroundColor(Color.parseColor("#FFFFFF"));
            } else {
                holder.tv.setBackgroundColor(Color.TRANSPARENT);
            }
            holder.tv.setText(str[position]);
        } else if (type == 9) {
              convertView = LayoutInflater.from(mContext).inflate(R.layout.layout1, null);
        }else if(type == 10){
            if(convertView == null){
                holder = new ViewHolder();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_comment, null);
                holder.tv = (TextView) convertView.findViewById(R.id.user_nick);
                holder.tv1 = (TextView) convertView.findViewById(R.id.user_comment);
                holder.tv2 = (TextView) convertView.findViewById(R.id.num_reply);
                holder.tv3 = (TextView) convertView.findViewById(R.id.num_praise);
                holder.tv4 = (TextView) convertView.findViewById(R.id.user_devices);
                holder.iv = (ImageView) convertView.findViewById(R.id.user_image);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            holder.tv.setText(str[position]);
            holder.tv1.setText(str1[position]);
            holder.tv2.setText(num_reply[position]);
            holder.tv3.setText(num_praise[position]);
            holder.tv4.setText("来自"+user_devices[position]+"客户端");
            holder.iv.setImageResource(images[position]);

            RelativeLayout.LayoutParams tv4Prams = (RelativeLayout.LayoutParams) holder.tv4.getLayoutParams();
//            tv4Prams.bottomMargin = position ==images.length-1?0:BookDetilFragment.dp2px(parent.getContext(),15);
//            holder.tv4.setLayoutParams(tv4Prams);

        }
//        else if(type == 11){
//            if(convertView == null){
//                holder = new ViewHolder();
//                convertView = LayoutInflater.from(mContext).inflate(R.layout.adapter_booklayout, null);
//                holder.tv = (TextView) convertView.findViewById(R.id.user_nick);
//                holder.tv1 = (TextView) convertView.findViewById(R.id.user_comment);
//                holder.tv2 = (TextView) convertView.findViewById(R.id.num_reply);
//                holder.tv3 = (TextView) convertView.findViewById(R.id.num_praise);
//                holder.tv4 = (TextView) convertView.findViewById(R.id.user_devices);
//                holder.iv = (ImageView) convertView.findViewById(R.id.user_image);
//                convertView.setTag(holder);
//            }else {
//                holder = (ViewHolder)convertView.getTag();
//            }
//            holder.tv.setText(str[position]);
//            holder.tv1.setText(str1[position]);
//            holder.tv2.setText(num_reply[position]);
//            holder.tv3.setText(num_praise[position]);
//            holder.tv4.setText("来自"+user_devices[position]+"客户端");
//            holder.iv.setImageResource(images[position]);
//        }

        return convertView;
    }
    static class ViewHolder {

        TextView tv;
        TextView tv1;
        TextView tv2;
        TextView tv3;
        TextView tv4;
        TextView tv5;
        ImageView iv;

    }



}
