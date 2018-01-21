package com.codingblocks.permissions;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.numberEditText);

        findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = ContextCompat.checkSelfPermission(getBaseContext(), Manifest.permission.CALL_PHONE);
                if (result == PackageManager.PERMISSION_GRANTED)
                    callPhone();
                else {
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.CALL_PHONE,
                                    Manifest.permission.WRITE_EXTERNAL_STORAGE},
                            123);
                }

            }
        });
    }

    public void callPhone() {
        Uri uri = Uri.parse("tel:" + editText.getText().toString());
        Intent i = new Intent(Intent.ACTION_CALL);
        i.setData(uri);
        startActivity(i);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 123) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                callPhone();
            }
        } else {
            Toast.makeText(this, "Please grant Call permission", Toast.LENGTH_SHORT).show();
        }
    }
}
