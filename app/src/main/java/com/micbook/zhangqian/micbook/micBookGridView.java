package com.micbook.zhangqian.micbook;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by zhangqian on 2017/10/26.
 */

public class micBookGridView extends GridView {
    public micBookGridView(Context context) {
        super(context);
    }
    public micBookGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
        // TODO Auto-generated constructor stub
    }

    public micBookGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        // TODO Auto-generated constructor stub
    }
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec){

        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE>>2,MeasureSpec.AT_MOST);
               super.onMeasure(widthMeasureSpec,expandSpec);
    }
}
