package org.example.xinda_05.user;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by ZhouZhicheng on 2016/8/9.
 */
public class User_registration extends Activity {
    EditText etPhone;
    Button btn1;
    Handler timeHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if(msg.obj==0){
                btn1.setText("再次获取");
                btn1.setEnabled(true);
            }else{
                btn1.setText(msg.obj+"秒之后再次获取");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration_layout);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //判断手机号是否合法
                String Phone=etPhone.getText().toString();
                if(!Phone.matches("^[1][0-9]{10}$")){
                    Toast.makeText(User_registration.this, "号码不合法", Toast.LENGTH_SHORT).show();
                    return;

                }
                btn1.setEnabled(false);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        for (int i=60;i>0;i--){
                            Message msg=new Message();
                            msg.obj=i;
                            timeHandler.sendMessage(msg);
                            try{
                                Thread.sleep(1000);

                            }catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }).start();


            }
        });
    }
}
