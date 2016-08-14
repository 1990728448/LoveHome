package org.example.xinda_05.util.util;

import java.net.HttpURLConnection;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class URL {


    //全局的请求网址头
    public static String BASE_URL="http://123.206.87.139/LoveHomeTownServer";

    //获取城市名称
    public static String CITY_INFO=BASE_URL+"/printCity";

    //获取分类信息，适用于在首页的item以及发布中的item和popwindow
    public static String MENU_INFO=BASE_URL+"/printCategory";

    //获取网络商铺所有信息
    public static String ALL_StoreInfo=BASE_URL+"/detailInfo?is_approve=1";

    //获取网络商铺审核状态信息
    public static String getIdStoreURL(int ID){
        String url=null;
        url=BASE_URL+"/detailInfo?user_id="+ID+"?is_approve=1";
        return url;
    }


    //获取验证码
    public static String getCode(String number){
        String url=BASE_URL+"/scanCode?phone="+number;
        return url;
    }

    //注册接口
    public static String registerUser(String phone,String pwd,String code){
        String url=BASE_URL+"/registerUser?phone="+phone+"?pwd="+pwd+"?code="+code;
        return url;
    }

    //验证验证码
    public static String checkCode(String code){
        String url=BASE_URL+"/checkCode?code="+code;
        return url;
    }


    public URL(String s) {
    }

    public HttpURLConnection openConnection() {
        return null;
    }


    //

}
