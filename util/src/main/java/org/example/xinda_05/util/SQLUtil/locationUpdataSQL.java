package org.example.xinda_05.util.SQLUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Jerry Mouse on 2016/8/12.
 */
public class locationUpdataSQL {

    private SQLiteDatabase sd;

    public locationUpdataSQL(Context context) {
        SQLHelper helper=new SQLHelper(context);
        sd=helper.getReadableDatabase();
    }

    public void updataInfo(int ID,String merchant_name,String opening_time,String closing_time,String per_capita_consumption,
                           String measure_unit,String business_location,String people,String phone,String image_url){
        String sql="update location set merchant_name='"+merchant_name+"',"+"opening_time='"+opening_time+"'," +
                ""+"closing_time='"+closing_time+"',"+"per_capita_consumption='"+per_capita_consumption+"',"+"measure_unit='" +
                ""+measure_unit+"',"+"business_location='"+business_location+"',"+"people='"+people+"'," +
                ""+"phone='"+phone+"',"+"image_url='"+image_url+"' where _id = "+ID+";" ;
        sd.execSQL(sql);
    }

    public void deletePublishInfo(int ID){
        String sql = "delete from location where _id = ?";
        sd.execSQL(sql , new String[]{ID+""});
    }

}
