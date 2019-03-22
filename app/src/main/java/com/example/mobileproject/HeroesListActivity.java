package com.example.mobileproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class HeroesListActivity extends AppCompatActivity {

    public static String EXTRA_HEROID = "com.example.mobileproject.heroId";
    public static String EXTRA_HERONAME = "com.example.mobileproject.heroName";

    private List<DotaHero> heroeslist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DotaRest controller = DotaRest.getInstance();
        controller.loadHeroes(this::updateHeroesList);
    }

    void updateHeroesList(List<DotaHero> heroeslist) {
        this.heroeslist = heroeslist;

        RecyclerView recyclerView = findViewById(R.id.heroeslist);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new DotaHeroesList_RecyclerAdapter(heroeslist, this);
        recyclerView.setAdapter(mAdapter);
    }

    void showHeroesStat(int id) {
        if(heroeslist.size() <= id) {
            return;
        }
        Intent intent = new Intent(this, HeroStatActivity.class);
        intent.putExtra(EXTRA_HEROID, heroeslist.get(id).getId());
        intent.putExtra(EXTRA_HERONAME, heroeslist.get(id).getLocalized_name());
        startActivity(intent);
    }
}
