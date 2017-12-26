package com.codingblocks.simplelistview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> numbersList = new ArrayList<>();

        ListView listView = findViewById(R.id.listView);

        for (int i = 0; i < 100; i++) {
            numbersList.add(String.valueOf(i));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.item_row,
                R.id.textView,
                numbersList);

        listView.setAdapter(arrayAdapter);

    }
}
