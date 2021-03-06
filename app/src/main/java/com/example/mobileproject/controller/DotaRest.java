package com.example.mobileproject.controller;


import java.lang.reflect.Method;
import java.util.List;
import java.util.function.Consumer;

import com.example.mobileproject.model.DotaHero;
import com.example.mobileproject.model.DotaHeroMatch;
import com.example.mobileproject.view.DotaRestApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DotaRest {
    private static DotaRest instance = new DotaRest();

    public static DotaRest getInstance() {
        return instance;
    }

    private static final String BASE_URL = "https://api.opendota.com/api/";
    private Gson gson;
    private Retrofit retrofit;
    private DotaRestApi gerritAPI;

    private DotaRest() {
        gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        gerritAPI = retrofit.create(DotaRestApi.class);
    }

    public void loadHeroes(Consumer<List<DotaHero>> success, Runnable failure) {
        Call<List<DotaHero>> call = gerritAPI.getHeroes();
        call.enqueue(new RestCallBack<>(success, failure));
    }

    public void loadHeroMatches(int heroId, Consumer<List<DotaHeroMatch>> success, Runnable failure) {
        Call<List<DotaHeroMatch>> call = gerritAPI.getHeroMatches(Integer.toString(heroId));
        call.enqueue(new RestCallBack<>(success, failure));
    }

    
    public class RestCallBack<T> implements Callback<T> {
        private Consumer<T> success;
        private Runnable failure;

        public RestCallBack(Consumer<T> success, Runnable failure) {
            this.success = success;
            this.failure = failure;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if (response.isSuccessful()) {
                if(success != null) {
                    success.accept(response.body());
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            t.printStackTrace();
            if (failure != null) {
                failure.run();
            }
        }
    }

}
