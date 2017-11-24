//package com.micbook.zhangqian.micbook;
//
//
//import android.content.Context;
//import android.graphics.Color;
//import android.graphics.drawable.ColorDrawable;
//import android.os.Bundle;
//import android.support.design.widget.TabLayout;
//
//import android.support.v4.app.Fragment;
//import android.support.v4.view.ViewPager;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.GridView;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.ListView;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import java.util.ArrayList;
//import java.util.List;
//
//
///**
// * Created by zhangqian on 2017/10/17.
// */
//
//public class Adapter extends Fragment {
//
//    private Context mContext;
//    //int type_1 = 1;
//    int type_2 = 2;
//    int[] cate_images = {
//            R.mipmap.badao,
//            R.mipmap.heiyi,
//            R.mipmap.yemu,
//            R.mipmap.shenmu,
//    };
//    String[] cate_names = {
//            "我是男生", "我是女生",
//            "热门排行", "完本畅读"
//
//    };
//
//    int type_3 = 3;
//    int type_1 = 1;
//    int[] book_image = {
//            R.mipmap.shenmu,
//            R.mipmap.heiyi,
//            R.mipmap.yemu,
//            R.mipmap.badao,
//            R.mipmap.banner2
//    };
//    int[] book_images = {
//            R.mipmap.shenmu,
//            R.mipmap.heiyi,
//            R.mipmap.yemu,
//            R.mipmap.banner2,
//            R.mipmap.badao,
//            R.mipmap.banner4,
//            R.mipmap.ic_launcher_round
//    };
//    String[] book_name = {
//            "神墓", "黑衣舰队",
//            "夜幕降临", "霸道总裁", "梦醒十分",
//            "6", "7"
//    };
//    String[] book_infos = {
//            "神墓的世界", "黑衣舰队的队长",
//            "夜幕降临的时候", "霸道总裁的裁缝",
//            "黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆...黑" +
//                    "夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆",
//            "q6", "q7"
//    };
//    String[] book_authors = {
//            "排骨", "牛肉",
//            "牡蛎", "龙虾",
//            "作者", "w6", "w7"
//    };
//    String[] book_names = {
//            "神墓", "黑衣舰队",
//            "夜幕降临", "霸道总裁", "梦醒十分"
//    };
//    String[] book_info = {
//            "神墓的世界", "黑衣舰队的队长",
//            "夜幕降临的时候", "霸道总裁的裁缝",
//            "黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆...黑" +
//                    "夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆"
//    };
//    String[] book_author = {
//            "排骨", "牛肉",
//            "牡蛎", "龙虾",
//            "作者"
//    };
//    int[] maxImage = {R.mipmap.maximage};
//    String[] maxImage_title = {"异兽化形，羽翼横空，屠戮诸天万界！"};
//    String[] MaxImage_info = {"穿越异界变成一只异兽，努力修炼化形，争取早日羽翼横空，遮天蔽日，那些不服的，统统干掉。"};
//    int maxImage1 = R.mipmap.maximage;
//    String maxImage_title1 = "异兽化形，羽翼横空，屠戮诸天万界！";
//    String MaxImage_info1 = "穿越异界变成一只异兽，努力修炼化形，争取早日羽翼横空，遮天蔽日，那些不服的，统统干掉。";
//    //String head = "本周Top5";
//    public Adapter(Context context) {
//        mContext = context;
//    }
//public Adapter(){
//
//}
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.mz_mode_not_cover, null);
//        new bannerInit().initView(view, mContext);
//
////        GridView gv1 = (GridView) view.findViewById(R.id.bookCitygridview);
////        gv1.setAdapter(new ImageAdapter(mContext, cate_names, cate_images, type_2));
////
////        View view1 = inflater.inflate(R.layout.activity_bookcity_bottom, null);
////        GridView gv2 = (GridView) view1.findViewById(R.id.renqigridview);
////        gv2.setSelector(new ColorDrawable(Color.TRANSPARENT));
////        gv2.setAdapter(new ImageAdapter(mContext, book_names, book_image, type_1));
//
//        LinearLayout linearLayout = (LinearLayout) inflater.inflate(R.layout.baner_list, null);
//        ViewPager viewPager = (ViewPager) linearLayout.findViewById(R.id.viewPage);
//        viewPageAdapter viewPageAdapter = new viewPageAdapter(getActivity());
//        viewPager.setAdapter(viewPageAdapter);
////        TabLayout tablayout = (TabLayout) linearLayout.findViewById(R.id.title1);
////        tablayout.addTab(tablayout.newTab().setText("书城"));
////        tablayout.addTab(tablayout.newTab().setText("排行"));
////        tablayout.addTab(tablayout.newTab().setText("分类"));
////        ListView listView = (ListView) linearLayout.findViewById(R.id.list);
//
////        tablayout.setupWithViewPager(viewPager);
////        View maximageview = initmaxImage();
////        listView.addHeaderView(view);
////        listView.addFooterView(maximageview);
////        listView.addFooterView(view1);
////        View view3 = isBook_add(book_infos, book_name, book_images, book_authors);
////        listView.addFooterView(view3);
////        listView.setAdapter(new listviewAdapter(mContext, book_info, book_names, book_image, book_author));
////        micBookListView.setListViewHeightBasedOnChildren(listView);
//        return view;
//
//    }
//
//    public View initmaxImage() {
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.maximage_layout, null);
//        ImageView imageView = (ImageView) view.findViewById(R.id.maxImage);
//        imageView.setImageResource(maxImage1);
//        TextView textView = (TextView) view.findViewById(R.id.maxImage_titile);
//        textView.setText(maxImage_title1);
//        TextView textView1 = (TextView) view.findViewById(R.id.maxImage_info);
//        textView1.setText(MaxImage_info1);
//        return view;
//
//    }
//
//    public View initBottomList() {
//
//        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_list, null);
//        ListView listView = (ListView) view.findViewById(R.id.adapter_list);
//        listView.setAdapter(new listviewAdapter(mContext, book_infos, book_name, book_images, book_authors));
//        micBookListView.setListViewHeightBasedOnChildren(listView);
//        return view;
//    }
//
//    public View isBook_add(String[] book_infos, String[] book_name, int[] book_images, String[] book_authors) {
//        View view = null;
//        view = LayoutInflater.from(mContext).inflate(R.layout.adapter_list, null);
//        ListView listView = (ListView) view.findViewById(R.id.adapter_list);
//        listView.setAdapter(new listviewAdapter(mContext, book_infos, book_name, book_images, book_authors,MaxImage_info,maxImage_title,maxImage));
//        micBookListView.setListViewHeightBasedOnChildren(listView);
//
//        return view;
//    }
//}
