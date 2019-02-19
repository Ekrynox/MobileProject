package com.example.mobileproject;


import android.arch.core.util.Function;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class DotaRest {
    private static final String BASE_URL = "https://api.opendota.com/api/";
    private Gson gson;
    private Retrofit retrofit;
    private DotaRestApi gerritAPI;
    private AppCompatActivity activity;

    public DotaRest(AppCompatActivity activity) {
        gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        gerritAPI = retrofit.create(DotaRestApi.class);
        this.activity = activity;
    }

    public void loadHeroes(Consumer<List<DotaHeroes>> success) {
        Call<List<DotaHeroes>> call = gerritAPI.getHeroes();
        call.enqueue(new RestCallBack<>(success));
    }

    public class RestCallBack<T> implements Callback<T> {
        private Consumer<T> success;

        public RestCallBack(Consumer<T> success) {
            this.success = success;
        }

        @Override
        public void onResponse(Call<T> call, Response<T> response) {
            if (response.isSuccessful()) {
                success.accept(response.body());
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<T> call, Throwable t) {
            t.printStackTrace();
        }
    }

}
