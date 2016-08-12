package org.example.xinda_05.util.SQLUtil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by Jerry Mouse on 2016/8/12.
 */
public class locationSQL {

    private SQLiteDatabase sd;

    public locationSQL(Context context) {
        SQLHelper helper=new SQLHelper(context);
        sd = helper.getReadableDatabase();
    }

    //添加本地草稿
    public void addInfo(String merchant_name,String opening_time,String closing_time,String per_capita_consumption,
                        String measure_unit,String business_location,String people,String phone,String image_url){
        String sql="insert into location (merchant_name) values ? ,(opening_time) values ? " +
                ",(closing_time) values ? ,(per_capita_consumption) values ? ,(measure_unit) values ? " +
                ",(business_location) values ? ,(people) values ? ,(phone) values ? ，(image_url) values ? ";
        sd.execSQL(sql,new String[]{merchant_name,opening_time,closing_time,per_capita_consumption,
                measure_unit,business_location,people,phone,image_url});
    }

    //点击草稿列表子项加载名字的重载
    public String getMerchant_name(String merchant_name){
        String name=null;
        String sql="select merchant_name from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{merchant_name});
        name=cu.getString(0);
        return name;
    }

    //查询单个的店铺开门时间
    public String getOpening_time(String opening_time){
        String name=null;
        String sql="select opening_time from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{opening_time});
        name=cu.getString(0);
        return name;
    }

    //查询单个的店铺关门时间
    public String getClosing_time(String closing_time){
        String name=null;
        String sql="select closing_time from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{closing_time});
        name=cu.getString(0);
        return name;
    }

    //查询单个的店铺人均消费
    public String getPr_capita_consumption(String per_capita_consumption){
        String name=null;
        String sql="select per_capita_consumption from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{per_capita_consumption});
        name=cu.getString(0);
        return name;
    }

    //查询单个的店铺计量单位
    public String getMeasure_unit(String measure_unit){
        String name=null;
        String sql="select measure_unit from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{measure_unit});
        name=cu.getString(0);
        return name;
    }

    //查询单个的店铺地址
    public String getBusiness_location(String business_location){
        String name=null;
        String sql="select business_location from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{business_location});
        name=cu.getString(0);
        return name;
    }

    //查询单个的联系人
    public String getPeople(String people){
        String name=null;
        String sql="select people from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{people});
        name=cu.getString(0);
        return name;
    }

    //查询单个的联系人
    public String getPhone(String phone){
        String name=null;
        String sql="select phone from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{phone});
        name=cu.getString(0);
        return name;
    }

    //查询单个的联系人
    public String getImage_url(String image_url){
        String name=null;
        String sql="select image_url from location where merchant_name = ?";
        Cursor cu=sd.rawQuery(sql,new String[]{image_url});
        name=cu.getString(0);
        return name;
    }

    //查询草稿列表的所有名称
    public ArrayList<String> getMerchant_name(){
        ArrayList<String> name=null;
        String sql="select merchant_name from location";
        Cursor cu=sd.rawQuery(sql,null);
        while(cu.moveToNext()){
            name.add(cu.getString(0));
        }
        return name;
    }

    //查询草稿列表的所有地址
    public ArrayList<String> getBusiness_location(){
        ArrayList<String> name=null;
        String sql="select business_location from location";
        Cursor cu=sd.rawQuery(sql,null);
        while(cu.moveToNext()){
            name.add(cu.getString(0));
        }
        return name;
    }

    //查询草稿列表的所有价格
    public ArrayList<String> getPer_capita_consumption(){
        ArrayList<String> name=null;
        String sql="select per_capita_consumption from location";
        Cursor cu=sd.rawQuery(sql,null);
        while(cu.moveToNext()){
            name.add(cu.getString(0));
        }
        return name;
    }

    //查询草稿列表的所有图片
    public ArrayList<String> getImage_url(){
        ArrayList<String> name=null;
        String sql="select image_url from location";
        Cursor cu=sd.rawQuery(sql,null);
        while(cu.moveToNext()){
            name.add(cu.getString(0));
        }
        return name;
    }

}
