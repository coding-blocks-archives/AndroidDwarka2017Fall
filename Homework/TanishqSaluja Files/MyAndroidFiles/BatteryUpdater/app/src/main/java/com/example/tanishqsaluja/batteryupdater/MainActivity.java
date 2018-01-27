package com.example.tanishqsaluja.batteryupdater;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView chargingImage;
    TextView chargingText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        chargingImage = (ImageView) findViewById(R.id.chargingIcon);
        chargingText = (TextView) findViewById(R.id.chargingStatus);
        Intent i = getIntent();
        if (i.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            chargingImage.setImageResource(R.drawable.dis);
            chargingText.setText("DISCONNECTED");
        } else if (i.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            chargingImage.setImageResource(R.drawable.charging);
            chargingText.setText("CONNECTED");
        }
    }
}
