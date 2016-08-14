package org.example.xinda_05.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ZhouZhicheng on 2016/8/8.
 */
public class User_login extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_layout);

       //初始化控件
        TextView bnt1= (TextView) findViewById(R.id.user_login_layout_registration);
        TextView bnt2= (TextView) findViewById(R.id.user_login_layout_forgetpassword);
       //跳转到用户注册界面
        bnt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_login.this,User_registration.class);
                startActivity(intent);

            }
        });
        //跳转到忘记密码界面
        bnt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(User_login.this,User_forgetpasssword.class);
                startActivity(intent);

            }
        });

    }



}

