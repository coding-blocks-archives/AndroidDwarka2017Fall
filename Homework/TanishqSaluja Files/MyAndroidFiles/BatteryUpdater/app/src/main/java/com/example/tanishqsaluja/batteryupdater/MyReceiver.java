package com.example.tanishqsaluja.batteryupdater;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by tanishqsaluja on 26/1/18.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context,MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.setAction(intent.getAction());
        context.startActivity(i);
    }
}
