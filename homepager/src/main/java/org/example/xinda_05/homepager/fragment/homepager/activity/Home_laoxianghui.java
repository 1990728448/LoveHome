package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_BusinessDetails_entity;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_laoxianghui_layout);

        HttpUtil.getURLData().getAllStoreInfo(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Toast.makeText(Home_laoxianghui.this, "response:" + response, Toast.LENGTH_SHORT).show();

                ArrayList<Home_pager_BusinessDetails_entity> info= GsonUtil.Gson1(response);
                new Home_pager_BusinessDetails_entity();


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(Home_laoxianghui.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
