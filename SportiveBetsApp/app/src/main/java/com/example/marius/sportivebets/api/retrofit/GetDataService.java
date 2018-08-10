package com.example.marius.sportivebets.api.retrofit;

import com.example.marius.sportivebets.api.models.LeaguesResponse;

import retrofit2.Call;
import retrofit2.http.GET;


public interface GetDataService {

    @GET("/leagues")
    Call<LeaguesResponse> getAllLeagues();

}
