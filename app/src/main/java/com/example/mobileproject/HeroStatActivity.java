package com.example.mobileproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class HeroStatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stat);

        Intent intent = getIntent();
        int heroId = intent.getIntExtra(HeroesListActivity.EXTRA_HEROID,0);
        ((TextView)findViewById(R.id.hero_stat_title)).setText(intent.getStringExtra(HeroesListActivity.EXTRA_HERONAME));
        //(ImageView)findViewById(R.id.hero_stat_image)

        DotaRest controller = DotaRest.getInstance();
        controller.loadHeroMatches(heroId, this::updateHeroMatches);
    }

    void updateHeroMatches(List<DotaHeroMatch> matches) {

    }
}
