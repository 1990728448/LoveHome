package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import cz.msebera.android.httpclient.Header;
import medusa.theone.waterdroplistview.view.WaterDropListView;

/**
 * Created by ZhouZhicheng on 2016/8/9.
 */

/**
   imgUrlList 图片
   merchant_name店名
   per_capita_consumption人均消费  opening_time营业时间  closing_time 打烊时间
   business_location地址
   contact 联系人
   phone  电话
   detail_info 简介
*、
 */

public class Home_laoxianghui extends Activity implements WaterDropListView.IWaterDropListViewListener {

    private TextView HomePager_LXH_name;
    private WaterDropListView Home_pager_LXH_listView;
    private LinearLayout HomePager_Store_allStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_laoxianghui_layout);


        Home_pager_LXH_listView = (WaterDropListView) findViewById(R.id.Home_pager_LXH_listView);
        Home_pager_LXH_listView.setWaterDropListViewListener(this);
        Home_pager_LXH_listView.setPullLoadEnable(true);
        LinearLayout shuaxin = (LinearLayout) findViewById(R.id.HomePager_search_shop_Search);
        HomePager_Store_allStore= (LinearLayout) findViewById(R.id.HomePager_Store_allStore);


        HomePager_Store_allStore.setOnClickListener(new storeChange(this));

        Home_pager_LXH_listView = (WaterDropListView) findViewById(R.id.Home_pager_LXH_listView);
        Home_pager_LXH_listView.setWaterDropListViewListener(this);
        Home_pager_LXH_listView.setPullLoadEnable(true);
        HomePager_LXH_name = (TextView) findViewById(R.id.HomePager_LXH_name);
        Intent intent = getIntent();
        HomePager_LXH_name.setText(intent.getStringExtra("name"));

        //结束当前界面
        LinearLayout fanhui = (LinearLayout) findViewById(R.id.HomePager_search_shop_back);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


        HttpUtil.getURLData().getAllStoreInfo(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                ArrayList<Home_pager_BusinessDetails_entity> info = GsonUtil.Gson1(response);
                ArrayList<Home_pager_bussinessImage_entity> image = GsonUtil.GsonImage(response);
                Home_pager_LXH_listView.setAdapter(new Home_laoxianghui_listview_adapter(info, image, Home_laoxianghui.this));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(Home_laoxianghui.this, "请求失败", Toast.LENGTH_SHORT).show();
            }
        });
    }


    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 1:
                    Home_pager_LXH_listView.stopRefresh();
                    Toast.makeText(Home_laoxianghui.this, "刷新成功", Toast.LENGTH_SHORT).show();
                    break;
                case 2:
                    Home_pager_LXH_listView.stopLoadMore();
                    Toast.makeText(Home_laoxianghui.this, "没有更多了", Toast.LENGTH_SHORT).show();
                    break;
            }

        }
    };

    @Override
    public void onRefresh() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onLoadMore() {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    handler.sendEmptyMessage(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
    private class storeChange implements View.OnClickListener{

        private Context context;

        public storeChange(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            View view1= LayoutInflater.from(context).inflate(R.layout.home_laoxianghui_popowind_layouth,null);
            PopupWindow pop=new PopupWindow(view1, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            pop.setBackgroundDrawable(new BitmapDrawable());
            pop.setFocusable(true);
            pop.showAsDropDown(view,0,0);
        }
    }
}
