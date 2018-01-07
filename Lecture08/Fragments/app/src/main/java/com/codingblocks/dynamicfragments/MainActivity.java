package com.codingblocks.dynamicfragments;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    int countA = 0, countB = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        getSupportFragmentManager().beginTransaction().add(R.id.container,new FragmentA(),"FRAGMENT_A").commit();
        Button a = findViewById(R.id.idBtnA);
        final Button b = findViewById(R.id.idBtnB);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countA++;
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                FragmentA fragmentA = new FragmentA();
                Bundle bundle = new Bundle();
                bundle.putInt("COUNT", countA);
                fragmentA.setArguments(bundle);

                fragmentTransaction.replace(R.id.container,fragmentA , "FRAGMENT_A");

                fragmentTransaction.commit();
            }
        });

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countB++;
                FragmentManager fragmentManager = getSupportFragmentManager();

                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                fragmentTransaction.replace(R.id.container, new FragmentB(countB), String.valueOf(countB));

                fragmentTransaction.commit();
            }
        });


    }
}
