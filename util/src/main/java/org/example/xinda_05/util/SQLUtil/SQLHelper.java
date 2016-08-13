package org.example.xinda_05.util.SQLUtil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Jerry Mouse on 2016/8/12.
 */


    /**
     *  item 表---存放首页及发布的grid的内容（_id_ 主键，item_name 子项名字，item_url 子项图片地址）
     *  location 表---存放所有商铺信息及本地保存的草稿（_id 主键，business_location 商家地址，opening_time 开门时间，closing_time 关门时间
     *                              detail_info 简介，measure_unit 人均单位，merchant_name 商铺名称，per_capita_consumption，消费金额
     *                              phone 电话号码，select 本地所属类型，image_url 图片地址，collect 收藏（标志位1 为true ，else fasle ））
     *  store 表---存放所有商铺信息及本地保存的草稿（_id 主键，business_location 商家地址，opening_time 开门时间，closing_time 关门时间
     *                              detail_info 简介，measure_unit 人均单位，merchant_name 商铺名称，per_capita_consumption，消费金额
     *                              phone 电话号码 ，people 联系人 ，selects 本地所属类型，image_url 图片地址collect 收藏（标志位1 为true ，else fasle ））
     * @author Jerry Mouse
     * @time 2016/8/12 13:40
     * @effect
     */

public class SQLHelper extends SQLiteOpenHelper {

    public SQLHelper(Context context) {
        super(context, "LoveHome.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql1="create table item (_id integer primary key autoincrement , item_name varchar(60) , item_url varchar(255))";
        String sql2="create table goods (_id integer primary key autoincrement , business_location varchar(200) , opening_time varchar(15) ," +
                "closing_time varchar(15) , detail_info varchar(500) , measure_unit varchar(100) , merchant_name varchar(100) , " +
                "per_capita_consumption varchar(10) , phone varchar(15) , image_url varchar(255) , collect varchar(1))";
        String sql3="create table location (_id integer primary key autoincrement , business_location varchar(200) , opening_time varchar(15) ," +
                "closing_time varchar(15) , detail_info varchar(500) , measure_unit varchar(100) , merchant_name varchar(100) , " +
                "per_capita_consumption varchar(10) , phone varchar(15) , image_url varchar(255) ," +
                " people varchar(15) , selects varchar(50) ,collect varchar(1))";
        sqLiteDatabase.execSQL(sql1);
        sqLiteDatabase.execSQL(sql2);
        sqLiteDatabase.execSQL(sql3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
