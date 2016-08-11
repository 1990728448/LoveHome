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
public class My_personal_HomePageFragment extends Fragment{
    @Nullable
    View.OnClickListener personclick=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int persintag = Integer.parseInt(view.getTag().toString());
            Intent persintent=new Intent();
            switch (persintag){
                case 0:{
                    persintent.setClass(getActivity(),My_releaseActivity.class);
                }
                case 1:{
                    persintent.setClass(getActivity(),My_thedraftActivity.class);
                }
                case 2:{
                    persintent.setClass(getActivity(), My_collectionActivity.class);
                }
                case 3:{
                    persintent.setClass(getActivity(),My_MessageActivity.class);
                }
                case 4:{
                    persintent.setClass(getActivity(), My_StatementActivitiy.class);
                }
                case 5:{
                    persintent.setClass(getActivity(), My_aboutActivity.class);
                }
            }
            startActivity(persintent);
        }
    };
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_homepage_layout,null);
       // LinearLayout perlayout1= (LinearLayout) view.findViewById(R.id.person_mypublish_intent);
        LinearLayout layoutuser= (LinearLayout) view.findViewById(R.id.user_intent_layout);
        layoutuser.setOnClickListener(personclick);
  //      perlayout1.setOnClickListener(personclick);
        layoutuser.setTag(0);
  //      perlayout1.setTag(1);
        return view;

    }
}
