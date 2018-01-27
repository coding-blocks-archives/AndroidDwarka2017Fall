package com.example.tanishqsaluja.fragment_viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by tanishqsaluja on 25/1/18.
 */

public class MyFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_main,container,false);
        int i = getArguments().getInt("POS");
        ((TextView)view.findViewById(R.id.tvFragment)).setText("" + i);
        return view;
    }
}
