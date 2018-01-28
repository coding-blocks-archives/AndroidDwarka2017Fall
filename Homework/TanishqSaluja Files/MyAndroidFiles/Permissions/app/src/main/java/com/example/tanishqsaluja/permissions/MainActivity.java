package com.example.tanishqsaluja.permissions;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    FloatingActionButton floatingActionButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText=findViewById(R.id.et);
        floatingActionButton=findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //If your app needs a dangerous permission that was listed in the app manifest, it must ask the user to grant the permission.
                int permissionCheck= ContextCompat.checkSelfPermission(getBaseContext(), android.Manifest.permission.CALL_PHONE);
                if(permissionCheck == PackageManager.PERMISSION_GRANTED){
                    callPhone();
                }
                /*else if(ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                        android.Manifest.permission.CALL_PHONE)){

                    // Show an explanation to the user *asynchronously* -- don't block
                    // this thread waiting for the user's response! After the user
                    // sees the explanation, try again to request the permission.
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(MainActivity.this,"We need it for calling purpose.",Toast.LENGTH_SHORT);
                        }
                    });
                }*/
                // No explanation needed, we can request the permission.
                else{
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{android.Manifest.permission.CALL_PHONE,
                                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            123);
                }
            }
        });
    }
    public void callPhone(){
        Intent intent=new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel: "+editText.getText().toString()));
        startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // If request is cancelled, the result arrays are empty.
        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {//Also implies that the user selected Yes
                // permission was granted, yay! Do the
                // contacts-related task you need to do.
                callPhone();
            }
        } else {
            Toast.makeText(this, "Please grant Call permission", Toast.LENGTH_SHORT).show();
        }
    }
}
