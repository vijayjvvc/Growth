package com.jvworld.growth.ui;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jvworld.growth.Model.StocksModel;
import com.jvworld.growth.Model.WatchModel;
import com.jvworld.growth.R;
import com.jvworld.growth.adpters.StocksListAdapter;
import com.jvworld.growth.adpters.WatchListAdapter;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private RecyclerView watchlistRecycle,stocksRecycle;
    private WatchListAdapter watchListAdapter;
    private ArrayList<WatchModel> watchModelArrayList;

    private StocksListAdapter stocksListAdapter;
    private ArrayList<StocksModel> stocksModelArrayList;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, container, false);
        watchlistRecycle = view.findViewById(R.id.watchlistRecyclerView);
        stocksRecycle = view.findViewById(R.id.stocksActivityRecycle);
        watchUpdater();
        stocks();
        return view;
    }

    private void stocks() {
        stocksRecycle.setHasFixedSize(true);
        stocksRecycle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager
                .HORIZONTAL,false));

        stocksModelArrayList = new ArrayList<>();
        stocksListAdapter = new StocksListAdapter(getContext(), stocksModelArrayList);
        stocksModelArrayList.add(new StocksModel("nvda","Nvidia","https://drive.google.com/uc?id=18Qi5ljB7ohF1GHR8pKvGag5xOKUvbUcc",227.26,25.94,0.14,10));
        stocksModelArrayList.add(new StocksModel("Tsla","Tesla","https://drive.google.com/uc?id=1Kj3fkFuLev7trWX-T9cnH1q8H70rahMl",909.68,25.68,3.77,20));
        stocksRecycle.setAdapter(stocksListAdapter);
    }

    private void watchUpdater() {
        watchlistRecycle.setHasFixedSize(true);
        watchlistRecycle.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager
                .HORIZONTAL,false));

        watchModelArrayList = new ArrayList<>();
        watchListAdapter = new WatchListAdapter(getContext(), watchModelArrayList);
        watchModelArrayList.add(new WatchModel("ADB","Adobe Inc","https://drive.google.com/uc?id=1wirOfuNaCXmpyCAeDP2JB01B_pMb1LC-",643.58,33.49,5.49));
        watchModelArrayList.add(new WatchModel("Tsla","Tesla","https://drive.google.com/uc?id=1Kj3fkFuLev7trWX-T9cnH1q8H70rahMl",909.68,25.68,3.77));
        watchlistRecycle.setAdapter(watchListAdapter);
    }
}