package org.example.xinda_05.my.Constent;

/**
 * Created by Administrator on 2016/8/11.
 */
public class Constent {
    public  static final String URL="http://123.206.87.139/LoveHomeTownServe";
    //城市列表接口
    public static  final String CITY_PORT="/printCity";
    //父分类接口
    public static final  String PARENT_CLA="/printCategory";
    //子分类接口
    public  static final String SUN_CLA="/printCategory?parent_category_id=1";
    //发布信息查询接口
    public static final String POST_MSG="/detailInfo";
    //发布信息接口参数
    //1.用户名
    public static final String U_ID="user_id=";
    //2.城市名
    public static final String CITY_U="city_id=";
    //3.子分类id
    public static final String CHILD_CATEGORY_ID="child_category_id=";
    //4.父分类id
    public static final String PARENT_CATEGORY_ID="parent_category_id=";
    //5.显示页数
    public static final String PAGE="page=";
    //6.显示条数
    public static final String PAGE_SIZE="pageSize=";
    //7.是否审核       未审核  0   已审核  1   （默认为0）
    public static final String IS_APPROVE="is_approve=";

}
