package com.beckytech.Kitaabaherregakutaa8ffaa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.beckytech.Kitaabaherregakutaa8ffaa.R;
import com.beckytech.Kitaabaherregakutaa8ffaa.contents.ContentEndPage;
import com.beckytech.Kitaabaherregakutaa8ffaa.contents.ContentStartPage;
import com.beckytech.Kitaabaherregakutaa8ffaa.model.Model;
import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BooKDetailActivity extends AppCompatActivity {

    private final ContentStartPage startPage = new ContentStartPage();
    private final ContentEndPage endPage = new ContentEndPage();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        MobileAds.initialize(this, initializationStatus -> {
        });

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        findViewById(R.id.back_book_detail).setOnClickListener(v -> onBackPressed());

        Intent intent = getIntent();
        Model model = (Model) intent.getSerializableExtra("data");

        TextView title = findViewById(R.id.title_book_detail);
        title.setSelected(true);
        title.setText(model.getTitle());

        TextView subTitle = findViewById(R.id.subTitle_book_detail);
        subTitle.setText(model.getSubtitle());

        PDFView pdfView = findViewById(R.id.pdfView);

        int start = model.getPageStart();
        int end = model.getPageEnd();

        List<Integer> list = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            list.add(i);
        }

        int[] array = new int[list.size()];

        for (int j = 1; j < array.length; j++) {
            array[j] = list.get(j);
        }

        pdfView.fromAsset("h8.pdf")
                .pages(array)
                .defaultPage(0)
                .enableSwipe(true)
                .swipeHorizontal(false)
                .spacing(10)
                .enableDoubletap(true)
                .scrollHandle(new DefaultScrollHandle(this))
                .load();
    }

}