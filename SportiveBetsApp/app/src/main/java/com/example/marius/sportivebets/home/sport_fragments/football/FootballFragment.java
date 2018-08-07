package com.example.marius.sportivebets.home.sport_fragments.football;


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
import com.example.marius.sportivebets.databinding.FragmentFootball2Binding;
import com.example.marius.sportivebets.utils.Constants;

public class FootballFragment extends Fragment {

    private FragmentFootball2Binding fragmentFootball2Binding;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_football2,container,false);

        recyclerView=rootView.findViewById(R.id.recycleViewFootbal);
      //  recyclerView=fragmentFootball2Binding.recycleViewFootbal;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter= new FootbalAdapter(Constants.footbalItems);
        recyclerView.setAdapter(adapter);

        return rootView;
    }

}
