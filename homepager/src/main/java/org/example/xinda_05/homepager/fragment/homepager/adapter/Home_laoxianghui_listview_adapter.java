package org.example.xinda_05.homepager.fragment.homepager.adapter;

import android.Manifest;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.example.xinda_05.homepager.R;
import org.example.xinda_05.homepager.fragment.homepager.activity.Home_business_details;
import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_BusinessDetails_entity;
import org.example.xinda_05.homepager.fragment.homepager.model.Home_pager_bussinessImage_entity;

import java.util.ArrayList;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by ZhouZhicheng on 2016/8/10.
 */
public class Home_laoxianghui_listview_adapter extends BaseAdapter {

    private ArrayList<Home_pager_BusinessDetails_entity> data;
    private ArrayList<Home_pager_bussinessImage_entity> image;
    private Context context;

    public Home_laoxianghui_listview_adapter(ArrayList<Home_pager_BusinessDetails_entity> data, ArrayList<Home_pager_bussinessImage_entity> image, Context context) {
        this.data = data;
        this.context = context;
        this.image = image;
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
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.home_laoxianghui_layout_item, null);
            holder = new ViewHolder();
            holder.imageview_dianjia = (ImageView) view.findViewById(R.id.Home_laoxianghui_list_image);
            holder.textview_dianming = (TextView) view.findViewById(R.id.Home_laoxianghui_list_StoreName);
            holder.textview_jiage = (TextView) view.findViewById(R.id.Home_laoxianghui_list_Price);
            holder.textview_didian = (TextView) view.findViewById(R.id.Home_laoxianghui_list_dizhi);
            holder.textview_shijian1 = (TextView) view.findViewById(R.id.Home_laoxianghui_list_Time);
            holder.Home_laoxianghui_list_call = (ImageButton) view.findViewById(R.id.Home_laoxianghui_list_call);
            holder.Home_laoxianghui_list = (RelativeLayout) view.findViewById(R.id.Home_laoxianghui_list);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        Picasso.with(context).load(image.get(i).getImg_url()).into(holder.imageview_dianjia);
        holder.textview_dianming.setText(data.get(i).getMerchant_name());
        holder.textview_jiage.setText("￥ " + data.get(i).getPer_capita_consumption() + "/" + data.get(i).getMeasure_unit());
        holder.textview_didian.setText(data.get(i).getBusiness_location());
        holder.textview_shijian1.setText(data.get(i).getOpening_time() + "-" + data.get(i).getClosing_time());
        //点击跳转
        holder.Home_laoxianghui_list.setOnClickListener(new Info(context, i));
        //点击拨打电话
        holder.Home_laoxianghui_list_call.setOnClickListener(new callPhone(i));
        return view;
    }

    private class ViewHolder {
        public ImageView imageview_dianjia, imageview_dianjia1;
        private ImageButton Home_laoxianghui_list_call;
        public TextView textview_dianming, textview_jiage, textview_didian, textview_shijian1;

        public RelativeLayout Home_laoxianghui_list;
    }


    private class callPhone implements View.OnClickListener {

        private int phone;

        public callPhone(int phone) {
            this.phone = phone;
        }

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setMessage("确定要拨打：" + data.get(phone).getPhone());
            builder.setNegativeButton("确认", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + data.get(phone).getPhone()));
                    if (ActivityCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        // TODO: Consider calling
                        //    ActivityCompat#requestPermissions
                        // here to request the missing permissions, and then overriding
                        //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                        //                                          int[] grantResults)
                        // to handle the case where the user grants the permission. See the documentation
                        // for ActivityCompat#requestPermissions for more details.
                        return;
                    }
                    context.startActivity(intent);
                }
            });
            builder.setPositiveButton("取消", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            builder.create().show();
        }
    }

    private class Info implements View.OnClickListener {

        private Context context;
        private int id;

        public Info(Context context, int id) {
            this.context = context;
            this.id = id;
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(context, Home_business_details.class);
            intent.putExtra("dianming",data.get(id).getMerchant_name());
            intent.putExtra("renjun",data.get(id).getPer_capita_consumption());
            intent.putExtra("opentime",data.get(id).getOpening_time());
            intent.putExtra("closetime",data.get(id).getClosing_time());
            intent.putExtra("dizhi",data.get(id).getBusiness_location());
            intent.putExtra("lianxiren","前台");
            intent.putExtra("phone",data.get(id).getPhone());
            intent.putExtra("xiangqing",data.get(id).getDetail_info());
            intent.putExtra("image",image.get(id).getImg_url());
            context.startActivity(intent);
        }
    }

}
