package com.example.mobileproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.mobileproject.controller.DotaRest;
import com.example.mobileproject.model.DotaHeroMatch;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.List;

public class HeroStatActivity extends AppCompatActivity {
    private int heroId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stat);

        Intent intent = getIntent();
        heroId = intent.getIntExtra(HeroesListActivity.EXTRA_HEROID,0);
        ((TextView)findViewById(R.id.hero_stat_title)).setText(intent.getStringExtra(HeroesListActivity.EXTRA_HERONAME));
        new DownloadBitmap(findViewById(R.id.hero_stat_image), null).execute(intent.getStringExtra(HeroesListActivity.EXTRA_HEROIMG));

        DotaRest controller = DotaRest.getInstance();
        controller.loadHeroMatches(heroId, this::setCacheHeroMatches, this::loadCacheHeroMatches);
    }

    void setCacheHeroMatches(List<DotaHeroMatch> matches) {
        updateHeroMatches(matches);
    }

    void loadCacheHeroMatches() {
        updateHeroMatches(null);
    }

    void updateHeroMatches(List<DotaHeroMatch> matches) {
    }
}