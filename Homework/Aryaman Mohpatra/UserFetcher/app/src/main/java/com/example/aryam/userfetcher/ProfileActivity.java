package com.example.aryam.userfetcher;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.URI;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by aryam on 1/14/2018.
 */

public class ProfileActivity extends AppCompatActivity implements Callback{
    de.hdodenhof.circleimageview.CircleImageView circleImageView;
    TextView name;
    TextView login;
    TextView bio;
    TextView followers;
    TextView following;
    TextView publicRepos;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
        getSupportActionBar().hide();
        circleImageView = findViewById(R.id.profile_image);
        name = findViewById(R.id.name);
        login = findViewById(R.id.login);
        bio = findViewById(R.id.bio);
        followers = findViewById(R.id.followers);
        following = findViewById(R.id.following);
        publicRepos = findViewById(R.id.publicRepos);

        final OkHttpClient client = new OkHttpClient();
        final String inputString = getIntent().getStringExtra("USER");
        Request request = new Request.Builder()
                .url(inputString)
                .build();
        client.newCall(request).enqueue(ProfileActivity.this);

    }

    @Override
    public void onFailure(Call call, IOException e) {

    }

    @Override
    public void onResponse(Call call, final Response response) throws IOException {
        final Gson gson = new Gson();
        final SingleUser singleUser = gson.fromJson(response.body().string(),SingleUser.class);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Picasso.with(circleImageView.getContext()).load(singleUser.getAvatar_url()).into(circleImageView);
                circleImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(ProfileActivity.this,WebActivity.class);
                        intent.setData(Uri.parse(singleUser.getHtml_url()));
                        startActivity(intent);
                    }
                });
                name.setText(singleUser.getName());
                login.setText(singleUser.getLogin());
                bio.setText(singleUser.getBio());
                followers.setText("Followers " + singleUser.getFollowers());
                following.setText("Following " + singleUser.getFollowing());
                publicRepos.setText("Repositories " + singleUser.getPublic_repos());

            }
        });
    }
}
