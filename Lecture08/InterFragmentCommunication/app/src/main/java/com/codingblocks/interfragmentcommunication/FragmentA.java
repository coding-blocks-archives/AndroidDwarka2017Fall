package com.codingblocks.interfragmentcommunication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by harshit on 07/01/18.
 */

public class FragmentA extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_a, container, false);
        final EditText etA = v.findViewById(R.id.etFragA);
        Button button = v.findViewById(R.id.btnFragA);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Communicator communicator = (Communicator) getActivity();
                communicator.handleClick(etA.getText().toString());
            }
        });

        return v;
    }
}
