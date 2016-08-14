package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.my.Constent.publishEntity;
import org.example.xinda_05.my.R;
import org.example.xinda_05.release.activity.activity.Release_Currency_Activity;
import org.example.xinda_05.user.User_forgetpasssword;
import org.example.xinda_05.util.util.HttpUtil;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import cz.msebera.android.httpclient.Header;
import medusa.theone.waterdroplistview.view.WaterDropListView;
import it.sephiroth.android.library.picasso.Picasso;
/**
 * Created by Jerry Mouse on 2016/8/9.
 */
//这是我的发布的Activity
public class My_releaseActivity extends Activity implements WaterDropListView.IWaterDropListViewListener{
    ImageView img;
    LinearLayout ly;
    WaterDropListView lv;
    RelativeLayout rl,r2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_release_layout);
        img= (ImageView) findViewById(R.id.back);
        ly= (LinearLayout) findViewById(R.id.popwind);
        lv= (WaterDropListView) findViewById(R.id.My_release_lv);


     /*  rl= (RelativeLayout) findViewById(R.id.My_examine_r1);
       // r2= (RelativeLayout) findViewById(R.id.My_examine_r2);
        //rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(My_releaseActivity.this,Release_Currency_Activity.class);
                startActivity(it1);
            }
        });
        r2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert=new AlertDialog.Builder(My_releaseActivity.this);
                alert.setTitle("是否删除");
                alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(My_releaseActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("取消", null);
                alert.show();
            }
        });*/
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

        HttpUtil.getURLData().getMy_releaseLUrl(new JsonHttpResponseHandler() {

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
            ViewHolder holder;
            if(view==null){
                holder=new ViewHolder();
                view=LayoutInflater.from(context).inflate(R.layout.my_examine_layout,null);
                holder.t1=(TextView) view.findViewById(R.id.My_examine_name);
                holder.t2=(TextView) view.findViewById(R.id.My_examine_money);
                holder.t3=(TextView) view.findViewById(R.id.My_examine_type);
                holder.t4=(TextView) view.findViewById(R.id.My_examine_time);
                holder.i1=(ImageView) view.findViewById(R.id.My_examine_Head);
                view.setTag(holder);
            }else{
                holder= (ViewHolder) view.getTag();
            }
            holder.t1.setText(data.get(i).getBusiness_location());
            holder.t2.setText(data.get(i).getBusiness_location());
            holder.t3.setText(data.get(i).getBusiness_location());
            holder.t4.setText(data.get(i).getBusiness_location());
            Picasso.with(context).load(R.mipmap.defualt).into(holder.i1);
            return view;
        }
    }

    private class ViewHolder{
        TextView t1,t2,t3,t4;
        ImageView i1;

    }
}





