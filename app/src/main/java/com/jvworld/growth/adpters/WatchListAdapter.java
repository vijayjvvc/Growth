package com.jvworld.growth.adpters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jvworld.growth.Model.WatchModel;
import com.jvworld.growth.R;
import com.jvworld.growth.ui.activity.StockActivity;

import java.util.ArrayList;

public class WatchListAdapter extends RecyclerView.Adapter<WatchListAdapter.VH> {

    private Context context;
    private ArrayList<WatchModel> watchModels;

    public WatchListAdapter(Context context, ArrayList<WatchModel> watchModels) {
        this.context = context;
        this.watchModels = watchModels;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.expended_card_details,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.symbol.setText(watchModels.get(position).getSymbol());
        holder.symbolName.setText(watchModels.get(position).getSymbolName());
        String value = "$"+String.valueOf(watchModels.get(position).getValue());
        String percent = "↑"+String.valueOf(watchModels.get(position).getIncrementPercent())+"%";
        holder.symbolValue.setText(value);
        holder.symbolPercent.setText(percent);
        holder.symbolPoint.setText(String.valueOf(watchModels.get(position).getIncrementPoint()));
        Glide.with(context).load(watchModels.get(position).getSymbolSrc()).into(holder.symbolSrc);

    }

    @Override
    public int getItemCount() {
        return watchModels.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private TextView symbol,symbolName,symbolValue,symbolPoint,symbolPercent;
        private ImageView symbolSrc;
        public VH(@NonNull View itemView) {
            super(itemView);
            symbol = itemView.findViewById(R.id.symbol);
            symbolName = itemView.findViewById(R.id.symbolName);
            symbolValue = itemView.findViewById(R.id.symbolValue);
            symbolPoint = itemView.findViewById(R.id.symbolPointIncrement);
            symbolPercent = itemView.findViewById(R.id.symbolPercent);
            symbolSrc = itemView.findViewById(R.id.symbolSrc);

            itemView.setOnClickListener(v -> {
                context.startActivity(new Intent(context, StockActivity.class));
            });
        }
    }
}
