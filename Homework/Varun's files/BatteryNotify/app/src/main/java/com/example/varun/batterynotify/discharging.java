package com.example.varun.batterynotify;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Varun on 1/21/2018.
 */

public class discharging extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context,MainActivity.class);
        i.setAction(intent.getAction());
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("status",2);
        context.startActivity(i);

    }
}
