package org.example.xinda_05.homepager.fragment.homepager.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;

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
    private LinearLayout ll;
    private ViewPager viewPager;
    private ArrayList<LinearLayout> dot;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_pager_content_layout, container, false);

        //初始化所有控件
        initView();

        intoGridViewData();


        return view;
    }

    //初始化控件
    private void initView() {
        View view1 = LayoutInflater.from(getContext()).inflate(R.layout.home_pager_content_gridview, null);
        HomePager_content_GridView = (GridView) view1.findViewById(R.id.HomePager_content_GridView);
        //viewPager = (ViewPager) view.findViewById(R.id.HomePager_content_Item_ViewPager);
        viewPager = (ViewPager) view.findViewById(R.id.HomePager_content_Item_ViewPager);
        ll = (LinearLayout) view.findViewById(R.id.HomePager_content_Item_GroupDot);
        dot = new ArrayList<>();

        gridViews = new ArrayList<>();
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
                viewPager.setAdapter(new Home_pager_content_item_adapter(data, getContext(), ll));

                //添加Item小圆点

                LinearLayout.LayoutParams Params = new LinearLayout.LayoutParams(25, 25);
                for (int i = 0; i < (data.size() / 8) + 1; i++) {
                    if (i == 0) {
                        LinearLayout l2 = new LinearLayout(getContext());
                        l2.setBackgroundResource(R.mipmap.hen_point);
                        l2.setLayoutParams(Params);
                        ll.addView(l2);
                        dot.add(l2);
                    } else {
                        LinearLayout l2 = new LinearLayout(getContext());
                        l2.setBackgroundResource(R.mipmap.hen_point);
                        Params.leftMargin = 13;
                        l2.setLayoutParams(Params);
                        ll.addView(l2);
                        dot.add(l2);
                    }
                }

                dot.get(0).setBackgroundResource(R.mipmap.green_point);

                viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                    @Override
                    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

                    }

                    @Override
                    public void onPageSelected(int position) {
                        Home_pager_content_item_adapter.page = position;
                        for (int i = 0; i < dot.size(); i++) {
                            if (i != position) {
                                dot.get(i).setBackgroundResource(R.mipmap.hen_point);
                            }
                        }
                        dot.get(position).setBackgroundResource(R.mipmap.green_point);
                    }

                    @Override
                    public void onPageScrollStateChanged(int state) {

                    }
                });


            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
