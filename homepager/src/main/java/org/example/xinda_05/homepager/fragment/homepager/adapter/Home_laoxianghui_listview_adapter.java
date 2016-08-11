package org.example.xinda_05.homepager.fragment.homepager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_BusinessDetails_entity;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ZhouZhicheng on 2016/8/10.
 */
public class Home_laoxianghui_listview_adapter extends BaseAdapter {

    private ArrayList<Home_pager_BusinessDetails_entity> data;
    private Context context;

    public Home_laoxianghui_listview_adapter(ArrayList<Home_pager_BusinessDetails_entity> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.home_laoxianghui_layout_item, null);
            holder = new ViewHolder();
            holder.imageview_dianjia = (ImageView) view.findViewById(R.id.imageview_dianjia);
            holder.textview_dianming = (TextView) view.findViewById(R.id.textview_dianjia);
            holder.textview_jiage = (TextView) view.findViewById(R.id.textview_jiage);
            holder.textview_didian = (TextView) view.findViewById(R.id.textview_didian);
            holder.textview_shijian1 = (TextView) view.findViewById(R.id.shijian);
            holder.textview_shijian2 = (TextView) view.findViewById(R.id.shijian);

            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(data.get(i).getImg_url()).into(holder.imageview_dianjia);
        holder.textview_dianming.setText(data.get(i).getMerchant_name());
        holder.textview_jiage.setText(data.get(i).getPer_capita_consumption());
        holder.textview_didian.setText(data.get(i).getBusiness_location());
        holder.textview_shijian1.setText(data.get(i).getOpening_time());
        holder.textview_shijian2.setText(data.get(i).getClosing_time());




        return view;
    }

    private class ViewHolder {
        public ImageView imageview_dianjia;
        public TextView textview_dianming,textview_jiage,textview_didian,textview_shijian1,textview_shijian2;

    }
}
