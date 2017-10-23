package com.micbook.zhangqian.micbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
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
import java.util.concurrent.RunnableFuture;

/**
 * Created by zhangqian on 2017/9/29.
 */

public class registerActivity extends banScreenActivity implements View.OnClickListener{

    private EditText pwd;
    private EditText phone;
    private EditText verfiy;
    private ImageView close;
    private TextView skip_login;
    private TextView btnverify;
    private Button btnallow;
    private TextView line;
    private TextView line1;
    private TextView line2;
    public static String send_verify="5555";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }
    public  void init(){
        phone = (EditText)findViewById(R.id.phone);
        pwd = (EditText)findViewById(R.id.editText);
        verfiy = (EditText)findViewById(R.id.verify);
        btnverify = (TextView) findViewById(R.id.send_verify);
        skip_login = (TextView) findViewById(R.id.skip_login);
        close = (ImageView)findViewById(R.id.imageView);
        btnallow=(Button)findViewById(R.id.button);
        line = (TextView)findViewById(R.id.line);
        line1 = (TextView)findViewById(R.id.line1);
        line2 = (TextView)findViewById(R.id.line2);

        phone.setOnClickListener(this);
        pwd.setOnClickListener(this);
        verfiy.setOnClickListener(this);
        btnverify.setOnClickListener(this);
        skip_login.setOnClickListener(this);
        close.setOnClickListener(this);
        btnallow.setOnClickListener(this);
        phone.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    line.setBackgroundColor(Color.parseColor("#3ca6fe"));
                }else {
                    line.setBackgroundColor(Color.parseColor("#CCCCCC"));
                }
            }
        });
        verfiy.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    line1.setBackgroundColor(Color.parseColor("#3ca6fe"));
                }else{
                    line1.setBackgroundColor(Color.parseColor("#CCCCCC"));
                }
            }
        });
        pwd.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    line2.setBackgroundColor(Color.parseColor("#3ca6fe"));
                }else{
                    line2.setBackgroundColor(Color.parseColor("#CCCCCC"));
                }
            }
        });

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.phone:
                Toast.makeText(this,"点击了文本输入框",Toast.LENGTH_LONG).show();
                break;
            case R.id.editText:
                Toast.makeText(this,"点击了密码输入框",Toast.LENGTH_LONG).show();
                break;
            case R.id.verify:
                Toast.makeText(this,"点击了验证码输入框",Toast.LENGTH_LONG).show();
                break;
            case R.id.send_verify:
                if(verifyPhone()){
                   // String IMPverify = "http://daily.bookln.cn:8082/systemsevice/smssend/len4.do";



//                            String a = "http://prepub.bookln.cn/comm/appservice/newtop5bychannel.do?";
//                            List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
//                            params.add(new BasicNameValuePair("_data","{\"channel\":\"customtest\"}"));
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                           // String str = "_data={\"mobile\":\"18080442867\",\"useType\":7}";
                            String str1 = "http://daily.bookln.cn:8082/comm/systemsevice/smssend.do";

                           // String a = "http://prepub.bookln.cn:8082/comm/systemsevice/smssend/len4.do?";
//                            String a = "http://prepub.bookln.cn/comm/appservice/newtop5bychannel.do?";
                            final List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();

                            params.add(new BasicNameValuePair("_data","{\"channel\":\"yttest\"}"));
//                            params.add(new BasicNameValuePair("_data","{\"mobile\":\"18080442867\",\"useType\":7}"));
                            //params.add(new BasicNameValuePair("mobile","18080442867"));

                            String a1 =new postJson(params).getJson(str1);
                            Log.d("json日志",a1);
//                            new analysisJson().json(a1);

                        }
                    }).start();

                            //Looper.prepare();
                            new CountDownTimer(30000,1000) {
                                @Override
                                public void onTick(long millisUntilFinished) {
                                    btnverify.setText(millisUntilFinished/1000+" S后获取");
                                    btnverify.setTextColor(Color.parseColor("#888888"));
                                    btnverify.setEnabled(false);
                                }

                                @Override
                                public void onFinish() {
                                    btnverify.setText("获取验证码");
                                    btnverify.setTextColor(Color.parseColor("#3ca6fe"));
                                    btnverify.setEnabled(true);
                                }
                            }.start();

                    Toast.makeText(this,"验证码已发送",Toast.LENGTH_LONG).show();
                    //Looper.loop();
                }
                    break;

            case R.id.skip_login:
                Intent intent1 = new Intent(registerActivity.this,loginActivity.class);
                        startActivity(intent1);
                Toast.makeText(this,"点击了跳页，跳到登录",Toast.LENGTH_LONG).show();
                break;
            case R.id.imageView:
                Intent intent = new Intent(registerActivity.this,FirstPageActivity.class);
                        startActivity(intent);
                Toast.makeText(this,"点击了文本关闭",Toast.LENGTH_LONG).show();
                break;
            case R.id.button:
                if(verifyPhone()){
                    String input_verify = verfiy.getText().toString();
                    String input_pwd = pwd.getText().toString();
                    if(!input_verify.equals(send_verify)){
                        Toast.makeText(this,"验证码错误",Toast.LENGTH_LONG).show();
                    }else{
                        if(input_pwd.isEmpty()){
                            Toast.makeText(this,"还没有输入密码喔~",Toast.LENGTH_LONG).show();
                        }else if(input_pwd.length()<6){
                            Toast.makeText(this,"密码小于6位，请重新输入",Toast.LENGTH_LONG).show();
                        }else{
                            Toast.makeText(this,"密码正确",Toast.LENGTH_LONG).show();
                        }
                    }
                }
                break;
        }
        }

    public boolean verifyPhone(){
        String input_phone = phone.getText().toString();
        if(input_phone.isEmpty()){
            Toast.makeText(this,"还没有输入手机号喔~",Toast.LENGTH_LONG).show();
            return false;
        }else if(input_phone.length()!=11){
            Toast.makeText(this,"手机号码长度有误",Toast.LENGTH_LONG).show();
            return false;
        }else {
            String str = input_phone.substring(0, 2);
            if (!str.equals("13") && !str.equals("15")
                    && !str.equals("17") && !str.equals("18")) {
                Toast.makeText(this, "您输入的不是手机号", Toast.LENGTH_LONG).show();
                return false;
            } else {
                return true;
            }
        }
    }
}
