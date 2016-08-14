package org.example.xinda_05.my;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.example.xinda_05.my.My_Jump.My_MessageActivity;
import org.example.xinda_05.my.My_Jump.My_StatementActivitiy;
import org.example.xinda_05.my.My_Jump.My_aboutActivity;
import org.example.xinda_05.my.My_Jump.My_collectionActivity;
import org.example.xinda_05.my.My_Jump.My_pwdActivity;
import org.example.xinda_05.my.My_Jump.My_releaseActivity;
import org.example.xinda_05.my.My_Jump.My_thedraftActivity;


/**
 * Created by CYLL on 2016/8/9.
 */
public class My_personal_HomePageFragment extends Fragment {
    @Nullable
     LinearLayout lat1,lat2,lat3,lat4,lat5,lat6,lat7,lat8,lat9;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.my_homepage_layout, null);
        lat1=(LinearLayout) view.findViewById(R.id.person_mypublish_intent);
        lat2=(LinearLayout)view.findViewById(R.id.person_mypublish_intent1);
        lat3=(LinearLayout)view.findViewById(R.id.person_mypublish_intent2);
        lat4=(LinearLayout)view.findViewById(R.id.person_mypublish_intent3);
        lat5=(LinearLayout)view.findViewById(R.id.person_mypublish_intent4);
        lat6=(LinearLayout)view.findViewById(R.id.person_mypublish_intent5);
        lat7=(LinearLayout)view.findViewById(R.id.person_mypublish_intent7);
        lat8=(LinearLayout)view.findViewById(R.id.person_mypublish_intent6);
        lat9= (LinearLayout)view.findViewById(R.id.person_mypublish_intent8);
      Button  bt1 =(Button) view.findViewById(R.id.My_homepage_exit);
        lat1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it1=new Intent(getActivity(),My_releaseActivity.class);
                getActivity().startActivity(it1);
            }
        });
        lat2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it2=new Intent(getActivity(),My_thedraftActivity.class);
                getActivity().startActivity(it2);
            }
        });
        lat3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it3=new Intent(getActivity(),My_collectionActivity.class);
                getActivity().startActivity(it3);
            }
        });
        lat4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it4=new Intent(getActivity(),My_MessageActivity.class);
                getActivity().startActivity(it4);
            }
        });
        lat5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it5=new Intent(getActivity(),My_StatementActivitiy.class);
                getActivity().startActivity(it5);
            }
        });
        lat6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it6=new Intent(getActivity(),My_aboutActivity.class);
                getActivity().startActivity(it6);
            }
        });
        lat7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          Intent it7=new Intent(getActivity(),My_pwdActivity.class);
          getActivity().startActivity(it7);
            }
        });
        lat8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        lat9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert=new AlertDialog.Builder(getContext());
                alert.setTitle("确定清除缓存");
                alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                       Toast.makeText(getActivity(),"清除成功", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("取消", null);
                alert.show();

            }
        });
       bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alert=new AlertDialog.Builder(getContext());
                alert.setTitle("是否退出登录");
                alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Toast.makeText(getActivity(),"退出成功", Toast.LENGTH_SHORT).show();
                    }
                });
                alert.setNegativeButton("取消", null);
                alert.show();
            }
        });
        return view;
    }

}


