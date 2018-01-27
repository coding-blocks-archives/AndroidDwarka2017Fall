package com.example.supriya.todolist1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

/**
 * Created by Supriya on 1/7/2018.
 */

public class Fragment extends android.support.v4.app.Fragment {
    String a="Done";
    String b="To be done";
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment,container,false);
        EditText et1=v.findViewById(R.id.et1);
        et1.setText("");
        return v;
    }
}
