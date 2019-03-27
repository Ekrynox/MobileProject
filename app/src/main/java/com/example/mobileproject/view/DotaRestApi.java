package com.example.mobileproject.view;

import com.example.mobileproject.model.DotaHero;
import com.example.mobileproject.model.DotaHeroMatch;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DotaRestApi {
    @GET("heroStats")
    Call<List<DotaHero>> getHeroes();

    @GET("heroes/{hero_id}/matches")
    Call<List<DotaHeroMatch>> getHeroMatches(@Path("hero_id") String hero_id);
}
