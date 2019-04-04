package com.example.mobileproject;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;

import com.example.mobileproject.controller.DotaRest;
import com.example.mobileproject.controller.DotaSQL;
import com.example.mobileproject.model.DotaHeroMatch;

import java.util.List;

public class HeroStatActivity extends AppCompatActivity {
    private int heroId;
    private DotaSQL db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stat);

        db = DotaSQL.getInstance(getApplicationContext());

        Intent intent = getIntent();
        heroId = intent.getIntExtra(HeroesListActivity.EXTRA_HEROID,0);
        ((TextView)findViewById(R.id.hero_stat_title)).setText(intent.getStringExtra(HeroesListActivity.EXTRA_HERONAME));
        new DownloadBitmap(findViewById(R.id.hero_stat_image), null).execute(intent.getStringExtra(HeroesListActivity.EXTRA_HEROIMG));

        DotaRest controller = DotaRest.getInstance();
        controller.loadHeroMatches(heroId, this::setCacheHeroMatches, this::loadCacheHeroMatches);
    }

    void setCacheHeroMatches(List<DotaHeroMatch> matches) {
        db.sql().removeMatches(heroId);

        for (DotaHeroMatch match : matches) {
            match.setHero_id(heroId);
            db.sql().addMatches(match);
        }

        updateHeroMatches(matches);
    }

    void loadCacheHeroMatches() {
        List<DotaHeroMatch> matches = db.sql().getMatches(heroId);
        updateHeroMatches(matches);
    }

    void updateHeroMatches(List<DotaHeroMatch> matches) {
        RecyclerView recyclerView = findViewById(R.id.matcheslist);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new DotaHeroMatchesList_RecyclerAdapter(matches, this);
        recyclerView.setAdapter(mAdapter);
    }
}