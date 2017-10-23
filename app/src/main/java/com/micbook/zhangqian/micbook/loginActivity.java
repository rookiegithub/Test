package com.micbook.zhangqian.micbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.os.Looper;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;

import java.util.LinkedList;
import java.util.List;


/**
 * Created by zhangqian on 2017/9/28.
 */

public class loginActivity extends banScreenActivity implements View.OnClickListener{

    private EditText pwd;
    private ImageView close;
    private TextView skip_register;
    private Button btnpass;
    private EditText userPhone;
    private TextView line;
    private TextView line1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        init();

    }
    public void init() {
        pwd = (EditText) findViewById(R.id.editText);
        close = (ImageView) findViewById(R.id.imageView);
        skip_register = (TextView) findViewById(R.id.skip_register);
        btnpass = (Button) findViewById(R.id.button);
        userPhone = (EditText) findViewById(R.id.userPhone);
        line = (TextView) findViewById(R.id.line);
        line1 = (TextView) findViewById(R.id.line1);

        pwd.setOnClickListener(this);
        close.setOnClickListener(this);
        skip_register.setOnClickListener(this);
        btnpass.setOnClickListener(this);

        userPhone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            line.setBackgroundColor(Color.parseColor("#3ca6fe"));
        } else {
            line.setBackgroundColor(Color.parseColor("#CCCCCC"));
        }
          }
         });
        pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
@Override
         public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus){
            line1.setBackgroundColor(Color.parseColor("#3ca6fe"));
        }else{
            line1.setBackgroundColor(Color.parseColor("#CCCCCC"));
        }
        }
        });
    }
    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.button:
                final String userpwd = pwd.getText().toString();
                final String userphone=userPhone.getText().toString();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //_data={"mobile":"18080442866","loginType":4,"pwd":"111111"}
                        String paramUserPwd = "{\"mobile\":\"";
                        String paramLoginType="\",\"loginType\":4,\"pwd\":\"";
                        String param1 = "\"}";
                        String param = paramUserPwd+userphone+paramLoginType+userpwd+param1;
                        Log.d("param参数",param);
                        String ipmlogin = "http://daily.bookln.cn:8082/userservice/login.do?";
                        List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
                        params.add(new BasicNameValuePair("_data","param"));
                        String a1 =new postJson(params).getJson(ipmlogin);
                        Looper.prepare();
                        Toast.makeText(loginActivity.this,a1,Toast.LENGTH_LONG).show();
                        Looper.loop();
                        Log.d("json日志",a1);
                    }
                }).start();
                Intent intent2 = new Intent(loginActivity.this,MainActivity.class);
                startActivity(intent2);

                //Log.i("a",a);
                break;
            case R.id.imageView:
                Intent intent = new Intent(loginActivity.this,FirstPageActivity.class);
                startActivity(intent);
                break;
            case R.id.skip_register:
                Intent intent1 = new Intent(loginActivity.this,registerActivity.class);
                startActivity(intent1);
                break;
        }
    }
}
