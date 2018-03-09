package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.micbook.holder.MZHolderCreator;
import com.micbook.holder.MZViewHolder;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

/**
 * Created by zhangqian on 2017/12/29.
 */

public class recommendActivityFragment extends Fragment {

    @Nullable
    int type_2 = 2;
    int type_1 = 1;
    private int[] cate_images = {
            R.mipmap.shoucang,
            R.mipmap.bayou,
            R.mipmap.huancun,
            R.mipmap.lishi,
    };
    private String[] cate_names = {
            "我是男生", "我是女生",
            "热门排行", "完本畅读"

    };
    private String[] book_names = {
            "神墓", "黑衣舰队",
            "夜幕降临", "霸道总裁霸道总裁霸道总裁霸道总裁", "梦醒十分"
    };
    private int[] book_image = {
            R.mipmap.shenmu,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.badao,
            R.mipmap.banner2
    };
    private int[] book_images = {
            R.mipmap.shenmu,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.banner2,
            R.mipmap.badao,
            R.mipmap.banner4,
            R.mipmap.ic_launcher_round
    };
    private int[] maxImage = {R.mipmap.maximage};
    private String[] maxImage_title = {"异兽化形，羽翼横空，屠戮诸天万界！"};
    private String[] MaxImage_info = {"穿越异界变成一只异兽，努力修炼化形，争取早日羽翼横空，遮天蔽日，那些不服的，统统干掉。"};
    private int maxImage1 = R.mipmap.maximage;
    private String maxImage_title1 = "异兽化形，羽翼横空，屠戮诸天万界！";
    private String MaxImage_info1 = "穿越异界变成一只异兽，努力修炼化形，争取早日羽翼横空，遮天蔽日，那些不服的，统统干掉。";
    private String[] book_name = {
            "神墓", "黑衣舰队",
            "夜幕降临", "霸道总裁霸道总裁霸道总裁霸道总裁霸道总裁", "梦醒十分",
            "6", "7"
    };
    private String[] book_infos = {
            "神墓的世界", "黑衣舰队的队长",
            "夜幕降临的时候", "霸道总裁的裁缝",
            "黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆...黑" +
                    "夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆",
            "q6", "q7"
    };
    private String[] book_authors = {
            "排骨", "牛肉",
            "牡蛎", "龙虾",
            "作者", "w6", "w7"
    };
    private String[] book_info = {
            "神墓的世界", "黑衣舰队的队长",
            "夜幕降临的时候", "霸道总裁的裁缝",
            "黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆...黑" +
                    "夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆黑夜已经来临，风呼呼的吹，嘀嗒，嘀嗒，十二点的闹钟显得格外的清脆"
    };
    private String[] book_author = {
            "排骨", "牛肉",
            "牡蛎", "龙虾",
            "作者"
    };
    public static final int []BANNER = new int[]{R.mipmap.banner1,R.mipmap.banner2,R.mipmap.banner3,R.mipmap.banner4,R.mipmap.banner5};
    //public static final int []BANNER = new int[]{R.mipmap.ic_launcher_round,R.mipmap.ic_launcher};
    private MZBannerView1 mMZBanner;
//    @Override
//    public void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        fetchData();
//    }
private Context mContext;
public void onAttach(Context context) {
    super.onAttach(context);
    mContext = context;
}
//    public recommendActivityFragment(Context context){
//        mContext = context;
//    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
 //       View view = fetchData();

//        if(view.getParent()!=null){
//            ((ViewGroup)view.getParent()).removeView(view);
//        }
        long t = System.currentTimeMillis();
        Log.i(TAG, "recommend "+ t);
        View banerView = LayoutInflater.from(mContext).inflate(R.layout.mz_mode_not_cover,null);
        initView(banerView, getActivity());
        GridView gv1 = (GridView) banerView.findViewById(R.id.bookCitygridview);
        gv1.setAdapter(new ImageAdapter(mContext, cate_names, cate_images, type_2));

        View renqiGridView = LayoutInflater.from(mContext).inflate(R.layout.activity_bookcity_bottom, null);
        GridView gv2 = (GridView) renqiGridView.findViewById(R.id.renqigridview);
        gv2.setSelector(new ColorDrawable(Color.TRANSPARENT));//点击GridView时出现背景色，可以给gridview设置setSelector背景色为透明色
        //gv2.setSelector(Color.parseColor("#000000"));
        gv2.setAdapter(new ImageAdapter(mContext, book_names, book_image, type_1));

        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_list,null);
        ListView listView = (ListView) view.findViewById(R.id.adapter_list);
        listView.addHeaderView(banerView);
        listView.addFooterView(initmaxImage());
        listView.addFooterView(renqiGridView);

        View qualityView = isBook_add(book_infos, book_name, book_images, book_authors);
        listView.addFooterView(qualityView);//精品推荐
        listView.setAdapter(new listviewAdapter(mContext, book_info, book_names, book_image, book_author));
        long t1 =System.currentTimeMillis();
        Log.i(TAG, "recommend1 "+ (t1-t));

        return view;
    }

