package org.example.xinda_05.util.SQLUtil;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Jerry Mouse on 2016/8/13.
 */
public class userSQL {

    private SQLiteDatabase sd;

    public userSQL(Context context) {
        SQLHelper helper=new SQLHelper(context);
        sd=helper.getReadableDatabase();
    }

    private boolean isUser(String number){
        String sql="select user_number from user where user_number= ?";
        Cursor cu=sd.rawQuery(sql,new String[]{number});
        return cu.moveToFirst();
    }

    public boolean addUser(String number , String pwd){
        boolean flag=false;
        if(!isUser(number)){
            String sql="insert into user (user_number,user_password) values (?,?)";
            sd.execSQL(sql,new String[]{number,pwd});
            return true;
        }
        return flag;
    }

    public boolean userLogin(String number , String pwd){
        boolean flag=false;
        if(isUser(number)){
            String sql1="select user_password from user where user_number = ?";
            Cursor cu=sd.rawQuery(sql1,new String[]{number});
            Log.e("TAG",cu.moveToFirst()+"");
            if(cu.getString(0).equalsIgnoreCase(pwd)){
                flag=true;
            }
        }
        return flag;
    }
}
