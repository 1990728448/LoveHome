package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import org.example.xinda_05.homepager.R;

/**
 * Created by ZhouZhicheng on 2016/8/10.
 */
public class Home_business_details extends Activity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_business_details_layouth);
        ImageButton fanhui= (ImageButton) findViewById(R.id.home_business_layouth_fanhui);
        ImageButton shoucang= (ImageButton) findViewById(R.id.home_business_layouth_shoucang);
        //结束当前界面
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });



    }
}
