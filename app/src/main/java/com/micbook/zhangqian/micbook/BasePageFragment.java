package com.micbook.zhangqian.micbook;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BasePageFragment extends Fragment{

    private boolean isViewInitiated;
    private boolean isVisibleTouser;
    private boolean isDataInitiated;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isViewInitiated = true;
        prepareFetchData();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        this.isVisibleTouser = isVisibleToUser;
        prepareFetchData();
    }
    public abstract View fetchData();
    public boolean prepareFetchData(){
        return prepareFetchData(false);
    }
    public boolean prepareFetchData(boolean forceUpdate){
        if(isVisibleTouser && isViewInitiated && (!isDataInitiated || forceUpdate)){
             fetchData();
            isDataInitiated = true;
            return true;
        }
        return false;
    }
}