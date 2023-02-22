package com.example.recycle_view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class RecyclerViewActivity extends AppCompatActivity {
    ArrayList<modelRecycle> modelRecycles;
    RecyclerView recyclerView;
    private static com.example.recycle_view.adapterMahasiswa adapterMahasiswa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        System.out.println("sini");
        recyclerView = (RecyclerView) findViewById(R.id.list_recycle);
        modelRecycles = new ArrayList<>();

        modelRecycles.add(new modelRecycle("Bayu", "Rp.150.000", "Rp.150.000"));
        modelRecycles.add(new modelRecycle("Digo", "Rp.210.000", "Rp.210.000"));
        modelRecycles.add(new modelRecycle("Aufa", "Rp.70.000", "Rp.70.000"));
        modelRecycles.add(new modelRecycle("Rusli", "Rp.210.000", "Rp.210.000"));
        adapterMahasiswa = new adapterMahasiswa(modelRecycles, getApplicationContext());
        recyclerView.setAdapter(adapterMahasiswa);
    }
}