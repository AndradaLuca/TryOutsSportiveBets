package com.example.marius.sportivebets.home.sport_fragments.football;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.api.models.Game;
import com.example.marius.sportivebets.api.models.League;
import com.example.marius.sportivebets.api.models.LeaguesResponse;
import com.example.marius.sportivebets.api.retrofit.GetDataService;
import com.example.marius.sportivebets.api.retrofit.RetrofitClientInstance;
import com.example.marius.sportivebets.databinding.FragmentFootball2Binding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballFragment extends Fragment {

    private FragmentFootball2Binding fragmentFootball2Binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_football2, container, false);

        recyclerView = rootView.findViewById(R.id.recycleViewFootbal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        //TODO move this call in view model
        GetDataService service = RetrofitClientInstance.getRetrofitInstance().create(GetDataService.class);
        service.getAllLeagues().enqueue(new Callback<LeaguesResponse>() {
            @Override
            public void onResponse(Call<LeaguesResponse> call, Response<LeaguesResponse> response) {
                if(response.isSuccessful()) {
                    initAdapter(response.body().getLeagues());
                }
            }

            @Override
            public void onFailure(Call<LeaguesResponse> call, Throwable t) {

            }
        });

        return rootView;
    }

    private void initAdapter(List<League> leagues) {
        List<ExpandableLeague> el = new ArrayList<>();
        for(League league : leagues) {
            ExpandableLeague expandableLeague = new ExpandableLeague(league.getLeagueTitle(), league.getGames());
            el.add(expandableLeague);
        }
        adapter = new FootbalAdapter(el);
        recyclerView.setAdapter(adapter);
    }


}
