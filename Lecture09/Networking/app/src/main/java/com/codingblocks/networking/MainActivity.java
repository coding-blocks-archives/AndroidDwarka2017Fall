package com.codingblocks.networking;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);

        Button button = findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new NetworkAsyncTask().execute(editText.getText().toString());
            }
        });

    }

    class NetworkAsyncTask extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... strings) {
            String string = strings[0];
            URL url;
            HttpURLConnection httpURLConnection = null;
            try {
                url = new URL(string);
                httpURLConnection = (HttpURLConnection) url.openConnection();

                //InputStreamReader to read from the cache file that's stored with the downloaded data
                InputStream inputStream = httpURLConnection.getInputStream();

                Scanner scanner = new Scanner(inputStream);

                //This delimiter means that the scanner will read the entire file content in a single go
                scanner.useDelimiter("\\A");

                //Check to see if there is any content in the downloaded file
                boolean hasInput = scanner.hasNext();
                String response = "";
                if (hasInput) {
                    response = scanner.next();
                }
                return response;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (httpURLConnection != null)
                    httpURLConnection.disconnect();
            }
            return "Failed to load";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            textView.setText(s);
//            try {
//                JSONObject responseObject = new JSONObject(s);
//                JSONArray jsonArray = responseObject.getJSONArray("items");
//
//                JSONObject zerothObject = jsonArray.getJSONObject(0);
//
//                String url = zerothObject.getString("url");
//                String login = zerothObject.getString("login");
//                String avatar = zerothObject.getString("avatar_url");
//                Double score = zerothObject.getDouble("score");
//
//
//                GithubUser githubUser = new GithubUser(login,1,avatar,score);
//
//
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }

        }
    }
}













