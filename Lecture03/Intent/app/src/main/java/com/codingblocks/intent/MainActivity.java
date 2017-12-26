package com.codingblocks.intent;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editTextName);
    }

    public void launchDetailActivity(View view) {
        String input = editText.getText().toString();
//        Intent i = new Intent(this,DetailActivity.class);
//        i.putExtra("NAME",input);
//        startActivity(i);

//        Intent intent = new Intent();
//        intent.setAction(Intent.ACTION_VIEW);
//        intent.setData(Uri.parse(input));
//        startActivity(intent);


        Intent myIntent = new Intent();
        myIntent.setAction("blahblah");
        myIntent.setData(Uri.parse("fgsdikfbsdifb"));

        myIntent.putExtra("NAME",input);

        startActivity(myIntent);
    }

}
