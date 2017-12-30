package com.codingblocks.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by harshit on 26/12/17.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent i = getIntent();

        final String receivedValue = i.getStringExtra("NAME");

//        Uri uri = i.getData();
//        i.getIntExtra("INTINPUT",0);

        TextView textView = findViewById(R.id.textView);
        textView.setText(receivedValue);

//        WebView webView = findViewById(R.id.webView);
//        webView.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
////                view.loadUrl(receivedValue);
//                return true;
//            }
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//                super.onPageStarted(view, url, favicon);
//                view.loadUrl(receivedValue);
//            }
//        });
//        webView.loadUrl(receivedValue);
    }
}
