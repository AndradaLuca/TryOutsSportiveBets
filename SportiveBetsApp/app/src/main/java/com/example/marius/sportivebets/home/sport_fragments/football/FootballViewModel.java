package com.example.marius.sportivebets.home.sport_fragments.football;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marius.sportivebets.api.models.LeaguesResponse;
import com.example.marius.sportivebets.api.retrofit.GetDataService;
import com.example.marius.sportivebets.api.retrofit.RetrofitClientInstance;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;;

public class FootballViewModel extends AndroidViewModel {

    private GetDataService service;
    private MutableLiveData<LeaguesResponse> leaguesResponseMutableLiveData = new MutableLiveData<>();


    public FootballViewModel(@NonNull Application application) {
        super(application);
        service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
    }


    public void getAllLeagues() {
        service.getAllLeagues().enqueue(new Callback<LeaguesResponse>() {
            @Override
            public void onResponse(Call<LeaguesResponse> call, Response<LeaguesResponse> response) {
                if (response.isSuccessful()) {
                    leaguesResponseMutableLiveData.postValue(response.body());


                }
            }

            @Override
            public void onFailure(Call<LeaguesResponse> call, Throwable t) {
                Log.d("api", "Failed to retrieve data");
            }
        });


    }

    public MutableLiveData<LeaguesResponse> getLeaguesResponseMutableLiveData() {
        return leaguesResponseMutableLiveData;
    }
}