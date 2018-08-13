package com.example.marius.sportivebets.home.bottomNavFragments.betTicket;

import android.databinding.DataBindingUtil;
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
import com.example.marius.sportivebets.databinding.FragmentBetTicketBinding;
import com.example.marius.sportivebets.home.sport_fragments.football.FootbalAdapter;
import com.example.marius.sportivebets.utils.Constants;

public class BetTicketFragment extends Fragment {

    FragmentBetTicketBinding fragmentBetTicketBinding;

    RecyclerView recyclerViewBetTicke;
    RecyclerView.Adapter adapterBetTicket;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBetTicketBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_bet_ticket,container,false);
        recyclerViewBetTicke = fragmentBetTicketBinding.recycleViewBetTicket;
        recyclerViewBetTicke.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterBetTicket = new BetTicketAdapter(FootbalAdapter.GamesHolder.betTicketItems);
        recyclerViewBetTicke.setAdapter(adapterBetTicket);

        return fragmentBetTicketBinding.getRoot();
    }
}
