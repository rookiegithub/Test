package com.micbook.zhangqian.micbook;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by zhangqian on 2018/2/23.
 */

public class spaceItemDecoration extends RecyclerView.ItemDecoration {

    private int top;
    private int bottom;
    private int left;
    private int right;
    public spaceItemDecoration(int top,int bottom,int left,int right){
        this.top = top;
        this.bottom = bottom;
        this.left = left;
        this.right = right;
    }

    public void getItemOffsets(Rect outRect, View view,RecyclerView parent,RecyclerView.State state){
        outRect.top = top;
        outRect.bottom = bottom;
        outRect.left = left;
        outRect.right = right;
    }

}
