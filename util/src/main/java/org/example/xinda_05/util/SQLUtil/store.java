package org.example.xinda_05.util.SQLUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jerry Mouse on 2016/8/12.
 */
public class store {

    private SQLiteDatabase sd;

    public store(Context context) {
        SQLHelper helper=new SQLHelper(context);
        sd=helper.getReadableDatabase();
    }

    //添加信息重载1
    public void addInfo(String merchant_name,String business_location,String people,String phone,String select){

    }

    //添加信息重载2本地草稿信息
    public void addInfo(String business_location, String opening_time ,String closing_time ,String detail_info ,String measure_unit,
                        String merchant_name ,String per_capita_consumption,String phone,String image_url ,String internet ,
                        String location ,String collect ,String people){

    }


    //添加信息重载3从网络下载信息的版本
    public void addInfo(String business_location, String opening_time ,String closing_time ,String detail_info ,String measure_unit,
                        String merchant_name ,String per_capita_consumption,String phone,String image_url ,String internet ,
                        String location ,String collect ){

    }




}
