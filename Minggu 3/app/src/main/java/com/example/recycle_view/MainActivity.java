package com.example.recycle_view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<modelRecycle> modelRecycles;
    RecyclerView recyclerView;
    private static com.example.recycle_view.adapterMahasiswa adapterMahasiswa;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        System.out.println("sini");
        recyclerView = (RecyclerView) findViewById(R.id.list_recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        modelRecycles = new ArrayList<>();

        modelRecycles.add(new modelRecycle("Bayu", "E41210628", "093248290384"));
        modelRecycles.add(new modelRecycle("Digo", "E34210938", "087423874432"));
        modelRecycles.add(new modelRecycle("Aufa", "E32321809", "098384273482"));
        modelRecycles.add(new modelRecycle("Rusli", "E312120", "428390284392"));
        adapterMahasiswa = new adapterMahasiswa(modelRecycles, this);
        recyclerView.setAdapter(adapterMahasiswa);
    }
}