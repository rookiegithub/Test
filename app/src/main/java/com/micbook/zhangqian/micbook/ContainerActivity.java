package com.micbook.zhangqian.micbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.FrameLayout;

/**
 * Created by zhangqian on 2018/2/27.
 */

public class ContainerActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout frameLayout = new FrameLayout(this);
        frameLayout.setId(R.id.contentPanel);
        setContentView(frameLayout);

        getSupportFragmentManager().beginTransaction().add(R.id.contentPanel,new BookDetilFragment()).commitAllowingStateLoss();
    }
}
