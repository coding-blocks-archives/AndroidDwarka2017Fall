package com.zubia.newsworld;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.telecom.Call;

import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Type;
import java.util.ArrayList;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by shahabkhan on 1/27/18.
 */

public class FetchNews extends AsyncTask<String,Void,ArrayList<NewsDetails>> {
    public static final String TAG="TAG";
    Context context;
    NewsAdapter newsAdapter;
    ArrayList<NewsDetails> newsArrayList;
    Handler handler=new Handler(Looper.getMainLooper());;

    public FetchNews(Context context, NewsAdapter newsAdapter, ArrayList<NewsDetails> newsArrayList) {
        this.context = context;
        this.newsAdapter = newsAdapter;
        this.newsArrayList = newsArrayList;
    }


    //    ProgressDialog progressDialog=new ProgressDialog(context);
    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected ArrayList<NewsDetails> doInBackground(String... strings) {
        OkHttpClient okHttpClient=new OkHttpClient();
        final ArrayList<NewsDetails> retVal=new ArrayList<>();
        Request request=new Request.Builder().url(strings[0]).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result=response.body().string();
                Gson gson=new Gson();
                NewsDetails[] newsDetails=gson.fromJson(result, new GenericArrayType() {
                    @Override
                    public Type getGenericComponentType() {
                        return NewsDetails.class;
                    }
                });
                for(int i=0;i<newsDetails.length;i++){
                    newsArrayList.add(newsDetails[i]);
                }


                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        newsAdapter.notifyDataSetChanged();
                    }
                });
            }
        });

        return retVal;
    }

    @Override
    protected void onProgressUpdate(Void... values) {

        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(ArrayList<NewsDetails> newsDetailses) {
        super.onPostExecute(newsDetailses);
    }

    @Override
    protected void onCancelled(ArrayList<NewsDetails> newsDetailses) {

        super.onCancelled(newsDetailses);
    }
}