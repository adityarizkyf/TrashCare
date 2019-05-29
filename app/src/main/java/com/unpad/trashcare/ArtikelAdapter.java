package com.unpad.trashcare;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class ArtikelAdapter extends RecyclerView.Adapter<ArtikelAdapter.MyViewHolder> {
    private ArrayList<Artikel> dataSet;
    private Context context;

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView dispJudul, dispJenis;
        ImageView dispImg;



    public MyViewHolder(View itemView) {
        super(itemView);
        this.cardView = (CardView) itemView.findViewById(R.id.cardView);
        this.dispJudul = (TextView) itemView.findViewById(R.id.tvJudul);
        this.dispJenis = (TextView) itemView.findViewById(R.id.tvJenis);
        this.dispImg   = (ImageView) itemView.findViewById(R.id.ivArtikel);
    }
    }
    public ArtikelAdapter(ArrayList<Artikel> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artikel_item_layout, parent, false);

        //view.setOnClickListener(ComplainAct.myOnClickListener);

        MyViewHolder viewHolder = new MyViewHolder(view);
        context = parent.getContext();

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        CardView cardView = holder.cardView;
        TextView dispJudul = holder.dispJudul;
        TextView dispJenis = holder.dispJenis;
        ImageView dispImg = holder.dispImg;

        Glide.with(context).load(dataSet.get(listPosition).getImg()).into(dispImg);
        dispJudul.setText(dataSet.get(listPosition).getJudul());
        dispJenis.setText(dataSet.get(listPosition).getJenis());

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PageArtikel.class);
                intent.putExtra(Artikel.Art, dataSet.get(listPosition));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}


