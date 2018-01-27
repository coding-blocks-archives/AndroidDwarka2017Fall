package com.zubia.mymovieworld;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements Callback, RecyclerViewAdapter.ListItemClickListener {
    RecyclerView recyclerView;
    String mApiKey = ApiKey.key;
    Context context;
    String popularMovieUrl = "http://api.themoviedb.org/3/movie/popular?api_key=" + mApiKey;
    String topRatedMovieUrl = "http://api.themoviedb.org/3/movie/top_rated?api_key=" + mApiKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));

        final OkHttpClient client = new OkHttpClient();
        final Request request = new Request.Builder()
                .url(popularMovieUrl)
                .build();
        client.newCall(request).enqueue(MainActivity.this);

    }

    @Override
    public void onFailure(Call call, IOException e) {
        Toast.makeText(context, "Failed Loading", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResponse(Call call, Response response) throws IOException {

        ArrayList<MovieList> movies=new ArrayList<>();
        final String s = response.body().string();
        try {
            movies = parseJson(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        final RecyclerViewAdapter recylerViewAdapter = new RecyclerViewAdapter(MainActivity.this, movies,MainActivity.this);


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                recyclerView.setAdapter(recylerViewAdapter);

            }
        });




    }

    public ArrayList<MovieList> parseJson(String s) throws JSONException {
        ArrayList<MovieList> movies = new ArrayList<>();
        JSONObject jsonObject = null;
        jsonObject = new JSONObject(s);

        JSONArray jsonArray=null;
        jsonArray = jsonObject.getJSONArray("results");
        for (int i = 0; i < jsonArray.length(); i++) {

            jsonObject = (JSONObject) jsonArray.get(i);

            String imgPath = jsonObject.getString("poster_path");
            String title = jsonObject.getString("original_title");
            String releaseDate = jsonObject.getString("release_date");
            String rating = jsonObject.getString("vote_average");
            String overview = jsonObject.getString("overview");
           // String runtime=jsonObject.getString("runtime");

            MovieList movie = new MovieList(imgPath, title, rating, releaseDate,overview,);
            movies.add(movie);
        }

        return movies;
    }

    @Override
    public void onClick(int position, MovieList movie) {
        Intent intent = new Intent(this, DetailActivity.class);

        intent.putExtra("imgUrl","http://image.tmdb.org/t/p/w185/"+movie.getImgPath());

        intent.putExtra("rating",movie.getRating());
        intent.putExtra("overview",movie.getOverview());
        intent.putExtra("release",movie.getReleaseDate());
        intent.putExtra("title",movie.getTitle());
        startActivity(intent);
    }
}
