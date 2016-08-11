package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.example.xinda_05.my.R;

/**
 * Created by Administrator on 2016/8/11.
 */
//这是平台声明的Activity
public class My_StatementActivitiy extends Activity {
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_platformstatement_layout);
        img1 = (ImageView) findViewById(R.id.back);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });//点击后跳回到上一页面
    }
}