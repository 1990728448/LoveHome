package org.example.xinda_05.my;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class My_releaseActivity extends Activity{

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.my_about_layout);
            Button bt1=(Button) findViewById(R.id.back);
            bt1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
               });//点击后跳回到上一页面
        }
}





