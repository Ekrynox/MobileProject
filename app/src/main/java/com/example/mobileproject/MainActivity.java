package com.example.mobileproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DotaRest controller = DotaRest.getInstance();
        controller.loadHeroes(this::updateHeroesList);

        showHeroesStat(1);
    }

    void updateHeroesList(List<DotaHero> heroeslist) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.heroeslist);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new DotaHeroesList_RecyclerAdapter(heroeslist);
        recyclerView.setAdapter(mAdapter);
    }

    void showHeroesStat(int id) {
        Intent intent = new Intent(this, HeroStatActivity.class);
        intent.putExtra("com.example.mobileproject.heroId", id);
        startActivity(intent);
    }
}
