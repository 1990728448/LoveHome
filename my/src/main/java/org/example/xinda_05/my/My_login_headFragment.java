package org.example.xinda_05.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import org.example.xinda_05.user.User_login;

/**
 * Created by Administrator on 2016/8/10.
 */
public class My_login_headFragment extends Fragment {

    LinearLayout user_intent_layout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=LayoutInflater.from(getActivity()).inflate(R.layout.my_personal_head_layout,null);

        user_intent_layout= (LinearLayout) view.findViewById(R.id.user_intent_layout);

        user_intent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getContext(),User_login.class);
                getActivity().startActivity(intent);
            }
        });

        return view;
    }
}
