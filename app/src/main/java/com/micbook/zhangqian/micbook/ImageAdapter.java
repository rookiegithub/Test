package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by zhangqian on 2017/10/16.
 */

public class ImageAdapter extends BaseAdapter {

private LayoutInflater mInflater;
    private Context mContext;
    private String [] name;
    private int [] images;
    private int [] book_images;
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
    private String[] ranktext;
    private int selectPosition = 0;

//    public ImageAdapter(Context context,String[] name,int[] images,int type){
//        mContext = context;
//        this.name = name;
//        this.images = images;
//        this.type = type;
//    }

    public void render(String[] str,int[] images,int type){
        this.str = str;
        this.images = images;
        this.type = type;
        //notifyDataSetChanged();
    }
    public ImageAdapter(){

    }

    public ImageAdapter(Context context,String[] str,int[] images,int type){
        mContext = context;
        this.str = str;
        this.images = images;
        this.type = type;
    }
    public ImageAdapter(Context context,int type,String[]str2,String[]str3,String[] str4,String[] str5,String[] str6,String[] str7,int[] images){

        mContext = context;
        this.type = type;
        this.images=images;
        this.str2 = str2;
        this.str3 = str3;
        this.str4 = str4;
        this.str5 = str5;
        this.str6 = str6;
        this.str7 = str7;

    }
    public ImageAdapter(Context context,int type,String[] str,String[] str1,String[] str2,String[] str3,int [] images){

        mContext = context;
        this.type = type;
        this.str = str;
        this.str1 = str1;
        this.images=images;
        this.str2 = str2;
        this.str3 = str3;
//        this.str4 = str4;
//        this.str5 = str5;
//        this.str6 = str6;
//        this.str7 = str7;

    }
    public ImageAdapter(Context context,String[] book_info,String[] book_name,int[] book_images,String []book_author,int type){
        mContext = context;
        this.book_name = book_name;
        this.book_info = book_info;
        this.book_images = book_images;
        this.type = type;
        this.book_author = book_author;
    }

    public ImageAdapter(Context context, int type,String[] str) {
        mContext = context;
        this.type = type;
        this.str = str;
    }

    public int getCount() {
if(images==null){
    return str.length;
}
        return images.length;
    }

    @Override
    public Object getItem(int position) {
        Log.i("getItem", "getItem: "+position);
        return position;
    }
    public void setSelectionPosition(int position) {
        selectPosition = position;
    }
//    public void setSelection(int position){
//        selectPosition = position;
//    }
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
             tv.setText(str[position]);
             }else if (type == 2) {
                 view = convertView.inflate(mContext, R.layout.adapter_layout, null);

                 ImageView iv = (ImageView) view.findViewById(R.id.adapter_image);
                 TextView tv = (TextView) view.findViewById(R.id.adapter_text);

                 iv.setImageResource(images[position]);
                 tv.setText(str[position]);
             } else if (type == 3) {
                // convertView = mInflater.from(mContext).inflate(R.layout.listview_layout,null);
                 view = convertView.inflate(mContext, R.layout.listview_layout, null);

                 ImageView bookimage = (ImageView) view.findViewById(R.id.images);
                 TextView bookName = (TextView) view.findViewById(R.id.book_name);
                 TextView bookInfo = (TextView) view.findViewById(R.id.book_info);
                 TextView bookAuthor = (TextView) view.findViewById(R.id.author);

                 bookimage.setImageResource(book_images[position]);
                 bookName.setText(book_name[position]);
                 bookInfo.setText(book_info[position]);
                 bookAuthor.setText(book_author[position]);
             }else if(type ==4) {

             view = LayoutInflater.from(mContext).inflate(R.layout.rankadapter_layout, null);

             TextView textView = (TextView) view.findViewById(R.id.end_book);
             TextView textView1 = (TextView) view.findViewById(R.id.end_bookInfo);
             ImageView imageView = (ImageView) view.findViewById(R.id.title_image);
//             TextView textView2 = (TextView)view.findViewById(R.id.text);
//             TextView textView3 = (TextView)view.findViewById(R.id.text_head);
//             TextView textView4 = (TextView)view.findViewById(R.id.serial_book);
//             TextView textView5 = (TextView)view.findViewById(R.id.serial_bookInfo);
//             TextView textView6 = (TextView)view.findViewById(R.id.week);
//             TextView textView7 = (TextView)view.findViewById(R.id.weekInfo);
             if (position < 2) {
                 textView.setText(str[position]);
                 textView.setTextColor(Color.parseColor("#9370DB"));
                 textView1.setText(str1[position]);
                 imageView.setImageResource(images[position]);
//                 textView2.setText(str2[position]);
//                 textView3.setText(str3[position]);
             } else {
                 textView.setText(str[position]);
                 textView.setTextColor(Color.parseColor("#FFB6C1"));
                 textView1.setText(str1[position]);
                 imageView.setImageResource(images[position]);

             }
         }else if(type == 5){
             view = LayoutInflater.from(mContext).inflate(R.layout.rank_layout, null);

             TextView textView = (TextView) view.findViewById(R.id.head);
             TextView textView1 = (TextView) view.findViewById(R.id.book_name);
             ImageView imageView = (ImageView) view.findViewById(R.id.images);
             TextView textView2 = (TextView) view.findViewById(R.id.book_info);
             TextView textView3 = (TextView) view.findViewById(R.id.author);
             TextView textView4 = (TextView) view.findViewById(R.id.text);
             TextView textView5 = (TextView) view.findViewById(R.id.text_head);

             textView.setText(str2[position]);
             textView1.setText(str3[position]);
             textView2.setText(str4[position]);
             textView3.setText(str5[position]);
             textView4.setText(str6[position]);
             textView5.setText(str7[position]);
             imageView.setImageResource(images[position]);

         } else if(type == 6){
             view = LayoutInflater.from(mContext).inflate(R.layout.rankbottom_textlayout,null);
             TextView textView = (TextView)view.findViewById(R.id.first_rank);
             textView.setText(str[position]);
         }else if(type == 7){
             view = LayoutInflater.from(mContext).inflate(R.layout.cate_layout,null);
             TextView textView = (TextView)view.findViewById(R.id.first_rank);
             ImageView imageView = (ImageView) view.findViewById(R.id.cateimage);
             textView.setText(str[position]);
             imageView.setImageResource(images[position]);
         }else if(type == 8){
             view = LayoutInflater.from(mContext).inflate(R.layout.catehead_layout,null);
             TextView textView = (TextView)view.findViewById(R.id.first_rank);
             if(selectPosition == position){
                 textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
             }else {
                 textView.setBackgroundColor(Color.TRANSPARENT);
             }
             textView.setText(str[position]);
         }

        return view;
//
//        } else {
//            view = (View) convertView;
//        }
        }

}
