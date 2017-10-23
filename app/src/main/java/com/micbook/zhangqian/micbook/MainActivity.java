package com.micbook.zhangqian.micbook;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * Created by zhangqian on 2017/10/17.
 */

public class MainActivity extends banScreenActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rdTab;
    private RadioButton bookgrid,bookcity,message,me;
    private bookgridAcitivityFragment fg1;
    private messageAcitivityFragment fg3;
   // private MZModeNotCoverFragment fg5;
    private bookcityActivityFragment fg2;
    private meAcitivityFragment fg4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(android.R.layout.ac);
        setContentView(R.layout.activity_main);
         initview();
    }

    private void initview(){
        rdTab = (RadioGroup)findViewById(R.id.radio);
        rdTab.setOnCheckedChangeListener(this);

        bookgrid = (RadioButton)findViewById(R.id.bookGrid);
        bookcity = (RadioButton)findViewById(R.id.bookCity);
        message = (RadioButton)findViewById(R.id.message);
        me = (RadioButton)findViewById(R.id.me);

        bookgrid.setChecked(true);
    }

    public void hideAllFragemnt(FragmentTransaction transaction){
        if(fg1 != null){
            transaction.hide(fg1);
        }
        if(fg2 != null){
            transaction.hide(fg2);
        }
        if(fg3 != null){
            transaction.hide(fg3);
        }
        if(fg4 != null){
            transaction.hide(fg4);
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {

        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        hideAllFragemnt(transaction);
        switch(checkedId){
            case R.id.bookGrid:
                if(fg1 == null){
                    fg1 = new bookgridAcitivityFragment(this);
                    transaction.add(R.id.fragment,fg1);
                }else{
                    transaction.show(fg1);
                }
                break;
            case R.id.bookCity:
                if(fg2 == null){
                    fg2 = new bookcityActivityFragment(this);
                    transaction.add(R.id.fragment,fg2);
                }else{
                    transaction.show(fg2);
                }
                break;
            case R.id.message:
                if(fg3 == null){
                    fg3 = new messageAcitivityFragment(this);
                    transaction.add(R.id.fragment,fg3);
                }else{
                    transaction.show(fg3);
                }
                break;
            case R.id.me:
                if(fg4 == null){
                    fg4 = new meAcitivityFragment(this);
                    transaction.add(R.id.fragment,fg4);
                }else{
                    transaction.show(fg4);
                }
                break;
        }
        transaction.commit();
    }
}
