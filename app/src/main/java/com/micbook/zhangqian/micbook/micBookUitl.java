package com.micbook.zhangqian.micbook;


import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import static cn.bmob.v3.Bmob.getApplicationContext;

/**
 * Created by zhangqian on 2017/10/16.
 */

public class micBookUitl  {

    public static void toastShow(Context context,String text){
        Toast mToast = null;
        if (!TextUtils.isEmpty(text)) {
            if (mToast == null) {
                mToast = Toast.makeText(context, text,
                        Toast.LENGTH_SHORT);
            } else {
                mToast.setText(text);
            }
            mToast.show();
        }

    }

}
