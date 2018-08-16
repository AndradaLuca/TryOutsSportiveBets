package com.example.marius.sportivebets.home.bottomNavFragments;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.FragmentHomeBinding;

import java.util.Objects;

public class HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        FragmentHomeBinding homeBinding;
//        homeBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_home,container,false);
//        View view = homeBinding.getRoot();
        return inflater.inflate(R.layout.fragment_home,container,false);
    }
}
