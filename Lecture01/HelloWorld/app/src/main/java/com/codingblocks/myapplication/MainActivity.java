package com.codingblocks.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Person person = new Person("Harshit",22,"Janakpuri");

        person.getAddress();
        person.getAge();

        Person p = new Person();



    }
}
