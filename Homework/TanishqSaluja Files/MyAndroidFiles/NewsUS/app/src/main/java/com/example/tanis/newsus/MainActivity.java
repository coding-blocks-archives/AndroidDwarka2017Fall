package com.example.tanis.newsus;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {
    ArrayList<News> arrayList;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    public static String base="some random url";
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        recyclerView=findViewById(R.id.rv);
        swipeRefreshLayout=findViewById(R.id.swiperefresh);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        Intent intent=getIntent();
        base=intent.getStringExtra("news");
        //Using API's we can use some functionalities or data of software
               OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(base)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                progressBar.setVisibility(View.VISIBLE);
                String string=response.body().string();
                try {
                    Log.e("TEST","try");
                    arrayList=jsonParse(string);
                } catch (JSONException e) {
                    Log.e("TEST","catch");
                    e.printStackTrace();
                    Log.e("TEST",e.getMessage());
                }
                final NewsAdapter userAdapter=new NewsAdapter(MainActivity.this,arrayList);
                swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        recyclerView.post(new Runnable() {
                            @Override
                            public void run() {
                                recyclerView.setAdapter(userAdapter);
                            }
                        });
                    }
                    private void doYourUpdate() {
                        // TODO implement a refresh
                        swipeRefreshLayout.setRefreshing(true); // Disables the refresh icon
                    }
                });

            }
        });
        try {
            arrayList=jsonParse(base);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        NewsAdapter newsAdapter=new NewsAdapter(this,arrayList);
        recyclerView.setAdapter(newsAdapter);
    }
    private ArrayList<News> jsonParse(String s)throws JSONException{
        ArrayList<News> list=new ArrayList<>();
        try {
            JSONObject jsonObject = new JSONObject(s);
            JSONArray jsonArray = jsonObject.getJSONArray("articles");
            Log.e("TEST", "inside");
            Log.e("TEST", jsonArray.length() + "inside");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject current = jsonArray.getJSONObject(i);
                String title = current.getString("title");
                Log.e("TEST", current.getString("title"));
                String descrtiption = current.getString("description");
                String photo = current.getString("urlToImage");
                String more = current.getString("url");
                News news = new News(title, descrtiption, photo, more);
                Log.e("TEST", i + "inside");
                list.add(news);
            }
        }catch(JSONException e){
                e.printStackTrace();
            }

        Log.e("TEST",list.size()+"outside");
        return list;
    }
      /* OkHttpClient okHttpClient=new OkHttpClient();
        Request request=new Request.Builder()
                .url(base)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
//                progressBar.setVisibility(View.VISIBLE);
                String string=response.body().string();
                try {
                    Log.e("TEST","try");
                    arrayList=jsonParse(string);
                } catch (JSONException e) {
                    Log.e("TEST","catch");
                    e.printStackTrace();
                    Log.e("TEST",e.getMessage());
                }
                final NewsAdapter userAdapter=new NewsAdapter(MainActivity.this,arrayList);
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setAdapter(userAdapter);
                    }
                });
            }
        });*/

}
