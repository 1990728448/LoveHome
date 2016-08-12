package org.example.xinda_05.util.SQLUtil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 *  简化执行数据库的操作
 * Created by Jerry Mouse on 2016/8/12.
 */
public class itemSQL {

    SQLiteDatabase sd;

    public itemSQL(Context context) {
        SQLHelper helper=new SQLHelper(context);
        sd=helper.getReadableDatabase();
    }

    //添加所有子项的item名称
    public void addItemName(ArrayList<String> name){
        for (int i=0;i<name.size();i++){
            String sql="insert into item (item_name) values ?";
            sd.execSQL(sql,new String[]{name.get(i)});
        }
    }

    //查询表中所有的item名字
    public ArrayList<String> getName(){
        ArrayList<String> name=null;

        String sql="select item_name from item ";
        Cursor cu=sd.rawQuery(sql,null);
        while (cu.moveToNext()){
            name.add(cu.getString(0));
        }
        return name;
    }

    //添加所有图片的网络地址
    public void addInternetImage(ArrayList<String> image){
        for (int i = 0; i < image.size(); i++) {
            String sql="insert into item (item_url) values ?";
            sd.execSQL(sql,new String[]{image.get(i)});
        }
    }

    //查询表中所有的item图片的地址
    public ArrayList<String> getImageUrl(){
        ArrayList<String> url=null;
        String sql="select item_url from item";
        Cursor cu=sd.rawQuery(sql,null);
        while (cu.moveToNext()){
            url.add(cu.getString(0));
        }
        return url;
    }



}
