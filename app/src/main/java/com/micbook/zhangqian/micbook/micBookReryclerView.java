package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangqian on 2018/2/10.
 */

public class micBookReryclerView extends RecyclerView.Adapter<micBookReryclerView.ViewHolder> {
    private  Context mContext;
    String [] str;
    int [] images;
    int type;
    private List<Integer> mDatas;
    private ArrayList<String> mDatas1;
    private LayoutInflater inflater;
    static class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageView;
        TextView textView;
        View view;

        public ViewHolder(View itemView) {
            super(itemView);
            //imageView = (ImageView)itemView.findViewById(R.id.)
        }
    }
//    public micBookReryclerView(Context context, String[] str, int[] images, int type) {
//        mContext = context;
//        this.str = str;
//        this.images = images;
//        this.type = type;
//    }
//    public void  updateData(ArrayList<String> data1){
//        this.mDatas1 = data1;
//        notifyDataSetChanged();
//    }
public micBookReryclerView(List<Integer> mDatas,ArrayList<String> mData1) {
    this.mDatas = mDatas;
    this.mDatas1 = mData1;
//    this.str = str;
//    this.images = images;
//    this.type = type;
}
    @Override
    public micBookReryclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        //View view = inflater.inflate(R.layout.adapter_booklayout,parent,false);
        View view = inflater.from(parent.getContext()).inflate(R.layout.adapter_booklayout,null);
        ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.imageView = (ImageView)view.findViewById(R.id.adapter_image1);
        viewHolder.textView = (TextView)view.findViewById(R.id.adapter_text1);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(micBookReryclerView.ViewHolder holder, int position) {

        holder.imageView.setImageResource(mDatas.get(position));
        holder.textView.setText(mDatas1.get(position));

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
