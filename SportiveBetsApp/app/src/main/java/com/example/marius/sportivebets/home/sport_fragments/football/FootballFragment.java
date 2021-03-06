package com.example.marius.sportivebets.home.sport_fragments.football;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
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
import com.example.marius.sportivebets.databinding.ActivityMainBinding;
import com.example.marius.sportivebets.databinding.FragmentFootball2Binding;
import com.example.marius.sportivebets.login.LoginViewModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FootballFragment extends Fragment {

    private FootballViewModel footballViewModel;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;




    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_football2, container, false);

        recyclerView = rootView.findViewById(R.id.recycleViewFootbal);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        initViewModel();
        footballViewModel.getAllLeagues();

        return rootView;
    }

    private void initViewModel() {
        footballViewModel = ViewModelProviders.of(this).get(FootballViewModel.class);
        footballViewModel.getLeaguesResponseMutableLiveData().observe(this, new Observer<LeaguesResponse>() {
            @Override
            public void onChanged(@Nullable LeaguesResponse leaguesResponse) {
                initAdapter(leaguesResponse.getLeagues());
            }
        });
    }

    private void initAdapter(List<League> leagues) {
        List<ExpandableLeague> el = new ArrayList<>();
        for (League league : leagues) {
            ExpandableLeague expandableLeague = new ExpandableLeague(league.getLeagueTitle(), league.getGames());
            el.add(expandableLeague);
        }
        adapter = new FootbalAdapter(el);
        recyclerView.setAdapter(adapter);
    }


}
