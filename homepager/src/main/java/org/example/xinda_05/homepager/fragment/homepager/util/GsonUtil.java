package org.example.xinda_05.homepager.fragment.homepager.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_item_entity;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class GsonUtil {

    public static ArrayList<Home_pager_item_entity> Gson(JSONObject jsonObject){
        ArrayList<Home_pager_item_entity> list=new ArrayList<>();

        try{
            if(jsonObject.getString("msg").equalsIgnoreCase("success")){

                Gson gson=new Gson();

                //获取当前全部的list下的信息
                String msg=jsonObject.getString("list");

                //将list下的信息按需求封装好
                list=gson.fromJson(msg,new TypeToken<ArrayList<Home_pager_item_entity>>(){}.getType());

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
