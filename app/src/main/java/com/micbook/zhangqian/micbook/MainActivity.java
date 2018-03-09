package com.micbook.zhangqian.micbook;

//import android.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.Checkable;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * Created by zhangqian on 2017/10/17.
 */

public class MainActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup rdTab;
    private RadioButton bookgrid,bookcity,message,me;
    private bookgridAcitivityFragment fg1;
    private messageAcitivityFragment fg3;
    private bookcityActivityFragment fg2;
    private meAcitivityFragment fg4;
    private long exitTime = 0;
    FragmentTransaction transaction;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(android.R.layout.ac);
        setContentView(R.layout.activity_main);
        initview();
    }

//    @Override
//    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
//
//    }

    private void initview(){
        rdTab = (RadioGroup)findViewById(R.id.radio);
        rdTab.setOnCheckedChangeListener(this);

        bookgrid = (RadioButton)findViewById(R.id.bookGrid);
        bookcity = (RadioButton)findViewById(R.id.bookCity);
        message = (RadioButton)findViewById(R.id.message);
        me = (RadioButton)findViewById(R.id.me);

        transaction = getSupportFragmentManager().beginTransaction();
        addAllFragemnt(transaction);

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

        //FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction = getSupportFragmentManager().beginTransaction();
        hideAllFragemnt(transaction);
        switch(checkedId){
            case R.id.bookGrid:
                    transaction.show(fg1);
                break;
            case R.id.bookCity:
                    transaction.show(fg2);
                break;
            case R.id.message:
                    transaction.show(fg3);
                break;
            case R.id.me:
                    transaction.show(fg4);
                break;
        }
        transaction.commit();
    }
    public void addAllFragemnt(FragmentTransaction transaction){
        if(fg1 == null){
            fg1 = new bookgridAcitivityFragment();
            transaction.add(R.id.fragment,fg1);
            //transaction.add(R.id.fragment,fg1,"frag1");
        }
        //fg2 = (bookcityActivityFragment) getSupportFragmentManager().findFragmentByTag("frag2");
        if(fg2 == null){
            fg2 = new bookcityActivityFragment();
            transaction.add(R.id.fragment,fg2);
        }
        if(fg3 == null){
            fg3 = new messageAcitivityFragment();
            transaction.add(R.id.fragment,fg3);
            //fg3 = new messageAcitivityFragment(this);
        }
        if(fg4 == null){
            fg4 = new meAcitivityFragment();
            transaction.add(R.id.fragment,fg4);
        }
        transaction.commit();
    }
    public boolean onKeyDown(int keyCode, KeyEvent event){
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){

            if(System.currentTimeMillis()-exitTime>2000){
                Toast.makeText(getApplicationContext(),"再按一次将退出应用",Toast.LENGTH_LONG).show();
                exitTime = System.currentTimeMillis();
            }else {
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);

                //System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode,event);
    }

}
