package org.example.xinda_05.homepager.fragment.homepager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_item_entity;

import java.util.ArrayList;

/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_content_item_adapter extends PagerAdapter {

    private Context context;
    private ArrayList<Home_pager_item_entity> list;

    public Home_pager_content_item_adapter(ArrayList<Home_pager_item_entity> list, Context context) {
        this.list = list;
        this.context=context;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        GridView view=new GridView(context);
        Log.e("TAG","position的大小"+position);
        view.setAdapter(new Home_pager_content_gridview_adapter(context,list,position));
        view.setNumColumns(4);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        return list.size()/8;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }
}
