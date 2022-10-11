package com.beckytech.Kitaabaherregakutaa8ffaa.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.beckytech.Kitaabaherregakutaa8ffaa.BuildConfig;
import com.beckytech.Kitaabaherregakutaa8ffaa.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Locale;

public class AboutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        MobileAds.initialize(this, initializationStatus -> {
        });

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        findViewById(R.id.ib_back).setOnClickListener(v -> onBackPressed());
        String str = "About us";
        TextView title = findViewById(R.id.tv_title);
        title.setText(str);

        WebView webView = findViewById(R.id.webView);
        webView.loadUrl("file:///android_asset/about.html");

        TextView version = findViewById(R.id.version_tv);
        version.setText(String.format(Locale.ENGLISH," %s", BuildConfig.VERSION_NAME));
    }
}