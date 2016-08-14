package org.example.xinda_05.my;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.example.xinda_05.user.User_Info_change;
import org.example.xinda_05.user.User_login;
import org.example.xinda_05.util.SharedPreferences.SharedPreferencesUtil;

/**
 * Created by Administrator on 2016/8/10.
 */
public class My_login_headFragment extends Fragment {

    private View view;
    private LinearLayout user_intent_layout;
    private TextView My_personal_title_text;
    private SharedPreferencesUtil sp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=LayoutInflater.from(getActivity()).inflate(R.layout.my_personal_head_layout,null);

        sp=new SharedPreferencesUtil(getActivity());

        user_intent_layout= (LinearLayout) view.findViewById(R.id.user_intent_layout);
        My_personal_title_text= (TextView) view.findViewById(R.id.My_personal_title_text);


        user_intent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sp.queryLogin("Login").equals("1")){
                    Intent intent=new Intent(getContext(), User_Info_change.class);
                    intent.putExtra("tel",My_personal_title_text.getText());
                    getActivity().startActivity(intent);
                }else{
                    Intent intent=new Intent(getContext(),User_login.class);
                    getActivity().startActivity(intent);
                }
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(sp.queryLogin("Login").equals("1")){
            My_personal_title_text.setText(sp.queryLogin("User"));
        }else{
            My_personal_title_text.setText("请点击登录");
        }
    }

    public void changeText(String str){
        My_personal_title_text.setText(str);
    }
}
