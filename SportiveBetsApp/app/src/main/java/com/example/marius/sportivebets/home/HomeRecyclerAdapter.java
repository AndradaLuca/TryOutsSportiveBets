package com.example.marius.sportivebets.home;


import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityMainBinding;
import com.example.marius.sportivebets.databinding.RawLayoutBinding;

import com.example.marius.sportivebets.home.models.MenuItemsModel;
import com.example.marius.sportivebets.home.sport_fragments.football.FootballFragment;

import com.example.marius.sportivebets.home.sport_fragments.PingPongFragment;
import com.example.marius.sportivebets.home.sport_fragments.TenisFragment;
import com.example.marius.sportivebets.home.sport_fragments.football.FootballFragment;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeRecyclerAdapter.RecyclerViewHolder> {


    private List<MenuItemsModel> items;
    private LayoutInflater layoutInflater;



    public HomeRecyclerAdapter(List<MenuItemsModel> items) {
        this.items = items;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        RawLayoutBinding rawLayoutBinding = RawLayoutBinding.inflate(layoutInflater, parent, false);

        return new RecyclerViewHolder(rawLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {


        MenuItemsModel menuItemsModel = items.get(position);
        holder.bind(menuItemsModel);


    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private RawLayoutBinding rawLayoutBinding;
        private ActivityMainBinding activityMainBinding;



        public RecyclerViewHolder(RawLayoutBinding rawLayoutBinding) {
            super(rawLayoutBinding.getRoot());
            this.rawLayoutBinding = rawLayoutBinding;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }

        public void bind(MenuItemsModel menuItemsModel) {
            
            this.rawLayoutBinding.setMenuView(menuItemsModel);
            this.rawLayoutBinding.imageView.setImageResource(menuItemsModel.icon);
        }

        public RawLayoutBinding getRawLayoutBinding() {
            return this.rawLayoutBinding;
        }

        @SuppressLint("RestrictedApi")
        @Override
        public void onClick(View view) {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment myFragment = new FootballFragment();
            switch (getAdapterPosition()) {
                case 0:
                    myFragment = new FootballFragment();
                    break;
                case 1:
                    myFragment = new TenisFragment();
                    break;
                case 2:
                    myFragment = new PingPongFragment();
                    break;
            }

            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, myFragment).addToBackStack(null).commit();


        }


    }
}
