package com.codingblocks.githubapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements Callback {

    public static String BASE_URL = "https://api.github.com/search/";
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = findViewById(R.id.editText);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        final OkHttpClient client = new OkHttpClient();

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
    public void onResponse(Call call, final Response response) throws IOException {
//        Log.e("TAG", "onResponse: " + response.body().string());
        final String s = response.body().string();

        Gson gson = new Gson();
        com.codingblocks.githubapp.Response myResponse = gson.fromJson(s, com.codingblocks.githubapp.Response.class);


//        String anotherString = response.body().string(); will crash since response implements a closable
//        ArrayList<GithubUser> githubUsers = new ArrayList<>();
//        try {
//            githubUsers = parseJson(s);
//
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
        final GithubAdapter githubAdapter = new GithubAdapter(myResponse.getItems(), this);

        recyclerView.post(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(githubAdapter);
            }
        });
    }


//    public ArrayList<GithubUser> parseJson(String s) throws JSONException {
//
//        ArrayList<GithubUser> users = new ArrayList<>();
//
//        JSONObject jsonObject = new JSONObject(s);
//
//        JSONArray jsonArray = jsonObject.getJSONArray("items");
//        //Get the jsonArray
//        for (int i = 0; i < jsonArray.length(); i++) {
//            JSONObject currentUser = jsonArray.getJSONObject(i);
//
//            String login = currentUser.getString("login");
//            String avatar_url = currentUser.getString("avatar_url");
//            String url = currentUser.getString("html_url");
//            Double score = currentUser.getDouble("score");
//
//            GithubUser githubUser = new GithubUser(login, avatar_url, url, score);
//            users.add(githubUser);
//        }
//        //Loop through the JsonArray
//
//        //inside the loop, create a new githubUser object
//
//        //Add it to the arraylist
//        Log.e("TAG", "parseJson: " + users.size());
//        return users;
//    }

}
