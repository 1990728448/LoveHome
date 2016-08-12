package org.example.xinda_05.user;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

/**
 * Created by ZhouZhicheng on 2016/8/10.
 */
public class User_forgetpasssword extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_forgetpassword_layout);

        ImageButton fanhui= (ImageButton) findViewById(R.id.user_forgetpassword_layout_fanhui);
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }
}