//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
//
//        //View view = inflater.inflate(R.layout.)
//        View banerView = inflater.inflate(R.layout.mz_mode_not_cover,null);
//        new bannerInit().initView(banerView, getActivity());
//        GridView gv1 = (GridView) banerView.findViewById(R.id.bookCitygridview);
//        gv1.setAdapter(new ImageAdapter(getActivity(), cate_names, cate_images, type_2));
//
//        View renqiGridView = LayoutInflater.from(getActivity()).inflate(R.layout.activity_bookcity_bottom, null);
//        GridView gv2 = (GridView) renqiGridView.findViewById(R.id.renqigridview);
//        gv2.setSelector(new ColorDrawable(Color.TRANSPARENT));//点击GridView时出现背景色，可以给gridview设置setSelector背景色为透明色
//        gv2.setAdapter(new ImageAdapter(getActivity(), book_names, book_image, type_1));
//
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.adapter_list,null);
//        ListView listView = (ListView) view.findViewById(R.id.adapter_list);
//        listView.addHeaderView(banerView);
//        listView.addFooterView(initmaxImage());
//        listView.addFooterView(renqiGridView);
//
//        View qualityView = isBook_add(book_infos, book_name, book_images, book_authors);
//        listView.addFooterView(qualityView);//精品推荐
//        listView.setAdapter(new listviewAdapter(getActivity(), book_info, book_names, book_image, book_author));
//
//        return view;
//    }


    public View initmaxImage() {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.maximage_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.maxImage);
        imageView.setImageResource(maxImage1);
        TextView textView = (TextView) view.findViewById(R.id.maxImage_titile);
        textView.setText(maxImage_title1);
        TextView textView1 = (TextView) view.findViewById(R.id.maxImage_info);
        textView1.setText(MaxImage_info1);
        return view;
    }
    public View isBook_add(String[] book_infos, String[] book_name, int[] book_images, String[] book_authors) {
        View view;
        view = LayoutInflater.from(getActivity()).inflate(R.layout.adapter_list, null);
        ListView listView = (ListView) view.findViewById(R.id.adapter_list);
        listView.setAdapter(new listviewAdapter(getActivity(), book_infos, book_name, book_images, book_authors,MaxImage_info,maxImage_title,maxImage));
        micBookListView.setListViewHeightBasedOnChildren(listView);
        return view;
    }

//    @Override
//    public View fetchData() {
//        View banerView = LayoutInflater.from(getActivity()).inflate(R.layout.mz_mode_not_cover,null);
////        new bannerInit().initView(banerView, getActivity());
//        GridView gv1 = (GridView) banerView.findViewById(R.id.bookCitygridview);
//        gv1.setAdapter(new ImageAdapter(getActivity(), cate_names, cate_images, type_2));
//
//        View renqiGridView = LayoutInflater.from(getActivity()).inflate(R.layout.activity_bookcity_bottom, null);
//        GridView gv2 = (GridView) renqiGridView.findViewById(R.id.renqigridview);
//        gv2.setSelector(new ColorDrawable(Color.TRANSPARENT));//点击GridView时出现背景色，可以给gridview设置setSelector背景色为透明色
//        gv2.setAdapter(new ImageAdapter(getActivity(), book_names, book_image, type_1));
//
//        View view = LayoutInflater.from(getActivity()).inflate(R.layout.adapter_list,null);
//        ListView listView = (ListView) view.findViewById(R.id.adapter_list);
//        listView.addHeaderView(banerView);
//        listView.addFooterView(initmaxImage());
//        listView.addFooterView(renqiGridView);
//
//        View qualityView = isBook_add(book_infos, book_name, book_images, book_authors);
//        listView.addFooterView(qualityView);//精品推荐
//        listView.setAdapter(new listviewAdapter(getActivity(), book_info, book_names, book_image, book_author));
//
//        return view;
//    }
void initView(View view, final Context context) {

    mMZBanner = (MZBannerView1) view.findViewById(R.id.banner);
    mMZBanner.setBannerPageClickListener(new MZBannerView1.BannerPageClickListener() {
        @Override
        public void onPageClick(View view, int position) {
            Toast.makeText(context,"点击:"+position, Toast.LENGTH_LONG).show();
        }
    });
    List<Integer> bannerList = new ArrayList<>();
    for(int i=0;i<BANNER.length;i++){
        bannerList.add(BANNER[i]);
    }

    mMZBanner.setPages(bannerList, new MZHolderCreator<BannerViewHolder>() {
        @Override
        public BannerViewHolder createViewHolder() {
            return new BannerViewHolder();
        }
    });
    mMZBanner.start();
}

    public static class BannerViewHolder implements MZViewHolder<Integer> {
        private ImageView mImageView;
        @Override
        public View createView(Context context) {
            // 返回页面布局文件
            View view = LayoutInflater.from(context).inflate(R.layout.banner_item,null);
            mImageView = (ImageView) view.findViewById(R.id.banner_image);
            return view;
        }

        @Override
        public void onBind(Context context, int position, Integer data) {
            // 数据绑定
            mImageView.setImageResource(data);
        }
    }
}
