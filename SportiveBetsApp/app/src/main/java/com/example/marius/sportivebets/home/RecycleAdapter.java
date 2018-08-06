package com.example.marius.sportivebets.home;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.RawLayoutBinding;
import com.example.marius.sportivebets.home.sport_fragments.FootballFragment;
import com.example.marius.sportivebets.home.sport_fragments.PingPongFragment;
import com.example.marius.sportivebets.home.sport_fragments.TenisFragment;

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

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private RawLayoutBinding rawLayoutBinding;
        private TextView textView;
        private ImageView imageView;
        private Context context;


        private RecyclerViewHolder(View itemView) {
            super(itemView);

            context = itemView.getContext();
            textView = itemView.findViewById(R.id.tx_item);
            imageView = itemView.findViewById(R.id.imageView);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment myFragment =new FootballFragment();
            switch (getAdapterPosition())
            {
                case 0 :
                    myFragment = new FootballFragment();
                    break;
                case 1:
                    myFragment= new TenisFragment();
                    break;
                case 2:
                    myFragment=new PingPongFragment();


            }

            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,myFragment).addToBackStack(null).commit();


        }


    }
}
