package com.example.marius.sportivebets.home.bottomNavFragments.betTicket;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
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
        fragmentBetTicketBinding.setLista(FootbalAdapter.GamesHolder.betTicketItems);
        double cotaTotala = 1;

        for (int i = 0 ; i< FootbalAdapter.GamesHolder.betTicketItems.size();++i){
            cotaTotala = cotaTotala * FootbalAdapter.GamesHolder.betTicketItems.get(i).getCota();
        }

        String cotaTotalaStrimg = String.format("%.2f",cotaTotala);
        fragmentBetTicketBinding.setCotaTotala(cotaTotalaStrimg);
        double finalCotaTotala = cotaTotala;
        fragmentBetTicketBinding.editText2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            fragmentBetTicketBinding.textView17.setText(String.format("%.2f",finalCotaTotala *Double.parseDouble(fragmentBetTicketBinding.editText2.getText().toString())));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        recyclerViewBetTicke.setLayoutManager(new LinearLayoutManager(getContext()));

        adapterBetTicket = new BetTicketAdapter(FootbalAdapter.GamesHolder.betTicketItems);
        recyclerViewBetTicke.setAdapter(adapterBetTicket);

        return fragmentBetTicketBinding.getRoot();
    }


}
