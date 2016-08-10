package org.example.xinda_05.my;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


/**
 * Created by CYLL on 2016/8/9.
 */
public class My_HomePageFragment extends Fragment{
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
                    persintent.setClass(getActivity(),My_releaseActivity.class);
                }
            }
            startActivity(persintent);
        }
    };
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.my_homepage_layout,null);
        LinearLayout layoutuser= (LinearLayout) view.findViewById(R.id.user_intent_layout);
        LinearLayout perlayout1= (LinearLayout) view.findViewById(R.id.person_mypublish_intent);

        layoutuser.setOnClickListener(personclick);
        perlayout1.setOnClickListener(personclick);
        layoutuser.setTag(0);
        perlayout1.setTag(1);
        return view;

    }
}
