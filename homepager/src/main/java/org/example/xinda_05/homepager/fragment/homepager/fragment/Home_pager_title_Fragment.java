package org.example.xinda_05.homepager.fragment.homepager.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.activity.Home_Pager_MyNews;
import org.example.xinda_05.homepager.fragment.homepager.activity.Home_Pager_to_item;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_title_Fragment extends Fragment{

    private LinearLayout HomePager_title_notice,HomePager_title_changeCity,HomePager_title_Search;
    private TextView HomePager_title_changeCityName;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_pager_title_layout,null);

        initView();

        changCity(getContext());

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

        HomePager_title_Search= (LinearLayout) view.findViewById(R.id.HomePager_title_Search);
        HomePager_title_Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(), Home_Pager_to_item.class);
                intent.putExtra("name","美食");
                getActivity().startActivity(intent);
            }
        });
    }

    public void changCity(final Context context){
        HomePager_title_changeCity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View view1=LayoutInflater.from(context).inflate(R.layout.home_pager_popwindow_citychange,null);
                PopupWindow pop=new PopupWindow(view1, WindowManager.LayoutParams.WRAP_CONTENT,WindowManager.LayoutParams.WRAP_CONTENT);
                pop.setBackgroundDrawable(new BitmapDrawable());
                pop.setFocusable(true);
                pop.showAsDropDown(HomePager_title_changeCity);
            }
        });
    }
}
