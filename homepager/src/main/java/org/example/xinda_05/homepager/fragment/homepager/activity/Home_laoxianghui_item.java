package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.example.xinda_05.homepager.R;

/**
 * Created by ZhouZhicheng on 2016/8/11.
 */
public class Home_laoxianghui_item extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_laoxianghui_layout_item);

        LinearLayout fanhui= (LinearLayout) findViewById(R.id.HomePager_search_shop_back);

        //结束当前界面
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

}
