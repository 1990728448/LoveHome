package org.example.xinda_05.release.activity.activity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.release.R;
import org.example.xinda_05.release.activity.entity.Release_pager_entity;
import org.example.xinda_05.util.util.HttpUtil;
import org.example.xinda_05.util.util.URL;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class MainActivity_Release extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
      View view=inflater.inflate(R.layout.release_gridview_layout,null);
       return view;

    }
    public void initData() {
       HttpUtil.getURLData().getItem(new JsonHttpResponseHandler(){
           @Override
           public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
               super.onSuccess(statusCode, headers, response);
               ArrayList<Release_pager_entity>  data=new ArrayList<Release_pager_entity>();

           }

           @Override
           public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
               super.onFailure(statusCode, headers, throwable, errorResponse);
           }
       });



    }
}