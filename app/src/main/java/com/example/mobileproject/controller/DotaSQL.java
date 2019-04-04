package com.example.mobileproject.controller;

import android.content.Context;

import com.example.mobileproject.model.DotaHero;
import com.example.mobileproject.model.DotaHeroMatch;
import com.example.mobileproject.view.DotaSQLApi;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


@Database(entities = {DotaHeroMatch.class, DotaHero.class}, version = 2, exportSchema = false)
public abstract class DotaSQL extends RoomDatabase {
    private static DotaSQL instance = null;

    public static DotaSQL getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, DotaSQL.class, "dotaDatabase").allowMainThreadQueries().fallbackToDestructiveMigration().build();
        }
        return instance;
    }


    public abstract DotaSQLApi sql();
}
