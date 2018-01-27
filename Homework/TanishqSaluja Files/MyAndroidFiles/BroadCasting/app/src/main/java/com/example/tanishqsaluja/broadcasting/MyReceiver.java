package com.example.tanishqsaluja.broadcasting;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Created by tanishqsaluja on 26/1/18.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i=new Intent(context,AnotherActivity.class);//Here the context is the OS
        i.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("TEST", "TEST");
        context.startActivity(i);
    }
}
