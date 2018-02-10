package com.codingblocks.ads;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

public class MainActivity extends AppCompatActivity {

    InterstitialAd interstitialAd;
    RewardedVideoAd rewardedVideoAd;

    //    RelativeLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this,
                "ca-app-pub-9291391930070237~7036555957");

        setContentView(R.layout.activity_main);
        AdView adView = findViewById(R.id.adView);
//        adView.setAdUnitId("ca-app-pub-9291391930070237/9088004224");
        adView.loadAd(new AdRequest.Builder().build());
//        layout = findViewById(R.id.relativeLayout);
//
//        layout.addView(adView);


        interstitialAd = new InterstitialAd(this);

        interstitialAd.setAdUnitId("ca-app-pub-9291391930070237/3352106590");

        rewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);

        rewardedVideoAd.loadAd("ca-app-pub-3940256099942544/5224354917", new AdRequest.Builder().build());

//        interstitialAd.loadAd(new AdRequest.Builder().build());
    }

    public void showAd(View view) {
//        if (interstitialAd.isLoaded()) {
//        interstitialAd.loadAd(new AdRequest.Builder().build());
////        }
//
//        interstitialAd.setAdListener(new AdListener() {
//            @Override
//            public void onAdLoaded() {
//                super.onAdLoaded();
//                interstitialAd.show();
//
//            }
//        });

        rewardedVideoAd.setRewardedVideoAdListener(new RewardedVideoAdListener() {
            @Override
            public void onRewardedVideoAdLoaded() {
                rewardedVideoAd.show();
            }

            @Override
            public void onRewardedVideoAdOpened() {

            }

            @Override
            public void onRewardedVideoStarted() {

            }

            @Override
            public void onRewardedVideoAdClosed() {

            }

            @Override
            public void onRewarded(RewardItem rewardItem) {
                Log.e("TAG", "onRewarded: "+ rewardItem.getAmount());
            }

            @Override
            public void onRewardedVideoAdLeftApplication() {

            }

            @Override
            public void onRewardedVideoAdFailedToLoad(int i) {
                Log.e("TAG", "onRewardedVideoAdFailedToLoad: " );
            }
        });

    }
}
