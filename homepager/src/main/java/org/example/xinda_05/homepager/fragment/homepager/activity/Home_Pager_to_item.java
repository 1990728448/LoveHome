package org.example.xinda_05.homepager.fragment.homepager.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.example.xinda_05.homepager.R;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_Pager_to_item extends Activity{

    private TextView HomePager_item_layout_title,HomePager_item_layout_smalltitle;
    private LinearLayout HomePager_item_layout_popwindow1,HomePager_item_layout_popwindow2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page_item_layout);
        HomePager_item_layout_popwindow1=(LinearLayout)findViewById(R.id.HomePager_item_layout_popwindow1);
        HomePager_item_layout_popwindow1.setOnClickListener(new storeChange(this));
        HomePager_item_layout_popwindow2=(LinearLayout)findViewById(R.id.HomePager_item_layout_popwindow2);
        HomePager_item_layout_popwindow2.setOnClickListener(new storeChange(this));

        initView();

        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        HomePager_item_layout_title.setText(name);
        HomePager_item_layout_smalltitle.setText(name);
    }

    private void initView() {
        HomePager_item_layout_title= (TextView) findViewById(R.id.HomePager_item_layout_title);
        HomePager_item_layout_smalltitle= (TextView) findViewById(R.id.HomePager_item_layout_smalltitle);
    }
    private class storeChange implements View.OnClickListener{

        private Context context;


        public storeChange(Context context) {
            this.context = context;
        }

        @Override
        public void onClick(View view) {
            View view1= LayoutInflater.from(context).inflate(R.layout.home_pager_item_popupwindow,null);
            PopupWindow pop1=new PopupWindow(view1, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.WRAP_CONTENT);
            pop1.setBackgroundDrawable(new BitmapDrawable());
            pop1.setFocusable(true);
            pop1.showAsDropDown(view,0,0);

            View view2 = LayoutInflater.from(context).inflate(R.layout.home_laoxianghui_popowind_layouth, null);
            PopupWindow pop2 = new PopupWindow(view2, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
            pop2.setBackgroundDrawable(new BitmapDrawable());
            pop2.setFocusable(true);
            pop2.showAsDropDown(view, 0, 0);



        }
    }

}
