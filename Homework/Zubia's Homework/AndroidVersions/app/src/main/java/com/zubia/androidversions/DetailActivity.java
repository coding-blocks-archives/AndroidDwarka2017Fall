package com.zubia.androidversions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;



public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        final Intent i = getIntent();
        TextView Name = findViewById(R.id.Name);
        TextView Version = findViewById(R.id.Version);
        TextView APIlevel = findViewById(R.id.APIlevel);
        TextView RelDate = findViewById(R.id.RelDate);
        ImageView Pic = findViewById(R.id.Pic);
        Button button = findViewById(R.id.Button);

        Name.setText(i.getStringExtra("Name"));
        Version.setText("Version : " + i.getStringExtra("Version"));
        APIlevel.setText("API Level : " + i.getIntExtra("APIlevel",0));
        RelDate.setText("Release Date : " + i.getStringExtra("RelDate"));
        Pic.setImageResource(i.getIntExtra("Pic",0));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(i.getStringExtra("Page")));
                startActivity(intent);
            }
        });
    }
}
