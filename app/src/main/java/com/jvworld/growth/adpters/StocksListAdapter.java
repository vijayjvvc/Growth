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
import com.jvworld.growth.Model.StocksModel;
import com.jvworld.growth.Model.WatchModel;
import com.jvworld.growth.R;

import java.util.ArrayList;

public class StocksListAdapter extends RecyclerView.Adapter<StocksListAdapter.VH> {

    private Context context;
    private ArrayList<StocksModel> stocksModels;

    public StocksListAdapter(Context context, ArrayList<StocksModel> stocksModels) {
        this.context = context;
        this.stocksModels = stocksModels;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.line_card_details,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.symbol.setText(stocksModels.get(position).getSymbol());
        holder.symbolName.setText(stocksModels.get(position).getSymbolName());
        String value = "$"+String.valueOf(stocksModels.get(position).getValue());
        String percent = "↑"+String.valueOf(stocksModels.get(position).getIncrementPercent())+"%";
        holder.symbolValue.setText(value);
        holder.symbolPercent.setText(percent);
        holder.symbolPoint.setText(String.valueOf(stocksModels.get(position).getIncrementPoint()));
        Glide.with(context).load(stocksModels.get(position).getSymbolSrc()).into(holder.symbolSrc);
        holder.symbolShare.setText(String.valueOf(stocksModels.get(position).getShare())+"shares");

    }

    @Override
    public int getItemCount() {
        return stocksModels.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private TextView symbol,symbolName,symbolValue,symbolPoint,symbolPercent,symbolShare;
        private ImageView symbolSrc;
        public VH(@NonNull View itemView) {
            super(itemView);
            symbol = itemView.findViewById(R.id.symbol);
            symbolShare = itemView.findViewById(R.id.symbolShare);
            symbolName = itemView.findViewById(R.id.symbolName);
            symbolValue = itemView.findViewById(R.id.symbolPrice);
            symbolPoint = itemView.findViewById(R.id.symbolPoint);
            symbolPercent = itemView.findViewById(R.id.symbolPercent);
            symbolSrc = itemView.findViewById(R.id.symbolSrc);
        }
    }
}
