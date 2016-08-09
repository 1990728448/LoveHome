package org.example.xinda_05.lovehome;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;

import org.example.xinda_05.homepager.fragment.homepager.fragment.Home_pager_content_Fragment;
import org.example.xinda_05.homepager.fragment.homepager.fragment.Home_pager_title_Fragment;

public class MainActivity extends FragmentActivity {

    FragmentManager fm; //碎片管理器
    FragmentTransaction ft;//碎片事务


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.activity_main);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        //初始化控件
        initView();




    }
    /*
     * 用来初始化控件
     * @author Jerry Mouse
     * @time 2016/8/9 2:28
     * @effect
     */
    private void initView() {
        fm=getSupportFragmentManager();
        ft=fm.beginTransaction();
        ft.replace(R.id.HomePager_layout_title,new Home_pager_title_Fragment());
        ft.replace(R.id.HomePager_layout_content,new Home_pager_content_Fragment());
        ft.commit();
    }
}
