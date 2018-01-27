package com.example.aryam.userfetcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

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

public class MainActivity extends AppCompatActivity implements Callback {

    public static String BASE_URL = "https://api.github.com/search/";
    EditText editText;
    RecyclerView recyclerView;
    com.rbrooks.indefinitepagerindicator.IndefinitePagerIndicator indefinitePagerIndicator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        editText = findViewById(R.id.edit_text);
        ImageView button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.contentRV);
        indefinitePagerIndicator = findViewById(R.id.recyclerview_pager_indicator);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);
        final OkHttpClient client = new OkHttpClient();

        button.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputString = editText.getText().toString();
                Request request = new Request.Builder()
                        .url(BASE_URL + "users?q=" + inputString)
                        .build();
                client.newCall(request).enqueue(MainActivity.this);

            }
        });
    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {
        final String responseData = response.body().string();
        ArrayList<User> userArrayList = new ArrayList<>();
        try {
            userArrayList = parseJson(responseData);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final UserAdapter userAdapter = new UserAdapter(userArrayList,this);
        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(userAdapter);
                indefinitePagerIndicator.attachToRecyclerView(recyclerView);
            }
        });
    }
    public ArrayList<User> parseJson(String response) throws JSONException {
        ArrayList<User> users = new ArrayList<>();
        JSONObject json = new JSONObject(response);
        JSONArray jsonArray = json.getJSONArray("items");
        for(int i = 0; i < jsonArray.length(); i++){
            String login = jsonArray.getJSONObject(i).getString("login");
            String avatar = jsonArray.getJSONObject(i).getString("avatar_url");
            String url = jsonArray.getJSONObject(i).getString("url");
            Double score = jsonArray.getJSONObject(i).getDouble("score");

            User user = new User(login,avatar,url,score);
            users.add(user);
        }
        return users;
    }
}
