package com.codingblocks.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
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
        ((TextView) findViewById(R.id.textView)).setText(i.getStringExtra("TEST"));


        //All apps that register `MY_CUSTOM_ACTION` in their manifest will receive this Intent
        Intent intent = new Intent("MY_CUSTOM_ACTION");
//        sendBroadcast(intent);

        //Sends the broadcast only to the current Context's process
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent);

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
