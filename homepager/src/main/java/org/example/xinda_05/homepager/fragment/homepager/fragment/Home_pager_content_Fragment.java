package org.example.xinda_05.homepager.fragment.homepager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.util.util.HttpUtil;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_content_Fragment extends Fragment {

    private View view;
    private GridView HomePager_content_GridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.home_pager_content_layout,null);



        return view;
    }

    private void initView(){
        HomePager_content_GridView= (GridView) view.findViewById(R.id.HomePager_content_GridView);
    }

    private void intoGridViewData(){
        HttpUtil.getURLData().getItem(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);

                //Gson gson=new Gson();
                //gson.fromJson(response,);

            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
            }
        });
    }
}
