package org.example.xinda_05.user;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.example.xinda_05.util.util.HttpUtil;
import org.example.xinda_05.util.util.xUtil;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;

import cz.msebera.android.httpclient.Header;

/**
 * Created by ZhouZhicheng on 2016/8/9.
 */
public class User_registration extends Activity {

    private EditText etPhone,user_yanzhengma,user_password,user_enter_password;
    private ImageButton user_enterRead;
    private Button btn1,user_fuwutiaokuan,user_zhuce;
    private LinearLayout fanhui;
    private boolean read=false;
    private ProgressDialog log;


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

        //点击注册按钮
        user_zhuce.setOnClickListener(new registerUser());

        //点击阅读按钮
        user_enterRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!read){
                    read=true;
                    user_enterRead.setImageResource(R.mipmap.checkbox_bg_fouse);
                }else{
                    read=false;
                    user_enterRead.setImageResource(R.mipmap.checkbox_bg_default);
                }
            }
        });




    }

    //网络请求注册新用户
    private void sendCode() {

        HttpUtil.getURLData().getCode(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    if(response.getString("msg").equalsIgnoreCase("发送成功")){
                        Toast.makeText(User_registration.this, "发送成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(User_registration.this, "发送失败", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(User_registration.this, "网络连接异常，短信发送失败", Toast.LENGTH_SHORT).show();
            }
        },etPhone.getText().toString());
    }


    //初始化控件
    private void initView(){
        fanhui= (LinearLayout) findViewById(R.id.user_registration_layout_fanhui);
        btn1= (Button) findViewById(R.id.btn1);
        etPhone= (EditText) findViewById(R.id.etPhone);
        user_yanzhengma= (EditText) findViewById(R.id.user_yanzhengma);
        user_password= (EditText) findViewById(R.id.user_password);
        user_enter_password = (EditText) findViewById(R.id.user_enter_password);
        user_enterRead= (ImageButton) findViewById(R.id.user_enterRead);
        user_fuwutiaokuan= (Button) findViewById(R.id.user_fuwutiaokuan);
        user_zhuce= (Button) findViewById(R.id.user_zhuce);


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
                    //发送验证码
                    sendCode();
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
                                }}}}).start();
                }
            }else{
                Toast.makeText(User_registration.this,"请输入手机号码",Toast.LENGTH_SHORT).show();
            }
        }
    }

    private class registerUser implements View.OnClickListener{
        @Override
        public void onClick(View view) {
            if(!etPhone.getText().toString().equalsIgnoreCase("")){
                if(!user_yanzhengma.getText().toString().equalsIgnoreCase("")){
                    if(!user_password.getText().toString().equalsIgnoreCase("")||user_password.getText().toString().length()<6){
                        if(!user_enter_password.getText().toString().equalsIgnoreCase("")||user_password.getText().toString().length()<6){
                            if(read){
                                if(user_enter_password.getText().toString().equalsIgnoreCase(user_password.getText().toString())){
                                    log= new ProgressDialog(User_registration.this);
                                    log.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                                    log.setMessage("努力注册中...");
                                    log.setCancelable(true);
                                    log.show();
                                    //进行验证码验证
                                    checkCode();
                                }else{
                                    Toast.makeText(User_registration.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(User_registration.this, "请阅读《服务条款》", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(User_registration.this, "确认密码不能少于6位或为空", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(User_registration.this, "密码不能少于6位或为空", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(User_registration.this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                }
            }else{
                Toast.makeText(User_registration.this, "手机号码不能为空", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void checkCode() {

        xUtil.getCode(new Callback.CacheCallback<String>() {
            @Override
            public boolean onCache(String result) {
                return false;
            }

            @Override
            public void onSuccess(String result) {
                Log.e("TAG","成功了，"+result);
                HttpUtil.getURLData().registerUser(new JsonHttpResponseHandler(){
                    @Override
                    public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                        super.onSuccess(statusCode, headers, response);
                        try {
                            if(response.getString("msg").equalsIgnoreCase("注册成功")){
                                Toast.makeText(User_registration.this, "注册成功", Toast.LENGTH_SHORT).show();
                                log.cancel();
                                finish();
                            }else{
                                log.cancel();
                                Toast.makeText(User_registration.this, "您的人品Boom，注册失败", Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                        super.onFailure(statusCode, headers, throwable, errorResponse);
                    }
                },etPhone.getText().toString(),user_password.getText().toString(),user_yanzhengma.getText().toString());
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }
        },user_yanzhengma.getText().toString());

        /*HttpUtil.getURLData().enterCode(new JsonHttpResponseHandler(){
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    Log.e("TAG",response.toString());
                    if(response.getString("msg").equalsIgnoreCase("验证成功")){
                        HttpUtil.getURLData().registerUser(new JsonHttpResponseHandler(){
                            @Override
                            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                                super.onSuccess(statusCode, headers, response);
                                try {
                                    if(response.getString("msg").equalsIgnoreCase("注册成功")){
                                        Toast.makeText(User_registration.this, "注册成功", Toast.LENGTH_SHORT).show();
                                        log.cancel();
                                        finish();
                                    }else{
                                        log.cancel();
                                        Toast.makeText(User_registration.this, "您的人品Boom，注册失败", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                                super.onFailure(statusCode, headers, throwable, errorResponse);
                            }
                        },etPhone.getText().toString(),user_password.getText().toString(),user_yanzhengma.getText().toString());
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, Throwable throwable, JSONObject errorResponse) {
                super.onFailure(statusCode, headers, throwable, errorResponse);
                Toast.makeText(User_registration.this, "网络连接异常，请重试", Toast.LENGTH_SHORT).show();
            }
        },user_yanzhengma.getText().toString());*/
    }
}
