package org.example.xinda_05.user;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * Created by ZhouZhicheng on 2016/8/9.
 */
public class User_registration extends Activity {
    EditText etPhone;
    Button btn1;
    LinearLayout fanhui;


    Handler timeHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.what==1){
                if(msg.arg1==0){
                    btn1.setText("获取验证码");
                    btn1.setEnabled(true);
                    btn1.setTextSize(15);
//                    btn1.setBackgroundResource(R.mipmap.btn_small_green);
                }else {
                    btn1.setText(msg.arg1+"秒后再次获取");
                }
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_registration_layout);

        //初始化控件
        initView();

        //判断手机号是否合法
        btn1.setOnClickListener(new number());
    }


    //初始化控件
    private void initView(){
        fanhui= (LinearLayout) findViewById(R.id.user_registration_layout_fanhui);
        btn1= (Button) findViewById(R.id.btn1);
        etPhone= (EditText) findViewById(R.id.etPhone);


        //返回上级页面
        fanhui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }




    //判断手机号是否合法
    private class number implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //判断手机号是否合法
            String Phone=etPhone.getText().toString();
            if(Phone!=null){
                if(!Phone.matches("^[1][0-9]{10}$")){
                    Toast.makeText(User_registration.this, "号码不合法", Toast.LENGTH_SHORT).show();
                }else{
                    btn1.setEnabled(false);
                    btn1.setTextSize(15);
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            for (int i=60;i>=0;i--){
                                try{
                                    Thread.sleep(1000);
                                    Message msg=new Message();
                                    msg.arg1=i;
                                    msg.what=1;
                                    timeHandler.sendMessage(msg);
                                }catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }

                        }
                    }).start();
                }
            }else{
                Toast.makeText(User_registration.this,"请输入手机号码",Toast.LENGTH_SHORT).show();
            }
        }
    }
}
