package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.example.xinda_05.homepager.R;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ZhouZhicheng on 2016/8/10.
 */
public class Home_business_details extends Activity{
    private LinearLayout home_business_details_layouth;


//    intent.putExtra("dianming",data.get(id).getMerchant_name());
//    intent.putExtra("renjun",data.get(id).getPer_capita_consumption());
//    intent.putExtra("opentime",data.get(id).getOpening_time());
//    intent.putExtra("closetime",data.get(id).getClosing_time());
//    intent.putExtra("dizhi",data.get(id).getBusiness_location());
//    intent.putExtra("lianxiren","前台");
//    intent.putExtra("phone",data.get(id).getPhone());
//    intent.putExtra("xiangqing",data.get(id).getDetail_info());
//    intent.putExtra("image",image.get(id).getImg_url());


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_business_details_layouth);
        LinearLayout fanhui= (LinearLayout) findViewById(R.id.home_business_layouth_fanhui);
        ImageButton shoucang= (ImageButton) findViewById(R.id.home_business_layouth_shoucang);
        TextView dianming= (TextView) findViewById(R.id.home_business_dianming);
        TextView renjun= (TextView) findViewById(R.id.home_business_jiage);
        TextView opentime= (TextView) findViewById(R.id.home_business_shijian);
        TextView closetime= (TextView) findViewById(R.id.home_business_shijian1);
        TextView dizhi= (TextView) findViewById(R.id.home_business_dizhi);
        TextView phone= (TextView) findViewById(R.id.home_business_dianhua);
        TextView xiangqing= (TextView) findViewById(R.id.home_business_jianjie);
        ImageView image= (ImageView) findViewById(R.id.home_business_dianjia);

        Intent intent=getIntent();
        dianming.setText(intent.getStringExtra("dianming"));
        renjun.setText(intent.getStringExtra("renjun"));
        opentime.setText(intent.getStringExtra("opentime"));
        closetime.setText(intent.getStringExtra("closetime"));
        dizhi.setText(intent.getStringExtra("dizhi"));
        phone.setText(intent.getStringExtra("phone"));
        xiangqing.setText(intent.getStringExtra("xiangqing"));
        Picasso.with(this).load(intent.getStringExtra("image")).into(image);




        //结束当前界面
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
