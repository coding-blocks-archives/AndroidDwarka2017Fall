package com.example.tanishqsaluja.dynamicbroadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    ProgressBar progressBar;
    BroadcastReceiver broadcastReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.textView);
        progressBar=findViewById(R.id.progressBar);
    }

    @Override
    protected void onStart() {
        super.onStart();
        //Intent filter is what we receive from OS
        //we create a BroadcastReceiver of BatteryLevel
        broadcastReceiver=new BatteryLevel();
        IntentFilter intentFilter=new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(broadcastReceiver,intentFilter);
        //Now we have write the function of onReceive() of BatteryLevel BroadcastReceiver
        //i.e what the receiver will do when the intent is received via intent filter
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(broadcastReceiver);
    }
    //Now lets create a broadcast receiver
    private class BatteryLevel extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);
            textView.setText(""+level);
            progressBar.setProgress(level);
        }
    }
}
