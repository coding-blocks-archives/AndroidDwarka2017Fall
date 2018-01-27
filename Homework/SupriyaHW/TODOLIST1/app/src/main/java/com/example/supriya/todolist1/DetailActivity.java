package com.example.supriya.todolist1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Supriya on 1/7/2018.
 */

public class DetailActivity extends AppCompatActivity {
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailact);
        Intent intent =getIntent();
    }
}
