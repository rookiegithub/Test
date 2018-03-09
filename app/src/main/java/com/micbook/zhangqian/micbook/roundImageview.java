package com.micbook.zhangqian.micbook;


import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;


/**
 * Created by zhangqian on 2018/2/9.
 */

public class roundImageview extends ImageView {

    private Paint mPaint;//设置画笔
    private Bitmap mBitmap;//获取图片资源
    private int width, height;//获取控件宽高
    private int mOuterRing = 0;//设置外圈大小
    private int outerRingAlpha = 30;//设置外圈透明度
    private int color = Color.BLUE;//设置外圈颜色
    public roundImageview(Context context) {
        this(context,null);
    }

    public roundImageview(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public roundImageview(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mPaint = new Paint();
    }
    public Bitmap getBitmap(){
        return mBitmap;
    }
    public void setBitmap(Bitmap bitmap){
        this.mBitmap = bitmap;
    }
    public int getmOuterRing(){
        return mOuterRing;
    }
    public void setmOuterRing(int mOuterRing){
        this.mOuterRing = mOuterRing;
    }
    public int getColor(){
        return color;
    }
    public void setColor(int color){
        this.color = color;
    }
    public int getOuterRingAlpha(){
        return outerRingAlpha;
    }
    public void setOuterRingAlpha(int outerRingAlpha){
        this.outerRingAlpha = outerRingAlpha;
    }
    protected void onMeasure(int widthMeaureSpec,int heighttMeasureSpec){

        super.onMeasure(widthMeaureSpec,heighttMeasureSpec);//获取控件的宽高
        width = View.getDefaultSize(getMeasuredWidth(),widthMeaureSpec);
        height = View.getDefaultSize(getMeasuredHeight(),heighttMeasureSpec);

    }
    protected void onDraw(Canvas canvas){

        Drawable drawable = getDrawable();
        Bitmap bitmap;
        if(drawable != null){
            if(mBitmap != null){
                bitmap = mBitmap;
            }else {
                bitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.shenmu);
            }
            Matrix matrix = new Matrix();
            if(mOuterRing>0){
                if(width > height){
                    matrix.setScale((float)height / bitmap.getHeight(),(float)height/ bitmap.getHeight());
                }else {
                    matrix.setScale((float)width / bitmap.getWidth(),(float)width / bitmap.getWidth());
                }
            }else {
                if(width > height){
                    matrix.setScale((float)width / bitmap.getHeight(),(float)width/ bitmap.getHeight());
                }else {
                    matrix.setScale((float)height / bitmap.getWidth(),(float)height / bitmap.getWidth());
                }
            }
            bitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),matrix,true);
            bitmap = toRoundBitmap(bitmap);
            if(mOuterRing+bitmap.getWidth()>width){
                mOuterRing = (width-bitmap.getWidth())/2;
            }
            Paint cPaint = new Paint();
            cPaint.setStrokeWidth(2);
            cPaint.setColor(color);
            cPaint.setAlpha(outerRingAlpha);
            cPaint.setAntiAlias(true);
            canvas.drawBitmap(bitmap,mOuterRing,mOuterRing,mPaint);//绘制图片
        }else {
            super.onDraw(canvas);
        }
    }

    private Bitmap toRoundBitmap(Bitmap bitmap) {

        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float roundPx;
        float left,top,right,bottom = 0,dst_left,dst_top,dst_right,dst_bottom;
        if(width <= height){
            roundPx = width / 2;
            top = 0;
            bottom = width;
            left = 0;
            right = width;
            height = width;
            dst_left = 0;
            dst_top = 0;
            dst_right = width;
            dst_bottom = width;
        }else {
            roundPx = height / 2;
            float clip = (width - height) / 2;
            left = clip;
            right = width - clip;
            top = 0;
            right = height;
            height = height;
            dst_left = 0;
            dst_top = 0;
            dst_right = height;
            dst_bottom = height;
        }
        Bitmap output = Bitmap.createBitmap(width,height,Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        int color = 0xff424242;
        Paint paint = new Paint();
        Rect src = new Rect((int)left,(int)top,(int)right,(int)bottom);
        Rect dst = new Rect((int)dst_left,(int)dst_top,(int)dst_right,(int)dst_bottom);
        RectF rectF = new RectF(dst_left,dst_top,dst_right,dst_bottom);

        paint.setAntiAlias(true);//反混淆？
        canvas.drawARGB(0,0,0,0);//帆布，桌面，背景
        paint.setColor(color);
        canvas.drawRoundRect(rectF,roundPx,roundPx,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap,src,dst,paint);
        return output;
    }
}
