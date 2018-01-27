package com.example.tanishqsaluja.broadcasting;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    BroadcastReceiver br;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
     //   ((TextView) findViewById(R.id.textview)).setText(i.getStringExtra("TEST"));
    }

    @Override
    protected void onStart() {
        super.onStart();
        br = new MyReceiver();
        IntentFilter intentFilter = new IntentFilter(Intent.ACTION_POWER_CONNECTED);
        registerReceiver(br, intentFilter);
    }


    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(br);
    }
}
