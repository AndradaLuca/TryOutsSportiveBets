package com.example.marius.sportivebets.home;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marius.sportivebets.R;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.RecyclerViewHolder> {


    private List<String> sportList;
    private List<Integer> images;


    public RecycleAdapter(List<String> sportList, List<Integer> images) {
        this.sportList = sportList;
        this.images = images;

    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_layout, parent, false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.textView.setText(sportList.get(position));
        holder.imageView.setImageResource(images.get(position));

    }

    @Override
    public int getItemCount() {
        return sportList.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tx_item);
            imageView = itemView.findViewById(R.id.imageView);

        }
    }


}
