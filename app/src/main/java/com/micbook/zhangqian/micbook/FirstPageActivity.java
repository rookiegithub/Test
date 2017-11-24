package com.micbook.zhangqian.micbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class FirstPageActivity extends banScreenActivity implements View.OnClickListener{

    private TextView btnlogin;
    private TextView btnregister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fristpage);
        init();
    }

    public void init(){
        btnlogin = (TextView)findViewById(R.id.login);
        btnregister = (TextView)findViewById(R.id.register);

        btnlogin.setOnClickListener(this);
        btnregister.setOnClickListener(this);
    }
    public void onClick(View v){
        switch (v.getId()){
            case R.id.login:
                Intent intent = new Intent(FirstPageActivity.this,loginActivity.class);
                startActivity(intent);
                break;
            case R.id.register:
                Intent intent1 = new Intent(FirstPageActivity.this,registerActivity.class);
                startActivity(intent1);
                break;
        }
    }


}
