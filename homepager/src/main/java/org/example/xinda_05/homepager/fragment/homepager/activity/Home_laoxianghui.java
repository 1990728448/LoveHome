package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
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
    private TextView HomePager_LXH_name;

    PopupWindow  pop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_laoxianghui_layout);

        LinearLayout fanhui= (LinearLayout) findViewById(R.id.HomePager_search_shop_back);
        LinearLayout shuaxin= (LinearLayout) findViewById(R.id.HomePager_search_shop_Search);
        final LinearLayout popowind= (LinearLayout) findViewById(R.id.HomePager_popowind);







        Home_pager_LXH_listView= (ListView) findViewById(R.id.Home_pager_LXH_listView);
        HomePager_LXH_name= (TextView) findViewById(R.id.HomePager_LXH_name);
        final Intent intent=getIntent();
        HomePager_LXH_name.setText(intent.getStringExtra("name"));




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

        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        popowind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                view= LayoutInflater.from(Home_laoxianghui.this).inflate(R.layout.home_laoxianghui_popowind_layouth,null);
                pop=new PopupWindow(view, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.setFocusable(true);
                pop.setOutsideTouchable(true);
                pop.showAsDropDown(view,0,190);
            }
        });

    }

}
