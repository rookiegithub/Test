package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

/**
 * Created by zhangqian on 2017/10/17.
 */

public class viewPageAdapter extends PagerAdapter {
    private GridView gv =null;
    private GridView gv1=null;
    private ListView lv = null;
    private ImageAdapter imageAdapter =null;
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
    private String[] book_name = {
            "神墓", "黑衣舰队",
            "夜幕降临", "霸道总裁", "梦醒十分",
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
    private String[] book_names = {
            "神墓", "黑衣舰队",
            "夜幕降临", "霸道总裁", "梦醒十分"
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
    private int[] maxImage = {R.mipmap.maximage};
    private String[] maxImage_title = {"异兽化形，羽翼横空，屠戮诸天万界！"};
    private String[] MaxImage_info = {"穿越异界变成一只异兽，努力修炼化形，争取早日羽翼横空，遮天蔽日，那些不服的，统统干掉。"};
    private int maxImage1 = R.mipmap.maximage;
    private String maxImage_title1 = "异兽化形，羽翼横空，屠戮诸天万界！";
    private String MaxImage_info1 = "穿越异界变成一只异兽，努力修炼化形，争取早日羽翼横空，遮天蔽日，那些不服的，统统干掉。";

    private String str[] = {"完本排行榜","人气排行榜","连载排行榜","本周排行榜"};
    private String str1[] = {"就要看完本，一看到底","大家都在看","养眼的爆款好书","所有人心里最好的"};
    private int image[]={R.mipmap.paihang,R.mipmap.ic_launcher,R.mipmap.paihang1,R.mipmap.me1};
//    String str1[] = {"就要看完本，一看到底","大家都在看"};
//    String str1[] = {"就要看完本，一看到底","大家都在看"};
    private String str2[] = {"男生最喜欢","女生的最爱"};
    private String str3[] = {"我的极品姐姐","夜幕降临"};
    private String str4[] = {"东小北","琪安"};
    private String str5[] = {"风情迷人的张小玉在地铁上被冒犯了，张鹏飞出手相救，没想到她却成为了自己的领路人，工作之余，他又和",
    "他戏虐的声音在她耳边萦绕：你值多少？，她逃不掉，闭上了眼睛"};
    private String str6[] = {"[仙侠大戏]遮天","[玄幻小说]不死不灭"};
    private String str7[] = {"[迷人言情]邪魅的那个ta","[火热都市]人在囧途"};
    private int[] bookImage = {R.mipmap.shenmu,R.mipmap.badao};
    private String ranktext[]={"短篇","名著","文学"};
    private String catehead[]={"男生","女生","漫画","出版"};
    private String catetag_boy[]={"太古王者","一路狂霸","万千位面","燃血兵王"};
    private String catetag_girl[]={"毒医","扮猪吃虎","宝宝","爆笑"};
    private String catetag_chuban[]={"成功励志","青春美女","悬疑社区","影视原著"};
    private String catetag_manhua[]={"穿越","宫廷","惊悚","古墓"};
    private int[] cateimage={R.mipmap.taigu, R.mipmap.yilu,R.mipmap.wanqian,R.mipmap.ranxue};

    private List<String[]> catalogStr = Arrays.asList(catetag_boy,catetag_girl,catetag_chuban,catetag_manhua);

    private int type_2=2;
    private int type_1 =1;
    private int type_4 = 4;
    private int type_5=5;
    private int type_6=6;
    private int type_7=7;
    private int type_8=8;
    private Context context;
    public  viewPageAdapter(Context context){
        this.context = context;
}


    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    public Object instantiateItem(ViewGroup container, int position){
        View view ;
        if(position==0){

            View banerView = LayoutInflater.from(context).inflate(R.layout.mz_mode_not_cover,null);
            new bannerInit().initView(banerView, context);
            GridView gv1 = (GridView) banerView.findViewById(R.id.bookCitygridview);
            gv1.setAdapter(new ImageAdapter(context, cate_names, cate_images, type_2));

            View renqiGridView = LayoutInflater.from(context).inflate(R.layout.activity_bookcity_bottom, null);
            GridView gv2 = (GridView) renqiGridView.findViewById(R.id.renqigridview);
            gv2.setSelector(new ColorDrawable(Color.TRANSPARENT));//点击GridView时出现背景色，可以给gridview设置setSelector背景色为透明色
            gv2.setAdapter(new ImageAdapter(context, book_names, book_image, type_1));

            view = LayoutInflater.from(context).inflate(R.layout.adapter_list,null);
            ListView listView = (ListView) view.findViewById(R.id.adapter_list);
            listView.addHeaderView(banerView);
            listView.addFooterView(initmaxImage());
            listView.addFooterView(renqiGridView);

            View qualityView = isBook_add(book_infos, book_name, book_images, book_authors);
            listView.addFooterView(qualityView);//精品推荐
            listView.setAdapter(new listviewAdapter(context, book_info, book_names, book_image, book_author));
//            micBookListView.setListViewHeightBasedOnChildren(listView);
        }else if(position==1){
            View headview = LayoutInflater.from(context).inflate(R.layout.rankhead_layout,null);
            GridView gv3 = (GridView)headview.findViewById(R.id.gridview);
            gv3.setAdapter(new ImageAdapter(context,type_4,str,str1,str2,str3,image));

            view = LayoutInflater.from(context).inflate(R.layout.adapter_list,null);
              ListView lv1 = (ListView)view.findViewById(R.id.adapter_list);
              //ListView lv2 = (ListView)view.findViewById(R.id.list2);
            lv1.addHeaderView(headview);
            View view1 = rankBottom();
            lv1.addFooterView(view1);
            lv1.setAdapter(new ImageAdapter(context,type_5,str2,str3,str4,str5,str6,str7,bookImage));

//             lv2.setAdapter(new ImageAdapter(context,type_4,str2,str3));

//            GridView gv1 = (GridView) view.findViewById(R.id.gridview);
//            gv1.setAdapter(new ImageAdapter(context, type_4, str2, str3));
        }else {

            view = LayoutInflater.from(context).inflate(R.layout.bookcity_catelayout,null);
            lv = (ListView)view.findViewById(R.id.lv);
            gv = (GridView)view.findViewById(R.id.gv);
            gv.setSelector(new ColorDrawable(Color.TRANSPARENT));

            gv1 = (GridView)view.findViewById(R.id.gv1);
            final ImageAdapter gvAdapter = new ImageAdapter(context, catetag_boy, cateimage, type_7);
            gv.setAdapter(gvAdapter);
            final ImageAdapter gvOneAdapter = new ImageAdapter(context, cate_names, cate_images, type_2);
            gv1.setAdapter(gvOneAdapter);
            imageAdapter = new ImageAdapter(context, type_8, catehead);
            lv.setAdapter(imageAdapter);
            lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    imageAdapter.setSelectionPosition(position);
                    imageAdapter.notifyDataSetInvalidated();
                    gvAdapter.render(catalogStr.get(position),cateimage,7);
                    gv.setAdapter(gvAdapter);
                    gvOneAdapter.render(cate_names,cate_images,2);
                    gv1.setAdapter(gvOneAdapter);
//                    switch (position){
//                        case 0:
//                            gv.setAdapter(new ImageAdapter(context, catetag_boy, cateimage, type_7));
//                            gv1.setAdapter(new ImageAdapter(context, cate_names, cate_images, type_2));
//                            break;
//                        case 1:
//                            gv.setAdapter(new ImageAdapter(context, catetag_girl, cateimage, type_7));
//                            gv1.setAdapter(new ImageAdapter(context, cate_names, cate_images, type_2));
//                            break;
//                        case 2:
//                            gv.setAdapter(new ImageAdapter(context, catetag_manhua, cateimage, type_7));
//                            gv1.setAdapter(new ImageAdapter(context, cate_names, cate_images, type_2));
//                            break;
//                        case 3:
//                            gv.setAdapter(new ImageAdapter(context, catetag_chuban, cateimage, type_7));
//                            gv1.setAdapter(new ImageAdapter(context, cate_names, cate_images, type_2));
//                            break;
//
//                    }
                }
            });
        }
        container.addView(view);
        return view;
    }

    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    public View initmaxImage() {
        View view = LayoutInflater.from(context).inflate(R.layout.maximage_layout, null);
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
        view = LayoutInflater.from(context).inflate(R.layout.adapter_list, null);
        ListView listView = (ListView) view.findViewById(R.id.adapter_list);
        listView.setAdapter(new listviewAdapter(context, book_infos, book_name, book_images, book_authors,MaxImage_info,maxImage_title,maxImage));
        micBookListView.setListViewHeightBasedOnChildren(listView);
        return view;
    }
    public View rankBottom(){
        View view = LayoutInflater.from(context).inflate(R.layout.rankbottom_layout,null);
        GridView gv = (GridView)view.findViewById(R.id.gridview);
        gv.setAdapter(new ImageAdapter(context,type_6,ranktext));
        return view;
    }
}
