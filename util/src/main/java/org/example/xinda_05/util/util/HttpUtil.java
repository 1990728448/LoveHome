package org.example.xinda_05.util.util;

import android.util.Log;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class HttpUtil {

    private static HttpUtil instance;
    private AsyncHttpClient client;

    private HttpUtil() {
        client=new AsyncHttpClient();
        client.setTimeout(5000);
    }

    public static HttpUtil getURLData(){
        if(instance==null){
            instance=new HttpUtil();
        }
        return instance;
    }

    public void getItem(JsonHttpResponseHandler handler){
        try{
            String Url=URL.MENU_INFO;
            client.get(Url,handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getAllStoreInfo(JsonHttpResponseHandler handler){
        try{
            String Url=URL.ALL_StoreInfo;
            client.get(Url,handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void getCode(JsonHttpResponseHandler handler, String number){
        try{
            String Url=URL.getCode(number);
            Log.e("TAG","获取验证码:"+Url);
            client.setTimeout(10000);
            client.get(Url,handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void enterCode(JsonHttpResponseHandler handler,String code){
        try{
            String Url=URL.checkCode(code);
            Log.e("TAG","验证码:"+Url);
            client.setTimeout(10000);
            client.get(Url,handler);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void registerUser(JsonHttpResponseHandler handler,String phone,String pwd,String code){
        try{
            String Url=URL.registerUser(phone,pwd,code);
            Log.e("TAG","注册状态:"+Url);
            client.get(Url,handler);
            client.setTimeout(10000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
