package com.micbook.zhangqian.micbook;

import android.util.Log;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by zhangqian on 2017/9/30.
 */

public class postJson {
    //String path = "";

    List params;

    public postJson(List params){
           this.params = params;
    }

    public  String getJson(String path){
        //String a = "http://prepub.bookln.cn/comm/appservice/newtop5bychannel.do?_data={\"channel\":\"yttest\"}";
        //String a = "http://daily.bookln.cn:8082/comm/appservice/newtop5bychannel.do?";
        String json = null;

        HttpClient client = new DefaultHttpClient();
        Log.i("这是路径",path);
            HttpPost httppost = new HttpPost(path);


        try {
            httppost.setEntity(new UrlEncodedFormEntity(params,"UTF-8"));
            HttpResponse httpResponse = client.execute(httppost);
                 HttpEntity entity = httpResponse.getEntity();
                  json = EntityUtils.toString(entity);
            Log.i("这是json路径",json);
                  } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return json;
    }

}
