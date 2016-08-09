package org.example.xinda_05.homepager.fragment.homepager.util;

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
            String scuess=jsonObject.getString("msg");
            if(jsonObject.getString("msg").equalsIgnoreCase("success")){

            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

}
