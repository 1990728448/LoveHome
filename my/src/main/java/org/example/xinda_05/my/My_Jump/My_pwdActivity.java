package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import org.example.xinda_05.my.R;
import org.example.xinda_05.user.User_forgetpasssword;

/**
 * Created by Administrator on 2016/8/13.
 */
public class My_pwdActivity extends Activity {
    ImageView img1;
    LinearLayout ll1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_modifypassword_layout);
        img1 = (ImageButton) findViewById(R.id.back);
       ll1=(LinearLayout) findViewById(R.id.forgetpwd);
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(My_pwdActivity.this,User_forgetpasssword.class);
                startActivity(it1);
            }
        });
    }
}
