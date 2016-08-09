package org.example.xinda_05.homepager.fragment.homepager.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.adapter.Home_pager_content_item_adapter;
import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_item_entity;
import org.example.xinda_05.homepager.fragment.homepager.util.GsonUtil;
import org.example.xinda_05.util.util.HttpUtil;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_content_Fragment extends Fragment {

    private View view;
    private GridView HomePager_content_GridView;
    private ArrayList<GridView> gridViews;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_pager_content_layout, container,false);

        //初始化所有控件
        initView();

        intoGridViewData();


        return view;
    }

    //初始化控件
    private void initView() {
        View view1=LayoutInflater.from(getContext()).inflate(R.layout.home_pager_content_gridview,null);
        HomePager_content_GridView = (GridView) view1.findViewById(R.id.HomePager_content_GridView);
        //viewPager = (ViewPager) view.findViewById(R.id.HomePager_content_Item_ViewPager);
        viewPager= (ViewPager) view.findViewById(R.id.HomePager_content_Item_ViewPager);
        gridViews=new ArrayList<>();
    }


    //网络获取列表，填充至界面
    private void intoGridViewData() {
        HttpUtil.getURLData().getItem(new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                //数据进行封装
                ArrayList<Home_pager_item_entity> data = GsonUtil.Gson(response);

                //数据填充至PageView
               viewPager.setAdapter(new Home_pager_content_item_adapter(data,getContext()));
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
