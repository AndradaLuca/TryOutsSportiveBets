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
import com.example.marius.sportivebets.home.sport_fragments.football.FootbalAdapter;
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

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {


        private RowInBetTicketBinding rowInBetTicketBinding;



        public RecyclerViewHolder(RowInBetTicketBinding rowInBetTicketBinding) {
            super(rowInBetTicketBinding.getRoot());
            this.rowInBetTicketBinding=rowInBetTicketBinding;
            rowInBetTicketBinding.imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    FootbalAdapter.GamesHolder.betTicketItems.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    notifyItemRangeChanged(getAdapterPosition(), FootbalAdapter.GamesHolder.betTicketItems.size());
                }
            });
           // itemView.setClickable(false);
        }

        public void bind(BetTicketItemsModel betTicketItemsModel)
        {
            this.rowInBetTicketBinding.setMenuView(betTicketItemsModel);
           // this.rowInBetTicketBinding.setIBetTicket(this);

        }

        public RowInBetTicketBinding getRowInBetTicketBinding(){
            return rowInBetTicketBinding;
        }


//        @Override
//        public void onXClick() {
//            System.out.println("HHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
//            System.out.println(FootbalAdapter.GamesHolder.betTicketItems.get(getAdapterPosition()).toString());
//
//        }
    }
}
