package org.example.xinda_05.my.My_Jump;

import android.app.Activity;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import org.example.xinda_05.my.R;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
//这是我的发布的Activity
public class My_releaseActivity extends Activity{
    ImageView img;
    LinearLayout ly;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_release_layout);
        img= (ImageView) findViewById(R.id.back);
        ly= (LinearLayout) findViewById(R.id.popwind);
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        ly.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupWindow pop=new PopupWindow(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                View v= LayoutInflater.from(My_releaseActivity.this).inflate(R.layout.pop_v,null);
                pop.setContentView(v);
                pop.setFocusable(true);
                pop.setOutsideTouchable(true);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.showAsDropDown(ly);
            }
        });
     }
}





