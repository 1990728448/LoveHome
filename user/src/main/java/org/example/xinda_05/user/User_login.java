package org.example.xinda_05.user;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.example.xinda_05.util.SQLUtil.userSQL;
import org.example.xinda_05.util.SharedPreferences.SharedPreferencesUtil;

/**
 * Created by ZhouZhicheng on 2016/8/8.
 */
public class User_login extends Activity {

    private EditText user_login_zhanghao;
    private EditText user_login_password;
    private Button user_login_Login;
    private SharedPreferencesUtil sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_layout);

        user_login_zhanghao= (EditText) findViewById(R.id.user_login_zhanghao);
        user_login_password= (EditText) findViewById(R.id.user_login_password);
        user_login_Login= (Button) findViewById(R.id.user_login_Login);

        sp=new SharedPreferencesUtil(this);

       //初始化控件
        Button bnt1=(Button) findViewById(R.id.user_login_layout_registration);
        Button bnt2=(Button) findViewById(R.id.user_login_layout_forgetpassword);
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

        //返回功能
        LinearLayout user_login_back= (LinearLayout) findViewById(R.id.user_login_back);
        user_login_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        //验证登陆是否成功
        Login();

    }


    private void Login(){
        user_login_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!user_login_zhanghao.getText().toString().equals("")&&!user_login_password.getText().toString().equals("")){
                    userSQL login=new userSQL(User_login.this);
                    if(login.userLogin(user_login_zhanghao.getText().toString(),user_login_password.getText().toString())){
                        Toast.makeText(User_login.this, "登陆成功", Toast.LENGTH_SHORT).show();
                        sp.addInfo("User",user_login_zhanghao.getText().toString());
                        sp.addInfo("Login","1");
                        finish();
                    }else{
                        Toast.makeText(User_login.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(User_login.this, "请输入账号和密码", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}

