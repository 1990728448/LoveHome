package org.example.xinda_05.homepager.fragment.homepager.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.activity.Home_Pager_MyNews;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_title_Fragment extends Fragment{

    private LinearLayout HomePager_title_notice,HomePager_title_changeCity;
    private TextView HomePager_title_changeCityName;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_pager_title_layout,null);

        initView();

        return view;
    }

    private void initView(){
        HomePager_title_notice= (LinearLayout) view.findViewById(R.id.HomePager_title_notice);
        HomePager_title_notice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),Home_Pager_MyNews.class);
                startActivity(intent);
            }
        });

        HomePager_title_changeCity= (LinearLayout) view.findViewById(R.id.HomePager_title_changeCity);
        HomePager_title_changeCityName= (TextView) view.findViewById(R.id.HomePager_title_changeCityName);
    }

    public void changCity(){
        HomePager_title_changeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupWindow pop=new PopupWindow();
            }
        });
    }
}
