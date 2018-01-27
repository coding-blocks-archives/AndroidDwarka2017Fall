package com.zubia.newsworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    public static ArrayList<NewsDetails> newsArrayList=new ArrayList<>();
    public NewsAdapter newsAdapter;
    String baseUrl="http://starlord.hackerearth.com/newsjson";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView= (RecyclerView) findViewById(R.id.recView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        newsAdapter = new NewsAdapter(this,newsArrayList);
        recyclerView.setAdapter(newsAdapter);

        FetchNews fetchNews=new FetchNews(this,newsAdapter,newsArrayList);
        fetchNews.execute(baseUrl);
    }
}
