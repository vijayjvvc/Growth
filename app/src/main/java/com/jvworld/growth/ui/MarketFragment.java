package com.jvworld.growth.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvworld.growth.Model.MarketModel;
import com.jvworld.growth.Model.StocksModel;
import com.jvworld.growth.Model.WatchModel;
import com.jvworld.growth.R;
import com.jvworld.growth.adpters.MarketAdapter;
import com.jvworld.growth.adpters.StocksListAdapter;
import com.jvworld.growth.adpters.WatchListAdapter;

import java.util.ArrayList;

public class MarketFragment extends Fragment {

    View view;
    private StocksListAdapter stocksListAdapter;
    private ArrayList<StocksModel> stocksModelArrayList;
    private MarketAdapter marketAdapter;
    private ArrayList<MarketModel> marketModelArrayList;
    private RecyclerView marketMoversRecycle,MarketsRecyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_market, container, false);
        marketMoversRecycle = view.findViewById(R.id.marketMoversRecycle);
        MarketsRecyclerView = view.findViewById(R.id.MarketsRecyclerView);
        stocks();
        market();
        return view;
    }

    private void market() {
        MarketsRecyclerView.setHasFixedSize(true);
        MarketsRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager
                .HORIZONTAL,false));

        marketModelArrayList = new ArrayList<>();
        marketAdapter = new MarketAdapter(getContext(), marketModelArrayList);
        marketModelArrayList.add(new MarketModel("Dow Jones",35617.89,0.25));
        marketModelArrayList.add(new MarketModel("Tesla",4677.90,0.14));
        MarketsRecyclerView.setAdapter(marketAdapter);
    }

    private void stocks() {
        marketMoversRecycle.setHasFixedSize(true);
        marketMoversRecycle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager
                .VERTICAL,false));

        stocksModelArrayList = new ArrayList<>();
        stocksListAdapter = new StocksListAdapter(getContext(), stocksModelArrayList);
        stocksModelArrayList.add(new StocksModel("nvda","Nvidia","https://drive.google.com/uc?id=18Qi5ljB7ohF1GHR8pKvGag5xOKUvbUcc",227.26,25.94,0.14,10));
        stocksModelArrayList.add(new StocksModel("Tsla","Tesla","https://drive.google.com/uc?id=1Kj3fkFuLev7trWX-T9cnH1q8H70rahMl",909.68,25.68,3.77,20));
        stocksModelArrayList.add(new StocksModel("nvda","Nvidia","https://drive.google.com/uc?id=18Qi5ljB7ohF1GHR8pKvGag5xOKUvbUcc",227.26,25.94,0.14,10));
        stocksModelArrayList.add(new StocksModel("Tsla","Tesla","https://drive.google.com/uc?id=1Kj3fkFuLev7trWX-T9cnH1q8H70rahMl",909.68,25.68,3.77,20));
        marketMoversRecycle.setAdapter(stocksListAdapter);
    }
}