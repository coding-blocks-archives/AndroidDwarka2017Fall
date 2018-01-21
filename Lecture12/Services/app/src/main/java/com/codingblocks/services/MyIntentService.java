package com.codingblocks.services;

import android.app.IntentService;
import android.app.Notification;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

/**
 * Created by harshit on 21/01/18.
 */

public class MyIntentService extends IntentService {

    @Override
    public void onDestroy() {
        Log.e("TAG", "onDestroy: ");
        super.onDestroy();
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     */
    //Create an empty constructor and pass in the class name to Super class (Used for inter process communication)
    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        //IntentService runs on a background thread by default
//
        Notification notification = new NotificationCompat.Builder(this, "test")
                .setContentTitle("Hello from Foreground Service")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

        //Start a foreground service
        startForeground(12345, notification);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Log.e("TAG", "onHandleIntent: completed");

        //Stop the foreground
        stopForeground(false);
    }

}
