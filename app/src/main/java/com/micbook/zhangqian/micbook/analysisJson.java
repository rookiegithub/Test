package com.micbook.zhangqian.micbook;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by zhangqian on 2017/9/30.
 */

public class analysisJson {



    public String json(String json)  {
        Log.d("json验证",json);
        //int id=0;
        //String jsonstr="";
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(json);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            //JSONArray jsonArray = JSONArray();
            for (int i =0;i<jsonArray.length();i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                //analysisJson a = new analysisJson();
                //obj.getInt("id");
                int id= obj.getInt("id");
                String url = obj.getString("url");

                Log.d("这是id", String.valueOf(id));
                Log.d("这是url",url);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


        return json;
    }

}
