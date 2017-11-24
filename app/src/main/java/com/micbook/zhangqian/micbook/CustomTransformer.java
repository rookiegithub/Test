package com.micbook.zhangqian.micbook;

import android.graphics.pdf.PdfDocument;
import android.support.v4.view.ViewPager;
import android.view.View;

import static android.R.attr.width;

/**
 * Created by zhangqian on 2017/10/20.
 */

public class CustomTransformer implements ViewPager.PageTransformer {
    private static final float MIN_SCALE = 0.9F;
    @Override
    public void transformPage(View page, float position) {
        if(position < -1){
            page.setScaleY(MIN_SCALE);
        }else if(position<=1){
            float scale = Math.max(MIN_SCALE,1-Math.abs(position));
            page.setScaleY(scale);
//            if(position<0){
//                page.setTranslationX(width * (1-scale) /2);
//            }else{
//                page.setTranslationX(-width * (1-scale) /2);
//            }
        }else{
            page.setScaleY(MIN_SCALE);
        }
    }
}
