package com.example.varun.batterynotify;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.BatteryManager;
import android.os.Vibrator;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        Integer a=0;
    TextView textView;
    TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent i =getIntent();
        a= i.getIntExtra("status",0);

        BatteryManager bm = (BatteryManager)getSystemService(BATTERY_SERVICE);
        int batLevel = 0;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            batLevel = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        }

        if(a==1) {
            setContentView(R.layout.activity_main);
            textView = findViewById(R.id.textView);
            textView1 = findViewById(R.id.textView2);
            Vibrator vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long pattern[]={0,100,200,300,400};
            textView1.setText("Current Battery Level : "+ batLevel+"%");
            textView.setText("via USB");
            vibrator.vibrate(pattern,-1);
        }
        else if(a==1) {
            setContentView(R.layout.activity_main);
            Vibrator vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            long pattern[]={0,100,200,300,400};
            TextView textView = findViewById(R.id.textView);
            textView.setText("via AC");
            TextView textView2 = findViewById(R.id.textView2);
            textView2.setText("Current Battery level : "+batLevel+"%");
            vibrator.vibrate(pattern,-1);
        }
        else if(a==2) {

                setContentView(R.layout.discharging);
          /*  ImageButton airplane = findViewById(R.id.imageButton);
            airplane.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean isEnabled = Settings.System.getInt(
                            getContentResolver(),
                            Settings.System.AIRPLANE_MODE_ON, 0) == 1;

                    Settings.System.putInt(
                            getContentResolver(),
                            Settings.System.AIRPLANE_MODE_ON, isEnabled ? 0 : 1);

                }
            });*/
            Vibrator vibrator=(Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
            vibrator.vibrate(300);
        }
    }
}
