package com.example.tanishqsaluja.servicespartone;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import java.util.Random;

/**
 * Created by tanishqsaluja on 27/1/18.
 */

public class MyService extends Service {
    private final int min = 0;
    private final int max = 100;
    private boolean isRandomNumberGeneratorOn = false;
    private int randomNumber;
    private int mynum = 0;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Write the task to be done before stopping a service
        //    Toast.makeText(this,"Heya!",Toast.LENGTH_SHORT).show();
        //    Log.e("TEST","Hello from onStartCommand: "+Thread.currentThread().getId());
        isRandomNumberGeneratorOn = true;
        new Thread(new Runnable() {
            @Override
            public void run() {
                startRandomNumberGenerator();
            }
        }).start();
        //We infer that services run on the same UI thread as that of MainActivity and
        //, for a long running task we could possibly get an ANR
        //, so by 'SERVICE' we cannot say that it would run on a separate thread

        //So write all the processes of background service in a separate thread
/*

        new Thread(new Runnable() {
            @Override
            public void run() {
                //write all processes in this thread
                Log.e("TEST","Hello from onStartCommand: "+Thread.currentThread().getId());
            }
        });
*/

        // stopSelf();//the only way to stop a service
        // Quick Update we can also do it explicitly

        return START_STICKY;
    }

    @Override
    //this method is only called if stopSelf() method is called in onStartCommand()
    public void onDestroy() {
        super.onDestroy();
        Log.e("TEST", "Service was destroyed.");
        stopRandomeNumberGenerator();
    }

    class MyServiceBinder extends Binder {
        public MyService getService() {
            return MyService.this;
        }
    }

    private IBinder myBinder = new MyServiceBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("TEST", "In onBind: ");
        return myBinder;//it should return an interface of this current MyService
    }

    private void startRandomNumberGenerator() {
        while (isRandomNumberGeneratorOn) {
            try {
                Thread.sleep(1000);
                if (isRandomNumberGeneratorOn) {
                    mynum++;
                    randomNumber = new Random().nextInt(max) + min;
                    Log.e("TEST", "Random number generated is : " + mynum);
                }
            } catch (InterruptedException e) {
                Log.e("TEST", "Thread interrupted");
                e.printStackTrace();
            }

        }
    }

    private void stopRandomeNumberGenerator() {
        isRandomNumberGeneratorOn = false;
    }

    // Not use for now
    private int getRandomNumber() {
        return randomNumber;
    }

    private int getMynum() {
        return mynum;
    }

}
