package com.example.mobileproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DotaRest controller = new DotaRest(this);
        controller.loadHeroes(this::updateHeroesList);
    }

    void updateHeroesList(List<DotaHeroes> heroeslist) {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.heroeslist);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RecyclerView.Adapter mAdapter = new DotaHeroesList_RecyclerAdapter(heroeslist);
        recyclerView.setAdapter(mAdapter);
    }
}
