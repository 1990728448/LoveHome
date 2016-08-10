package org.example.xinda_05.homepager.fragment.homepager.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.adapter.Home_pager_LunBo_ViewPager_adapter;
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
    private ArrayList<ImageView> LunBoDot;
    private LinearLayout ll;
    private ViewPager viewPager;
    private ArrayList<LinearLayout> dot;
    private ViewPager HomePager_content_ViewPager;
    private LinearLayout HomePager_content_ViewPager_Dot;


    private int[] image= new int[]{R.mipmap.lunbo1, R.mipmap.lunbo2, R.mipmap.lunbo3};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.home_pager_content_layout, container, false);

        //初始化所有控件
        initView();

        //网络获取列表，填充至界面
        intoGridViewData();

        //加载ViewPager轮播图
        HomePager_content_ViewPager.setAdapter(new Home_pager_LunBo_ViewPager_adapter(getContext(),image));

        //轮播图添加小圆点
        LinearLayout.LayoutParams lp= new LinearLayout.LayoutParams(20,20);
        for (int i = 0; i <image.length; i++) {
            ImageView imageView=new ImageView(getActivity());
            if(i!=0){
                lp.leftMargin=15;
                imageView.setLayoutParams(lp);
            }
            imageView.setImageResource(R.mipmap.hen_point);
            imageView.setLayoutParams(lp);
            LunBoDot.add(imageView);
            HomePager_content_ViewPager_Dot.addView(imageView);
        }

        //轮播图上的圆点变色
        LunBoDot.get(0).setImageResource(R.mipmap.green_point);
        HomePager_content_ViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < image.length; i++) {
                    LunBoDot.get(i).setImageResource(R.mipmap.hen_point);
                }
                LunBoDot.get(position%image.length).setImageResource(R.mipmap.green_point);
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        //设置中间位置,保证是页面数量的整数倍
        HomePager_content_ViewPager.setCurrentItem((1000/2)-(1000/2)%image.length);
        return view;
    }

    //初始化控件
    private void initView() {
        viewPager = (ViewPager) view.findViewById(R.id.HomePager_content_Item_ViewPager);
        ll = (LinearLayout) view.findViewById(R.id.HomePager_content_Item_GroupDot);
        HomePager_content_ViewPager= (ViewPager) view.findViewById(R.id.HomePager_content_ViewPager);
        HomePager_content_ViewPager_Dot= (LinearLayout) view.findViewById(R.id.HomePager_content_ViewPager_Dot);

        dot = new ArrayList<>();
        LunBoDot=new ArrayList<>();

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

                LinearLayout.LayoutParams Params = new LinearLayout.LayoutParams(20, 20);
                for (int i = 0; i < (data.size() / 8) + 1; i++) {
                    LinearLayout l2 = new LinearLayout(getActivity());
                    if (i == 0) {
                        l2.setBackgroundResource(R.mipmap.hen_point);
                        l2.setLayoutParams(Params);
                        ll.addView(l2);
                        dot.add(l2);
                    } else {
                        l2.setBackgroundResource(R.mipmap.hen_point);
                        Params.leftMargin = 15;
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

    //处理轮播图自动滚动
    public class MyThrad extends Thread{

    }
}
