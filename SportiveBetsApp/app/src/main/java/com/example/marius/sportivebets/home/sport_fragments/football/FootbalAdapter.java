package com.example.marius.sportivebets.home.sport_fragments.football;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marius.sportivebets.databinding.FootballLeaguesLayoutBinding;

import java.util.List;

public class FootbalAdapter extends RecyclerView.Adapter<FootbalAdapter.FootballViewHolder> {

    private List<ItemModel> footballItems;
    private LayoutInflater layoutInflater;

    public FootbalAdapter(List<ItemModel> footballItems) {
        this.footballItems = footballItems;

    }

    @NonNull
    @Override
    public FootballViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }

        FootballLeaguesLayoutBinding footballLeaguesLayoutBinding = FootballLeaguesLayoutBinding.inflate(layoutInflater, parent, false);
        return new FootballViewHolder(footballLeaguesLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull FootballViewHolder holder, int position) {
        ItemModel itemModel= footballItems.get(position);
        holder.bind(itemModel);

    }

    @Override
    public int getItemCount() {
        return footballItems.size();
    }

    public static class FootballViewHolder extends RecyclerView.ViewHolder {

        private FootballLeaguesLayoutBinding footballLeaguesLayoutBinding;

        public FootballViewHolder(FootballLeaguesLayoutBinding footballLeaguesLayoutBinding) {
            super(footballLeaguesLayoutBinding.getRoot());
            this.footballLeaguesLayoutBinding = footballLeaguesLayoutBinding;
        }

        public void bind(ItemModel itemModel) {
            this.footballLeaguesLayoutBinding.setItemModel(itemModel);

        }

        public FootballLeaguesLayoutBinding getFootballLeaguesLayoutBinding() {
            return footballLeaguesLayoutBinding;
        }
    }
}


