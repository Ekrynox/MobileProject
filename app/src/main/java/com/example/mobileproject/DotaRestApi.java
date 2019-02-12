package com.example.mobileproject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface DotaRestApi {
    @GET("heroes")
    Call<List<DotaHeroes>> getHeroes(@Query("q") String status);
}
