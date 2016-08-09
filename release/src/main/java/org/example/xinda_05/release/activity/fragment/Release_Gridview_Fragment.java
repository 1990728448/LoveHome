package org.example.xinda_05.release.activity.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import org.example.xinda_05.release.R;

/**
 * Created by Administrator on 2016/8/9 0009.
 */
public class Release_Gridview_Fragment extends Fragment {
    int[] image = {R.mipmap.meishi, R.mipmap.yule, R.mipmap.fangchan, R.mipmap.che,
            R.mipmap.hunqing, R.mipmap.zhuangxiu, R.mipmap.jiaoyu, R.mipmap.gongzuo
            ,R.mipmap.baihuo, R.mipmap.tiaozhao, R.mipmap.shangwu, R.mipmap.bianmin,
            R.mipmap.laoxianghui, R.mipmap.qita};
    String[] name = {"美食", "娱乐", "房产", "车",
            "婚庆", "装修", "教育", "工作",
            "百货", "跳蚤", "商务", "便民",
            "老乡会", "其他"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.release_gridview_layout, null);
        GridView gridview = (GridView) view.findViewById(R.id.release_gridview);

        gridview.setAdapter(new BaseAdapter() {
            public View getView(int position, View convertView, ViewGroup parent) {
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.release_gridview_page_layout, null);
                ((ImageView) convertView.findViewById(R.id.release_gridview_page_Image)).setImageResource(image[position]);
                ((TextView) convertView.findViewById(R.id.release_gridview_page_name)).setText(name[position]);
                return convertView;
            }
            @Override
            public int getCount() {
                return 0;
            }

            @Override
            public Object getItem(int i) {
                return null;
            }

            @Override
            public long getItemId(int i) {
                return 0;
            }



        });
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}





