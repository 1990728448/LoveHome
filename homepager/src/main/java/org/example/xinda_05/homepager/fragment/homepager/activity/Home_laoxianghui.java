package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.adapter.Home_laoxianghui_listview_adapter;
import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_BusinessDetails_entity;
import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_bussinessImage_entity;
import org.example.xinda_05.homepager.fragment.homepager.util.GsonUtil;
import org.example.xinda_05.util.util.HttpUtil;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ZhouZhicheng on 2016/8/9.
 */

/*
   imgUrlList 图片
   merchant_name店名
   per_capita_consumption人均消费  opening_time营业时间  closing_time 打烊时间
   business_location地址
   contact 联系人
   phone  电话
   detail_info 简介
*、
 */

public class Home_laoxianghui extends Activity{

    private ListView Home_pager_LXH_listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_laoxianghui_layout);

        Home_pager_LXH_listView= (ListView) findViewById(R.id.Home_pager_LXH_listView);


        HttpUtil.getURLData().getAllStoreInfo(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                ArrayList<Home_pager_BusinessDetails_entity> info= GsonUtil.Gson1(response);
                ArrayList<Home_pager_bussinessImage_entity> image=GsonUtil.GsonImage(response);
                Home_pager_LXH_listView.setAdapter(new Home_laoxianghui_listview_adapter(info,image,Home_laoxianghui.this));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(Home_laoxianghui.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
