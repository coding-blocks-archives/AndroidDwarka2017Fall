package com.codingblocks.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by harshit on 28/01/18.
 */

public class MyService extends JobService {

    @Override
    public boolean onStartJob(final JobParameters params) {
        Log.e("TAG", "onStartJob: ");
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

        //Stop the service here
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        //Don't reschedule the job, return true if you want to reschedule it with
        //the same params
        return false;
    }
}
