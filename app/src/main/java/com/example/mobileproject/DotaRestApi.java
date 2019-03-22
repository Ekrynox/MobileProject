package com.example.mobileproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DotaRestApi {
    @GET("heroStats")
    Call<List<DotaHero>> getHeroes();

    Call<List<DotaHeroMatch>> getHeroMatches();
}
