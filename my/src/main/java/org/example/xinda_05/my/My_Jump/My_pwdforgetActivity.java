package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.example.xinda_05.my.R;

/**
 * Created by Administrator on 2016/8/11.
 */
public class My_pwdforgetActivity extends Activity {
    ImageView img1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_changepassword__confirm_layout);
        img1 = (ImageView) findViewById(R.id.back);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });//点击后跳回到上一页面

    }
}
