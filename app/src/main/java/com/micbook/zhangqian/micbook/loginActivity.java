package com.micbook.zhangqian.micbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.message.BasicNameValuePair;

import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;
import cn.smssdk.SMSSDK;
import rx.Subscription;

import static android.content.ContentValues.TAG;


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
    private String userphone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
        Bmob.initialize(this,"d802af268d5d46906f090f25f09eaf83","Bmob");
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
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        //_data={"mobile":"18080442866","loginType":4,"pwd":"111111"}
//                        String paramUserPwd = "{\"mobile\":\"";
//                        String paramLoginType="\",\"loginType\":4,\"pwd\":\"";
//                        String param1 = "\"}";
//                        String param = paramUserPwd+userphone+paramLoginType+userpwd+param1;
//                        Log.d("param参数",param);
//                        String ipmlogin = "http://daily.bookln.cn:8082/userservice/login.do?";
//                        List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
//                        params.add(new BasicNameValuePair("_data","param"));
//                        String a1 =new postJson(params).getJson(ipmlogin);
//                        Looper.prepare();
//                       // Toast.makeText(loginActivity.this,a1,Toast.LENGTH_LONG).show();
//                        Looper.loop();
//                        Log.d("json日志",a1);
//                    }
//                }).start();
                Intent intent2 =new Intent(loginActivity.this,MainActivity.class);
                startActivity(intent2);
//                if(verifyPhone()) {
//                    if (userpwd.isEmpty()) {
//                        Toast.makeText(this, "还没有输入密码喔~", Toast.LENGTH_LONG).show();
//                    } else if (userpwd.length() < 6) {
//                        Toast.makeText(this, "密码小于6位，请重新输入", Toast.LENGTH_LONG).show();
//                    } else {
//                        isRegister(userphone,userpwd);
//                    }
//                }
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
    public boolean verifyPhone(){
        userphone = userPhone.getText().toString();
        if(userphone.isEmpty()){
            Toast.makeText(this,"还没有输入手机号喔~",Toast.LENGTH_LONG).show();
            return false;
        }else if(userphone.length()!=11){
            Toast.makeText(this,"手机号码长度有误",Toast.LENGTH_LONG).show();
            return false;
        }else {
            String str = userphone.substring(0, 2);
            if (!str.equals("13") && !str.equals("15")
                    && !str.equals("17") && !str.equals("18")) {
                Toast.makeText(this, "您输入的不是手机号", Toast.LENGTH_LONG).show();
                return false;
            } else {
                return true;
            }
        }
    }
        public void isRegister (final String name, String pwd){
             BmobQuery<User> query1 = new BmobQuery<User>();
             query1.addWhereEqualTo("userName",name);
             BmobQuery<User> query2 = new BmobQuery<User>();
             query2.addWhereEqualTo("userPwd",pwd);
             List<BmobQuery<User>> queries = new ArrayList<BmobQuery<User>>();
             queries.add(query1);
             queries.add(query2);
             BmobQuery<User> mainQuery = new BmobQuery<User>();
             mainQuery.and(queries);
             mainQuery.findObjects(new FindListener<User>() {
                 @Override
                 public void done(List<User> list, BmobException e) {
                     if (list.size() !=0) {
                       Intent intent =new Intent(loginActivity.this,MainActivity.class);
                         startActivity(intent);
                     } else {
                         verifyUserInfo(name);
                     }
                 }
             });


    }
    public void verifyUserInfo (String name){
        final BmobQuery<User> query = new BmobQuery<User>("User");
        query.addWhereEqualTo("userName",name);
        query.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (list.size() != 0) {
                    Toast.makeText(loginActivity.this, "账号或密码错误", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(loginActivity.this, "号码未注册", Toast.LENGTH_LONG).show();
                }
            }

        });


    }
}
