package com.codingblocks.dynamicfragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by harshit on 07/01/18.
 */

public class FragmentA extends Fragment {

//    Student student;

//    public FragmentA() {
//    }

//    public FragmentA(int count) {
//        countA = count;
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a,container,false);
        TextView fragA = v.findViewById(R.id.tvFragA);
//        fragA.setText("" + student.getName);
        Bundle receivedBundle = getArguments();
        fragA.setText(receivedBundle.getInt("COUNT") + "");
        return v;
    }
}
