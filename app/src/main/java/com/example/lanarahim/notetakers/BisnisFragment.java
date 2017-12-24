package com.example.lanarahim.notetakers;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lanarahim.notetakers.Data.Pribadi;

import java.util.ArrayList;


public class BisnisFragment extends Fragment {
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pribadi> dataSet;

    public BisnisFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_bisnis,container,false);

        dataSet = new ArrayList<>();
        initDataset();

        rvView = (RecyclerView) viewRoot.findViewById(R.id.rv_main_bisnis);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        rvView.setLayoutManager(layoutManager);

        adapter = new RecycleAdapter(dataSet);
        rvView.setAdapter(adapter);
        return viewRoot;
    }

    private void initDataset(){


    }
}
