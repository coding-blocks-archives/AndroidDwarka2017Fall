package com.example.varun.batterynotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;

import static android.content.Context.BATTERY_SERVICE;

/**
 * Created by Varun on 1/20/2018.
 */

public class Charging extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context,MainActivity.class);
        
        int a = BatteryManager.BATTERY_PLUGGED_AC;
        Log.e("TAG","ac= "+ a); //1
        int b=BatteryManager.BATTERY_PLUGGED_USB;
        Log.e("TAG","usb= "+b);  //2

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        if(b==2) {
            i.putExtra("status", 1);
        }else if(a==1)
            i.putExtra("status",3);
        context.startActivity(i);
    }
}
