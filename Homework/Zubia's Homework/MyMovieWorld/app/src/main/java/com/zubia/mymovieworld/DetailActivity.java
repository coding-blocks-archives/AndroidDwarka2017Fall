package com.zubia.mymovieworld;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by shahabkhan on 1/20/18.
 */

public class DetailActivity extends AppCompatActivity {

    public String imgPath;
    public String title;
    public String rating;
    public String releaseDate;
    public String overview;
    public String runtime;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);


        Intent intent = getIntent();

        imgPath = intent.getStringExtra("imgUrl");
        title = intent.getStringExtra("title");
        rating = intent.getStringExtra("rating");
        overview = intent.getStringExtra("overview");
        releaseDate = intent.getStringExtra("release");
        //runtime=intent.getStringExtra("runtime");

        TextView tvtitle = (TextView) findViewById(R.id.tv_title);
        TextView tvrating = (TextView) findViewById(R.id.tv_rating);
        TextView tvoverview = (TextView) findViewById(R.id.tv_overview);
        TextView tvreleaseDate = (TextView) findViewById(R.id.tv_release_date);
        //TextView tvruntime=(TextView)findViewById(R.id.tv_duration);
        ImageView imgbanner = (ImageView) findViewById(R.id.imgv_poster_detail_activity);


        Picasso.with(this)
                .load(imgPath)
                .into(imgbanner);

        getSupportActionBar().setTitle("Movie Details");
        tvtitle.setText(title);
        tvrating.setText("Rating:"+rating);
        tvoverview.setText(overview);
        tvreleaseDate.setText(releaseDate);
        //tvruntime.setText(runtime);

    }
}