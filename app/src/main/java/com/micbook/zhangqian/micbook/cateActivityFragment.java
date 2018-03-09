package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangqian on 2018/1/2.
 */

public class cateActivityFragment extends Fragment {

    @Nullable
    int type_2 =2;
    int type_7 =7;
    int type_8 =8;
    private GridView gv =null;
    private GridView gv1=null;
    private ListView lv = null;
    private ImageAdapter imageAdapter =null;
    private int[] cate_images = {
            R.mipmap.badao,
            R.mipmap.heiyi,
            R.mipmap.yemu,
            R.mipmap.shenmu,
    };
    private String[] cate_names = {
            "我是男生", "我是女生",
            "热门排行", "完本畅读"
    };
    private String catehead[]={"男生","女生","漫画","出版"};
    private int[] cateimage={R.mipmap.taigu, R.mipmap.yilu,R.mipmap.wanqian,R.mipmap.ranxue};
    private String catetag_boy[]={"太古王者","一路狂霸","万千位面","燃血兵王"};
    private String catetag_girl[]={"毒医","扮猪吃虎","宝宝","爆笑"};
    private String catetag_chuban[]={"成功励志","青春美女","悬疑社区","影视原著"};
    private String catetag_manhua[]={"穿越","宫廷","惊悚","古墓"};
    private Context mContext;
//    public cateActivityFragment(Context context){
//        mContext = context;
//    }
public void onAttach(Context context) {
    super.onAttach(context);
    mContext = context;
}
    private List<String[]> catalogStr = Arrays.asList(catetag_boy,catetag_girl,catetag_chuban,catetag_manhua);
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.bookcity_catelayout,null);
        lv = (ListView)view.findViewById(R.id.lv);
        gv = (GridView)view.findViewById(R.id.gv);
        gv.setSelector(new ColorDrawable(Color.TRANSPARENT));

        gv1 = (GridView)view.findViewById(R.id.gv1);
        final ImageAdapter gvAdapter = new ImageAdapter(mContext, catetag_boy, cateimage, type_7);
        gv.setAdapter(gvAdapter);
        final ImageAdapter gvOneAdapter = new ImageAdapter(mContext, cate_names, cate_images, type_2);
        gv1.setAdapter(gvOneAdapter);
        imageAdapter = new ImageAdapter(mContext, type_8, catehead);
        lv.setAdapter(imageAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                imageAdapter.setSelectionPosition(position);
                imageAdapter.notifyDataSetInvalidated();
                gvAdapter.render(catalogStr.get(position), cateimage, 7);
                gv.setAdapter(gvAdapter);
                gvOneAdapter.render(cate_names, cate_images, 2);
                gv1.setAdapter(gvOneAdapter);


            }
        });
        return view;
    }
}