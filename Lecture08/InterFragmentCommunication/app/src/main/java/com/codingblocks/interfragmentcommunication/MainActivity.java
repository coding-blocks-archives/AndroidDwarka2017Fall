package com.codingblocks.interfragmentcommunication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements Communicator{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerA, new FragmentA()).commit();

    }

    @Override
    public void handleClick(String name) {
        FragmentB b = new FragmentB();
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        b.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.containerB, b)
                .commit();
    }
}
