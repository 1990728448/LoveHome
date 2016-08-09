package org.example.xinda_05.homepager.fragment.homepager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.example.xinda_05.homepager.R;


/**
 * Created by Jerry Mouse on 2016/8/9.
 */
public class Home_pager_title_Fragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_pager_title_layout,null);
        return view;
    }
}
