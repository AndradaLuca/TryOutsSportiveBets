package com.example.marius.sportivebets.home.bottomNavFragments.betTicket;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.RawLayoutBinding;
import com.example.marius.sportivebets.databinding.RowInBetTicketBinding;
import com.example.marius.sportivebets.home.models.MenuItemsModel;
import com.example.marius.sportivebets.home.sport_fragments.PingPongFragment;
import com.example.marius.sportivebets.home.sport_fragments.TenisFragment;
import com.example.marius.sportivebets.home.sport_fragments.football.FootballFragment;

import java.util.List;

public class BetTicketAdapter extends RecyclerView.Adapter<BetTicketAdapter.RecyclerViewHolder> {


    private LayoutInflater layoutInflater;
    private List<BetTicketItemsModel> items;

    public BetTicketAdapter(List<BetTicketItemsModel> items) {
        this.items=items;
    }


    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if(layoutInflater==null)
        {
            layoutInflater=LayoutInflater.from(parent.getContext());
        }
        RowInBetTicketBinding rowInBetTicketBinding = RowInBetTicketBinding.inflate(layoutInflater,parent,false);
        return new RecyclerViewHolder(rowInBetTicketBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BetTicketAdapter.RecyclerViewHolder holder, int position) {

        BetTicketItemsModel betTicketItemsModel=items.get(position);
        holder.bind(betTicketItemsModel);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private RowInBetTicketBinding rowInBetTicketBinding;



        public RecyclerViewHolder(RowInBetTicketBinding rowInBetTicketBinding) {
            super(rowInBetTicketBinding.getRoot());
            this.rowInBetTicketBinding=rowInBetTicketBinding;
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }

        public void bind(BetTicketItemsModel betTicketItemsModel)
        {
            this.rowInBetTicketBinding.setMenuView(betTicketItemsModel);
        }


        @Override
        public void onClick(View view) {

            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            Fragment myFragment =new BetTicketFragment();
            switch (getAdapterPosition())
            {
                case 0 :
                    myFragment = new BetTicketFragment();
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
