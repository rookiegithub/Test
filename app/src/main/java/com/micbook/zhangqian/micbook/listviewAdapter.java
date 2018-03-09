package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.media.Image;
import android.provider.Settings;
import android.renderscript.Type;
import android.support.design.widget.TabLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by zhangqian on 2017/10/16.
 */

public class listviewAdapter extends BaseAdapter {

    int maxImage1 = R.mipmap.maximage;
    String maxImage_title1 = "异兽化形，羽翼横空，屠戮诸天万界！";
    String MaxImage_info1 = "穿越异界变成一只异兽，努力修炼化形，争取早日羽翼横空，遮天蔽日，那些不服的，统统干掉。";
    private Context mContext;

    private int [] book_images={};
    //private int type;
    private String[] book_info;
    private String[] book_name;
    private String[] book_author;

    private int  book_images1;
    private int[] maxImage={};
    private String[] maxImage_title;
    private String[] maxImage_info;
    private int type_book=1;
    private int type_maxImage=2;

    public listviewAdapter(Context context,String[] book_info,String[] book_name,int[] book_images,String []book_author,String[] maxImage_info,String[] maxImage_title, int[] maxImage){
        mContext = context;
//        List<String> bookInfoList = Arrays.asList(book_info);
        this.book_info = book_info;
//        ArrayList<String> c = new ArrayList<>(bookInfoList);
//        c.add(Math.min(book_info.length,5),MaxImage_info1);
//        String [] strings = new String[c.size()];
//        this.book_info= c.toArray(strings);
//        this.book_info = (String[]) c.toArray();
        this.book_name = book_name;
        this.book_images = book_images;
        this.book_author = book_author;
        this.maxImage = maxImage;
        this.maxImage_title = maxImage_title;
        this.maxImage_info = maxImage_info;
    }
    public listviewAdapter(Context context,String[] book_info,String[] book_name,int[] book_images,String[] book_author){
        mContext = context;
//        List<String> bookInfoList = Arrays.asList(book_info);
       this.book_info = book_info;
//        ArrayList<String> c = new ArrayList<>(bookInfoList);
//        c.add(Math.min(book_info.length,5),MaxImage_info1);
//        String [] strings = new String[c.size()];
//        this.book_info= c.toArray(strings);
//        Log.i(TAG, "listviewAdapter12: "+book_info.length);
        this.book_name = book_name;
        this.book_info = book_info;
        this.book_images = book_images;
        this.book_author = book_author;
    }
    public int getViewItemType(int position){
        if(position < 5){
            return type_book;
        }else {
            int viewItemType = position % 5;
            if (viewItemType == 0) {
                return type_maxImage;//2
            } else {
                return type_book;//1
            }
        }
    }

    public int getCount() {
        if (book_images == null) {
            return book_images1;
        } else {
            return (book_images.length + maxImage.length);
        }
    }
    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int typeView = getViewItemType(position);
        int a = 0;

            switch (typeView){

                case 1:
                        //view = convertView.inflate(mContext, R.layout.listview_layout, null);
                    if(convertView == null){
                    holder = new ViewHolder();
                        convertView = LayoutInflater.from(mContext).inflate(R.layout.listview_layout, null);
                        holder.iv = (ImageView) convertView.findViewById(R.id.images);
                        holder.tv  = (TextView) convertView.findViewById(R.id.book_name);//bookName
                        holder.tv1 = (TextView) convertView.findViewById(R.id.book_info);//TextView bookInfo
                        holder.tv2 = (TextView) convertView.findViewById(R.id.author);//TextView bookAuthor
                    convertView.setTag(holder);
                    }else {
                    holder = (ViewHolder)convertView.getTag();
                }


                    //TextView booktitle = (TextView)view.findViewById(R.id.head);
                    Log.i("tag", "getView: "+book_images.length+","+position);
                    if(position<5){
                        holder.iv.setImageResource(book_images[position]);
                        holder.tv.setText(book_name[position]);//bookName
                        holder.tv1.setText(book_info[position]);//bookInfo
                        holder.tv2.setText(book_author[position]);//bookAuthor
                    }else {
                        int e = (book_images.length+maxImage.length)/5;
                        holder.iv.setImageResource(book_images[position - e]);
                        holder.tv.setText(book_name[position - e]);//bookName
                        holder.tv1.setText(book_info[position - e]);//bookInfo
                        holder.tv2.setText(book_author[position - e]);//bookAuthor
                    }
                    break;
                case 2:

                    int b = 0;
                    if((position%5)==0){
                        b = a+b;
                        a++;
                    }
                    if(convertView==null){
                        holder = new ViewHolder();
                        convertView = LayoutInflater.from(mContext).inflate(R.layout.maximage_layout, null);
                        holder.iv = (ImageView) convertView.findViewById(R.id.maxImage);
                        holder.tv1 = (TextView) convertView.findViewById(R.id.maxImage_titile);
                        holder.tv2 = (TextView) convertView.findViewById(R.id.maxImage_info);
                        convertView.setTag(holder);
                }else {
                        holder = (ViewHolder)convertView.getTag();
                    }
                    holder.iv.setImageResource(maxImage[b]);
                    holder.tv1.setText(maxImage_title[b]);//textView
                    holder.tv2.setText(maxImage_info[b]);//textView1
        }


//            case 1:
//                view = convertView.inflate(mContext, R.layout.listview_layout, null);
//                ImageView bookimage1 = (ImageView) view.findViewById(R.id.images);
//                TextView bookName1 = (TextView) view.findViewById(R.id.book_name);
//                TextView bookInfo1 = (TextView) view.findViewById(R.id.book_info);
//                TextView bookAuthor1 = (TextView) view.findViewById(R.id.author);
//                //TextView booktitle = (TextView)view.findViewById(R.id.head);
//                Log.i("tag", "getView: "+book_images);
//                bookimage1.setImageResource(book_images1);
//                bookName1.setText(book_name1);
//                bookInfo1.setText(book_info1);
//                bookAuthor1.setText(book_author1);
//
//                break;


        return convertView;
    }
static class ViewHolder{
    TextView tv;
    TextView tv1;
    TextView tv2;
    ImageView iv;
    }

}
