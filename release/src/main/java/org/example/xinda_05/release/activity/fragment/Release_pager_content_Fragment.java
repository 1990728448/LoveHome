package org.example.xinda_05.release.activity.fragment;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.release.R;
import org.example.xinda_05.release.activity.adapter.MainActivity_Release_Adapter;
import org.example.xinda_05.release.activity.entity.Release_pager_entity;
import org.example.xinda_05.release.activity.util.GsonUtil;
import org.example.xinda_05.util.util.HttpUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/8/10 0010.
 */
public class Release_pager_content_Fragment extends Fragment{
    private ArrayList<GridView> gridViews;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.release_gridview_layout,null);
        return view;

    }
    public void initData() {
        HttpUtil.getURLData().getItem(new JsonHttpResponseHandler() {
            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONArray errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);

            }

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray response) {
                super.onSuccess(statusCode, headers, response);
                ArrayList<Release_pager_entity> data = new ArrayList<>();
                //数据进行封装
                ArrayList<Release_pager_entity> date = GsonUtil.Gson(response);

                //数据填充至Gridview
               // gridViews.setAdapter(new MainActivity_Release_Adapter(date, getContext()));
               // date.setAdapter(new MainActivity_Release_Adapter(data,getContext()));
            }

        });
    }
}
