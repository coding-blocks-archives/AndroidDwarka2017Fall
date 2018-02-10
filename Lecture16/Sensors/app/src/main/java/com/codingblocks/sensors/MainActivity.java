package com.codingblocks.sensors;

import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    public static final String TAG = "MainActivity";
    ConstraintLayout constraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SensorManager sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);

        List<Sensor> sensors = sensorManager.getSensorList(Sensor.TYPE_ALL);
        constraintLayout = findViewById(R.id.rootLayout);

        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
//        Sensor sensor = sensorManager.getDefaultSensor(Sensor.TYPE_GRAVITY);
        
        sensorManager.registerListener(this, sensor, SensorManager.SENSOR_DELAY_UI);

//        for (int i = 0; i < sensors.size(); i++){
//            Sensor s = sensors.get(i);
//
//        }
        Log.d(TAG, "Number of sensors: " + sensors.size());

        for (Sensor s : sensors) {
            Log.d(TAG, "------------------------------------------------------");
            Log.d(TAG, "Sensor Name: " + s.getName());
            Log.d(TAG, "Sensor ID: " + s.getId());
            Log.d(TAG, "Sensor Vendor: " + s.getVendor());
            Log.d(TAG, "Sensor Type: " + s.getType());
            Log.d(TAG, "Sensor Version: " + s.getVersion());
            Log.d(TAG, "Sensor Power: " + s.getPower());
            Log.d(TAG, "Sensor Range: " + s.getMaximumRange());
            Log.d(TAG, "Sensor Min Delay : " + s.getMinDelay());
            Log.d(TAG, "Sensor Max Delay: " + s.getMaxDelay());
            Log.d(TAG, "------------------------------------------------------");
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        //register the sensor
    }

    @Override
    protected void onStop() {
        super.onStop();
        //unregister the sensor
//        sensorManager.unregisterListener(this);

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "onSensorChanged: " + event.values[0]);
        Log.d(TAG, "onSensorChanged: " + event.timestamp);
        Log.d(TAG, "onSensorChanged: " + event.accuracy);

//        int red = (int) (event.values[0] * 255 / 9.8);
//        int green = (int) (event.values[1] * 255 / 9.8);
//        int blue = (int) (event.values[2] * 255 / 9.8);
//
//        constraintLayout.setBackgroundColor(Color.rgb(Math.abs(red), Math.abs(green), Math.abs(blue)));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
