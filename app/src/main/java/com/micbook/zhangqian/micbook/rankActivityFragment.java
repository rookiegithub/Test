package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ListView;

/**
 * Created by zhangqian on 2018/1/2.
 */

public class rankActivityFragment extends Fragment {

    @Nullable
    int type_4 =4;
    int type_5 =5;
    int type_6 =6;
    private String ranktext[]={"短篇","名著","文学"};
    private int[] bookImage = {R.mipmap.shenmu,R.mipmap.badao};
    private String str2[] = {"男生最喜欢","女生的最爱"};
    private String str3[] = {"我的极品姐姐","夜幕降临"};
    private String str4[] = {"东小北","琪安"};
    private String str5[] = {"风情迷人的张小玉在地铁上被冒犯了，张鹏飞出手相救，没想到她却成为了自己的领路人，工作之余，他又和",
            "他戏虐的声音在她耳边萦绕：你值多少？，她逃不掉，闭上了眼睛"};
    private String str6[] = {"[仙侠大戏]遮天","[玄幻小说]不死不灭"};
    private String str7[] = {"[迷人言情]邪魅的那个ta","[火热都市]人在囧途"};
    private String str[] = {"完本排行榜","人气排行榜","连载排行榜","本周排行榜"};
    private String str1[] = {"就要看完本，一看到底","大家都在看","养眼的爆款好书","所有人心里最好的"};
    private int image[]={R.mipmap.paihang,R.mipmap.ic_launcher,R.mipmap.paihang1,R.mipmap.me1};
    private Context mContext;
//    public rankActivityFragment(Context context){
//        mContext = context;
//    }
public void onAttach(Context context) {
    super.onAttach(context);
    mContext = context;
}
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View headview = LayoutInflater.from(mContext).inflate(R.layout.rankhead_layout,null);
        GridView gv3 = (GridView)headview.findViewById(R.id.gridview);

        gv3.setAdapter(new ImageAdapter(mContext,type_4,str,str1,str2,str3,image));
//
        View view = LayoutInflater.from(mContext).inflate(R.layout.adapter_list,null);
        ListView lv1 = (ListView)view.findViewById(R.id.adapter_list);
//        //ListView lv2 = (ListView)view.findViewById(R.id.list2);
        lv1.addHeaderView(headview);
        View view1 = rankBottom();
        lv1.addFooterView(view1);
        lv1.setAdapter(new ImageAdapter(mContext,type_5,str2,str3,str4,str5,str6,str7,bookImage));

        return view;
    }

    public View rankBottom(){
        View view = LayoutInflater.from(mContext).inflate(R.layout.rankbottom_layout,null);
        GridView gv = (GridView)view.findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(mContext,type_6,ranktext));
        return view;
    }

}
