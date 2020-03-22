package com.example.quotationmaker;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.MyViewHolder> {

    private ArrayList<Item> items;

    public ArrayList<Item> getItems() {
        return items;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
    TextView TV2;
    TextView TV3;
    TextView TV4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            this.TV2 = itemView.findViewById(R.id.TV2);
            this.TV3 = itemView.findViewById(R.id.TV3);
            this.TV4 = itemView.findViewById(R.id.TV4);
        }
    }

    public ItemAdapter(ArrayList<Item> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public ItemAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.final_item, parent, false);
        return new MyViewHolder(listItem);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        try {
            holder.TV2.setText(items.get(position).getName());
            holder.TV3.setText(Float.toString(items.get(position).getQuantity()));
            holder.TV4.setText(Float.toString(items.get(position).getPrice()));
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
