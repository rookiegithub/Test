package com.micbook.zhangqian.micbook;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import org.json.JSONObject;
import java.util.List;
import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;

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
    EventHandler eventHandler;
    String input_phone;
    String input_pwd;
    String input_verify;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        initSmssSDK();
        Bmob.initialize(this,"d802af268d5d46906f090f25f09eaf83","Bmob");
    }

    public  void initView(){
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
            case R.id.send_verify:
                if(verifyPhone()){
                   // String IMPverify = "http://daily.bookln.cn:8082/systemsevice/smssend/len4.do";
//                            String a = "http://prepub.bookln.cn/comm/appservice/newtop5bychannel.do?";
//                            List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
//                            params.add(new BasicNameValuePair("_data","{\"channel\":\"customtest\"}"));
//                    new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                           // String str = "_data={\"mobile\":\"18080442867\",\"useType\":7}";
//                            String str1 = "http://daily.bookln.cn:8082/comm/systemsevice/smssend.do";
//                           // String a = "http://prepub.bookln.cn:8082/comm/systemsevice/smssend/len4.do?";
////                            String a = "http://prepub.bookln.cn/comm/appservice/newtop5bychannel.do?";
//                            final List<BasicNameValuePair> params = new LinkedList<BasicNameValuePair>();
//
//                            params.add(new BasicNameValuePair("_data","{\"channel\":\"yttest\"}"));
////                            params.add(new BasicNameValuePair("_data","{\"mobile\":\"18080442867\",\"useType\":7}"));
//                            //params.add(new BasicNameValuePair("mobile","18080442867"));
//
//                            String a1 =new postJson(params).getJson(str1);
//                            Log.d("json日志",a1);
////                            new analysisJson().json(a1);
//
//                        }
//                    }).start();
                    isRegister(input_phone);
                }
                    break;
            case R.id.button:
                if(verifyPhone()){
                    input_pwd = pwd.getText().toString();
                    input_verify = verfiy.getText().toString();
                    if(input_verify.isEmpty()){
                        Toast.makeText(this,"还没有输入验证码喔~",Toast.LENGTH_LONG).show();
                    }else if(input_pwd.isEmpty()){
                        Toast.makeText(this,"还没有输入密码喔~",Toast.LENGTH_LONG).show();
                    }else if(input_pwd.length()<6){
                        Toast.makeText(this,"密码小于6位，请重新输入",Toast.LENGTH_LONG).show();
                    }else{
                        SMSSDK.submitVerificationCode("86",input_phone,input_verify);
                    }
                }
                break;
            case R.id.skip_login:
                Intent intent = new Intent(registerActivity.this,loginActivity.class);
                startActivity(intent);
                break;
            case R.id.imageView:
                Intent intent1 = new Intent(registerActivity.this,FirstPageActivity.class);
                startActivity(intent1);
                break;
           }
        }

    public boolean verifyPhone(){
        input_phone = phone.getText().toString();
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
    public void initSmssSDK() {
        eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                Message msg = new Message();
                msg.arg1 = event;
                msg.arg2 = result;
                msg.obj = data;
               mHandler.sendMessage(msg);
            }
        };
              SMSSDK.registerEventHandler(eventHandler);
    }

    Handler mHandler =new Handler() {
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int event = msg.arg1;
            int result = msg.arg2;
            Object data = msg.obj;
            if (result == SMSSDK.RESULT_COMPLETE) {
                //短信注册成功后，返回MainActivity,然后提示新好友
                if (event == SMSSDK.EVENT_SUBMIT_VERIFICATION_CODE) {//提交验证码成功
                    user_register(input_phone, input_pwd);
                } else if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                    Toast.makeText(getApplicationContext(), "验证码已发送", Toast.LENGTH_SHORT).show();
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

                }
            } else {
                int status = 0;
                try {
                    ((Throwable) data).printStackTrace();
                    Throwable throwable = (Throwable) data;
                    JSONObject object = new JSONObject(throwable.getMessage());
                    String des = object.optString("detail");
                    if(des.contains("错误")){
                        des = "验证码错误";
                    }
                    status = object.optInt("status");
                    if (!TextUtils.isEmpty(des)) {
                        Toast.makeText(getApplicationContext(), des, Toast.LENGTH_SHORT).show();
                        return;
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }

    };
    protected void onDestroy() {
        super.onDestroy();
        SMSSDK.unregisterAllEventHandler();
    }
    public void user_register(String name,String password){
        User user = new User();
        user.setName(name);
        user.setPassword(password);
        user.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e == null){
                    Toast.makeText(getApplicationContext(),"注册成功",Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(),"添加数据成功，返回ObjectId"+s,Toast.LENGTH_LONG).show();
                    Intent intent2 = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent2);
                }else {
                    Toast.makeText(getApplicationContext(),"注册失败，请稍后重试",Toast.LENGTH_LONG).show();
                    //Toast.makeText(getApplicationContext(),"添加数据失败，返回ObjectId"+e.getMessage(),Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        });
    }
    public void isRegister (String name){
        final BmobQuery<User> query = new BmobQuery<User>("User");
       query.addWhereEqualTo("userName",input_phone);
        query.findObjects(new FindListener<User>() {
            @Override
            public void done(List<User> list, BmobException e) {
                if (list.size() != 0) {
                        Toast.makeText(registerActivity.this, "该号码已注册", Toast.LENGTH_LONG).show();
                } else {
                    SMSSDK.getVerificationCode("86",input_phone);
                }
            }

            });


    }
}
