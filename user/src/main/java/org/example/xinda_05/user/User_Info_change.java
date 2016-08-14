package org.example.xinda_05.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Jerry Mouse on 2016/8/15.
 */
public class User_Info_change extends Activity {

    private ImageView user_info_back;
    private TextView user_info_tel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_info_change_layout);

        Intent intent=getIntent();
        user_info_tel= (TextView) findViewById(R.id.user_info_tel);
        user_info_tel.setText(intent.getStringExtra("tel"));

        user_info_back= (ImageView) findViewById(R.id.user_info_back);
        user_info_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
