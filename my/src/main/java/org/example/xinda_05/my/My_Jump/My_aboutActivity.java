package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import org.example.xinda_05.my.R;

/**
 * Created by Administrator on 2016/8/11.
 */
//这是关于爱家乡的Activity
public class My_aboutActivity extends Activity {
    ImageView img1;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_about_layout);
        img1 = (ImageView) findViewById(R.id.back);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}

