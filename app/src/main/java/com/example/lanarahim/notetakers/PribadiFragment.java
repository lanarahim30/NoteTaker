package com.example.lanarahim.notetakers;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;

import com.example.lanarahim.notetakers.Data.Pribadi;
import com.example.lanarahim.notetakers.Database.NoteDatabase;

import java.util.ArrayList;


public class PribadiFragment extends Fragment {
    private RecyclerView rvView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<Pribadi> dataSet;

    String[] daftar;
    RecyclerView recyclerView;
    Menu menu;
    protected Cursor cursor;
    NoteDatabase dbcenter;
    public static PribadiFragment ma;

    public PribadiFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_pribadi, container, false);

        dataSet = new ArrayList<>();
        initDataset();
        rvView = (RecyclerView) viewRoot.findViewById(R.id.rv_main_pribadi);
        rvView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(getActivity());
        rvView.setLayoutManager(layoutManager);

        adapter = new RecycleAdapter(dataSet);
        rvView.setAdapter(adapter);
        return viewRoot;
    }

    private void initDataset() {
        dbcenter = new NoteDatabase(getActivity());
        SQLiteDatabase db = dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM note ", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();

        for (int cc = 0; cc < cursor.getCount(); cc++) {
            cursor.moveToPosition(cc);
            dataSet.add(new Pribadi(
                    cursor.getString(1).toString(),
                    cursor.getString(2).toString(),
                    cursor.getString(3).toString(),
                    cursor.getString(4).toString()
            ));

        }

    }

}
