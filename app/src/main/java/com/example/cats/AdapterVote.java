package com.example.cats;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cats.clases.Vote;

import java.util.ArrayList;
import java.util.List;

public class AdapterVote extends RecyclerView.Adapter<AdapterVote.VoteHolder>{
    private List<Vote> listVote ;
    private final Context context;

    public AdapterVote(Context context) {
        this.context = context;
        this.listVote= new ArrayList<>();
    }

    @NonNull
    @Override
    public AdapterVote.VoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_vote,parent,false);
        return new VoteHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterVote.VoteHolder holder, int position) {
    Vote vote = listVote.get(position);
        if(vote.getValue()==1){
            holder.like.setVisibility(View.VISIBLE);
        }else{
            holder.Nlike.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        return listVote.size();
    }
    public void setLista(List<Vote> lista){
        listVote=lista;
        notifyDataSetChanged();
    }
    static  class VoteHolder extends  RecyclerView.ViewHolder{
        private final TextView like;
        private final TextView Nlike;
        private final ImageView image;

        public VoteHolder(@NonNull View itemView) {
            super(itemView);
            like = itemView.findViewById(R.id.likeT);
            Nlike = itemView.findViewById(R.id.Nlike);
            image = itemView.findViewById(R.id.imagen);

        }
    }


}
