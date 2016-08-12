package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.my.Constent.publishEntity;
import org.example.xinda_05.my.R;
import org.example.xinda_05.util.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;
import medusa.theone.waterdroplistview.view.WaterDropListView;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
//这是我的发布的Activity
public class My_releaseActivity extends Activity implements WaterDropListView.IWaterDropListViewListener{
    ImageView img;
    LinearLayout ly;
    WaterDropListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_release_layout);
        img= (ImageView) findViewById(R.id.back);
        ly= (LinearLayout) findViewById(R.id.popwind);
        lv= (WaterDropListView) findViewById(R.id.My_release_lv);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupWindow pop=new PopupWindow(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                View v= LayoutInflater.from(My_releaseActivity.this).inflate(R.layout.pop_v,null);
                pop.setContentView(v);
                pop.setFocusable(true);
                pop.setOutsideTouchable(true);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.showAsDropDown(ly);
            }
        });

        HttpUtil.getURLData().getMy_releaseLUrl(new JsonHttpResponseHandler()
        {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                Gson gson=new Gson();
                try {
                    String msg=response.getString("list");
                    ArrayList<publishEntity> list=gson.fromJson(msg,new TypeToken<ArrayList<publishEntity>>(){}.getType());
                    lv.setAdapter(new listView(My_releaseActivity.this,list));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(My_releaseActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
            }
        });
     }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }

    private class listView extends BaseAdapter{

        private Context context;
        private ArrayList<publishEntity> data;
        public listView(Context context, ArrayList<publishEntity> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {



            return view;
        }
    }
}





