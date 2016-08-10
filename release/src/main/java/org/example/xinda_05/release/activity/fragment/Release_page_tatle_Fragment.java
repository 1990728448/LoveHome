package org.example.xinda_05.release.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.example.xinda_05.release.R;

/**
 * Created by Administrator on 2016/8/10 0010.
 */
public class Release_page_tatle_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.release_pager_tatle_layout,null);
        return view;
    }
}
