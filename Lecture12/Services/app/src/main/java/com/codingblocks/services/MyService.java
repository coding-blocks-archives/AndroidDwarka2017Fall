package com.codingblocks.services;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by harshit on 21/01/18.
 */

public class MyService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e("TAG", "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Notification notification = new NotificationCompat.Builder(this, "test")
                .setContentTitle("Hello from Foreground Service")
                .setSmallIcon(R.mipmap.ic_launcher)
                .build();

        //Start a foreground service which ensures that the service isn't killed by the OS
        startForeground(12345, notification);
//        stopSelf();

        //Service by default runs from the thread it was started in, so delegating a long running task in another thread
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Sleep for 15 seconds
                    Thread.sleep(15000);
//                    Toast.makeText(MyService.this, "Countdown done", Toast.LENGTH_SHORT).show();
                    Log.e("TAG", "Countdown Done");

                    //After the task has been completed, send a broadcast
                    Intent i = new Intent("ACTION_START_ACTIVITY");
                    sendBroadcast(i);

                    //Stop the foreground service to save resources
                    stopForeground(true);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        //Will be called immediately after line 37, won't wait for the thread to complete
        Toast.makeText(this, "Started", Toast.LENGTH_SHORT).show();
        Log.e("TAG", "onStartCommand: ");
        //STICKY will restart the service if the OS kills it
        //Calling stopSelf will stop the service
//        stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("TAG", "onDestroy: ");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
