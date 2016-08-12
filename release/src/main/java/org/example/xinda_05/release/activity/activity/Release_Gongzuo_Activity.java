package org.example.xinda_05.release.activity.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import org.example.xinda_05.release.R;

/**
 * Created by Administrator on 2016/8/11 0011.
 */
public class Release_Gongzuo_Activity  extends Activity {
    private LinearLayout item_back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.release_gongzuo_layout);
        item_back= (LinearLayout) findViewById(R.id.Release_item_layout_back);
        item_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();

            }
        });
    }
}
