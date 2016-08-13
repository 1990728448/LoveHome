package org.example.xinda_05.util.util;

import android.util.Log;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;

/**
 * Created by Jerry Mouse on 2016/8/13.
 */
public class xUtil {

    public static void getCode(Callback.CommonCallback<String> callback,String code){
        try{
            String Url=URL.checkCode(code);
            Log.e("TAG","获取验证码:"+Url);
            RequestParams params =new RequestParams(Url);
            x.http().get(params,callback);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
