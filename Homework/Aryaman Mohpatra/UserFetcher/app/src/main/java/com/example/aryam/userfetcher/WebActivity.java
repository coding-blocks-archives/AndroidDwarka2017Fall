package com.example.aryam.userfetcher;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

/**
 * Created by aryam on 1/18/2018.
 */

public class WebActivity
        extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        getSupportActionBar().hide();
        WebView webView = findViewById(R.id.webView);
        String url = getIntent().getData().toString();
        webView.loadUrl(url);
    }
}
