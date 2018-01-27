package com.example.tanis.newsus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by tanis on 1/20/2018.
 */

public class GeneralActivity extends AppCompatActivity {
    CardView abc,bbc,bleacher,cnn,guardian;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.general_news);
        abc=findViewById(R.id.abcnews);
        bbc=findViewById(R.id.bbc);
        bleacher=findViewById(R.id.br);
        cnn=findViewById(R.id.cnn);
        guardian=findViewById(R.id.tg);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GeneralActivity.this,MainActivity.class);
                intent.putExtra("news","https://newsapi.org/v2/top-headlines?sources=abc-news&apiKey=e0322279ec2b4440b84cf4b9c8d2d348");
                startActivity(intent);///save the api key in R.string seperately and dont push that on github
            }
        });
        bbc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GeneralActivity.this,MainActivity.class);
                intent.putExtra("news","https://newsapi.org/v2/top-headlines?sources=bbc-news&apiKey=e0322279ec2b4440b84cf4b9c8d2d348");
                startActivity(intent);
            }
        });
        bleacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GeneralActivity.this,MainActivity.class);
                intent.putExtra("news","https://newsapi.org/v2/top-headlines?sources=bleacher-report&apiKey=e0322279ec2b4440b84cf4b9c8d2d348");
                startActivity(intent);
            }
        });
        cnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GeneralActivity.this,MainActivity.class);
                intent.putExtra("news","https://newsapi.org/v2/top-headlines?sources=cnn&apiKey=e0322279ec2b4440b84cf4b9c8d2d348");
                startActivity(intent);
            }
        });
        guardian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(GeneralActivity.this,MainActivity.class);
                intent.putExtra("news","https://newsapi.org/v2/top-headlines?sources=the-guardian-uk&apiKey=e0322279ec2b4440b84cf4b9c8d2d348");
                startActivity(intent);
            }
        });
    }
}
