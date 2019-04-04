package com.example.mobileproject.view;

import com.example.mobileproject.model.DotaHero;
import com.example.mobileproject.model.DotaHeroMatch;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


@Dao
public interface DotaSQLApi {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addMatches(DotaHeroMatch match);

    @Query("select * from DotaHeroMatch where hero_id = :hero_id Order by match_id desc")
    List<DotaHeroMatch> getMatches(int hero_id);

    @Query("delete from DotaHeroMatch where hero_id = :hero_id")
    void removeMatches(int hero_id);


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void addHero(DotaHero hero);

    @Query("select * from DotaHero Order by id asc")
    List<DotaHero> getHeroes();

    @Query("delete from DotaHero")
    void removeHeroes();
}
