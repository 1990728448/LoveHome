package org.example.xinda_05.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.example.xinda_05.my.My_Jump.My_MessageActivity;
import org.example.xinda_05.my.My_Jump.My_StatementActivitiy;
import org.example.xinda_05.my.My_Jump.My_aboutActivity;
import org.example.xinda_05.my.My_Jump.My_collectionActivity;
import org.example.xinda_05.my.My_Jump.My_releaseActivity;
import org.example.xinda_05.my.My_Jump.My_thedraftActivity;


/**
 * Created by CYLL on 2016/8/9.
 */
public class My_personal_HomePageFragment extends Fragment {
    @Nullable
     LinearLayout lat1,lat2,lat3,lat4,lat5,lat6,lat7;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.my_homepage_layout, null);
        lat1=(LinearLayout) view.findViewById(R.id.person_mypublish_intent);
        lat2=(LinearLayout)view.findViewById(R.id.person_mypublish_intent1);
        lat3=(LinearLayout)view.findViewById(R.id.person_mypublish_intent2);
        lat4=(LinearLayout)view.findViewById(R.id.person_mypublish_intent3);
        lat5=(LinearLayout)view.findViewById(R.id.person_mypublish_intent4);
        lat6=(LinearLayout)view.findViewById(R.id.person_mypublish_intent5);
        lat7=(LinearLayout)view.findViewById(R.id.person_mypublish_intent7);
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
//                Intent it7=new Intent(getActivity(),My_pwdActivity.class);
//                getActivity().startActivity(it7);
            }
        });
        return view;
    }

}


