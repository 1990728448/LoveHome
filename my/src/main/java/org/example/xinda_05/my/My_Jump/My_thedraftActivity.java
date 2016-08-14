package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.example.xinda_05.my.R;
import org.example.xinda_05.user.User_login;
import org.example.xinda_05.util.SharedPreferences.SharedPreferencesUtil;

/**
 * Created by Administrator on 2016/8/11.
 */
//这是我的草稿的Activiyt
public class My_thedraftActivity  extends Activity{
    ImageView img1;
    private SharedPreferencesUtil sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_thedraft_layout);
        sp=new SharedPreferencesUtil(this);
        if(!sp.queryLogin("Login").equals("1")){
            Intent intent=new Intent(this, User_login.class);
            startActivity(intent);
            this.finish();
        }else {
            img1 = (ImageView) findViewById(R.id.back);
            img1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });//点击后跳回到上一页面
        }
    }
}
