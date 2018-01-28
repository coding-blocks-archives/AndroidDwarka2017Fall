package com.codingblocks.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create a shared preferences file if it doesn't exists with the PRIVATE Visibility
        SharedPreferences sharedPreferences = getSharedPreferences("MyPreferences",MODE_PRIVATE);

        //Read data stored in the above xml
        Boolean isLoggedin = sharedPreferences.getBoolean("IS_LOGGED_IN",false);

        Toast.makeText(this, "" + isLoggedin, Toast.LENGTH_SHORT).show();

        //Get access to the editor to write data to the above xml
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putBoolean("IS_LOGGED_IN",true);
        editor.putInt("NUMBER",5);

        //Sync in nature, used to save the edits made above
        editor.apply();

        //Async in nature, does the same job as apply()
        editor.commit();

    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void scheduleJob(View view) {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);

        ComponentName componentName = new ComponentName(this, MyService.class);

        JobInfo jobInfo = new JobInfo.Builder(123, componentName)
                .setMinimumLatency(10 * 60 * 1000)
                .setOverrideDeadline(15 * 60 * 1000)
                .build();

        if (jobScheduler != null) {
            jobScheduler.schedule(jobInfo);
        }


    }
}
