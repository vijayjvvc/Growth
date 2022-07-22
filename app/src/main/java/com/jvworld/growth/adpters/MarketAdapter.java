package com.jvworld.growth.adpters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.jvworld.growth.Model.MarketModel;
import com.jvworld.growth.Model.WatchModel;
import com.jvworld.growth.R;

import java.util.ArrayList;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.VH> {

    private Context context;
    private ArrayList<MarketModel> marketModels;

    public MarketAdapter(Context context, ArrayList<MarketModel> marketModels) {
        this.context = context;
        this.marketModels = marketModels;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.market_card_details,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.symbolName.setText(marketModels.get(position).getSymbolName());
        String value = "$"+String.valueOf(marketModels.get(position).getValue());
        String percent = "↑"+String.valueOf(marketModels.get(position).getIncrementPercent())+"%";
        holder.symbolValue.setText(value);
        holder.symbolPercent.setText(percent);
    }

    @Override
    public int getItemCount() {
        return marketModels.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private TextView symbolName,symbolValue,symbolPercent;
        public VH(@NonNull View itemView) {
            super(itemView);
            symbolName = itemView.findViewById(R.id.symbolName);
            symbolValue = itemView.findViewById(R.id.symbolValue);
            symbolPercent = itemView.findViewById(R.id.symbolPercent);
        }
    }
}
