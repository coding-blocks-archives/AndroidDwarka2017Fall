package com.example.tanishqsaluja.servicespartone;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button start, stop;
    Intent startservice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //We now check the Id of thread(UI thread) on which the current thread is running
        Log.e("TEST", "Hello from MainActivity :" + Thread.currentThread().getId());
        start = findViewById(R.id.buttonstart);
        stop = findViewById(R.id.buttonstop);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startservice = new Intent(MainActivity.this, MyService.class);
                startService(startservice);
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //We cannot stop any service from inside the Activity ,
                // , we can only do it from inside the service class

                //Quick Update we can also change it explicitly here :
                stopService(startservice);

            }
        });
    }
}
