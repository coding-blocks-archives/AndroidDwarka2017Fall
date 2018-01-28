package com.example.tanishqsaluja.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Button add,subtract;
    int count=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=findViewById(R.id.tv);
        add=findViewById(R.id.buttonadd);
        subtract=findViewById(R.id.buttonsubtract);
        //For orientation purpose
        if(savedInstanceState!=null){
            textView.setText(savedInstanceState.getInt("count")+"");
        }
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textView.setText(count+"");
            }
        });
        subtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                textView.setText(count+"");
            }
        });
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("count",count);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        count=savedInstanceState.getInt("count");
    }
}
