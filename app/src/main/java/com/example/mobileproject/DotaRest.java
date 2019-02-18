package com.example.mobileproject;

import java.util.List;

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

    public DotaRest() {
        gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create(gson)).build();
        gerritAPI = retrofit.create(DotaRestApi.class);
    }

    public void loadHereos() {
        Call<List<DotaHeroes>> call = gerritAPI.getHeroes();
        call.enqueue(new DotaHeroesCallBack());
    }


    public class DotaHeroesCallBack implements Callback<List<DotaHeroes>> {
        @Override
        public void onResponse(Call<List<DotaHeroes>> call, Response<List<DotaHeroes>> response) {
            if (response.isSuccessful()) {
                List<DotaHeroes> heroesList = response.body();

                for (DotaHeroes hereo : heroesList) {
                    System.out.println(hereo.getName() + " " + hereo.getLocalized_name() + " " + hereo.getPrimary_attr() + " " + hereo.getAttack_type());
                    for (String role : hereo.getRoles()) {
                        System.out.print(" " + role);
                    }
                    System.out.print("\n");
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<List<DotaHeroes>> call, Throwable t) {
            t.printStackTrace();
        }
    }

}
