package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.mob.tools.gui.ScrollableListView;

/**
 * Created by zhangqian on 2017/11/24.
 */

public class micBookOnScrollView extends ScrollView {
    private ScrollableListView scrollableListView;
    public micBookOnScrollView(Context context) {
        super(context);
    }

    public micBookOnScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public micBookOnScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

//    public micBookOnScrollView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleAttr, defStyleRes);
//
//    }
    public interface ScrollViewListener{
    void onScrollChanged();
}

//    public void onScrollChanged(int x,int y, int oldx,int oldy){
//        super.onScrollChanged(x,y,oldx,oldy);
//        if(scrollableListView != null){
//            scrollableListView.setOnScrollListener();
//        }
//    }

}
