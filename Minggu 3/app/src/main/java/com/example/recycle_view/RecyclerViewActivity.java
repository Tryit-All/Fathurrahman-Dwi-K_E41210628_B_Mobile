package com.example.recycle_view;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends Fragment {
    ArrayList<modelRecycle> modelRecycles;
//    List<modelRecycle> modelRecycles;
    RecyclerView recyclerView;
    private static com.example.recycle_view.adapterMahasiswa adapterMahasiswa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_recycler_view);

        View view = inflater.inflate(R.layout.activity_recycler_view, container, false);
        System.out.println("sini");
        recyclerView = view.findViewById(R.id.list_recycle);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

//        inputData();
        recyclerView.setAdapter(new adapterMahasiswa(inputData(),getContext()));

        return view;

//        modelRecycles = new ArrayList<>();

//        modelRecycles.add(new modelRecycle("Bayu", "Rp.150.000", "Rp.150.000"));
//        modelRecycles.add(new modelRecycle("Digo", "Rp.210.000", "Rp.210.000"));
//        modelRecycles.add(new modelRecycle("Aufa", "Rp.70.000", "Rp.70.000"));
//        modelRecycles.add(new modelRecycle("Rusli", "Rp.210.000", "Rp.210.000"));
//        adapterMahasiswa = new adapterMahasiswa(modelRecycles, getApplicationContext());
//        recyclerView.setAdapter(adapterMahasiswa);
    }

    private ArrayList<modelRecycle> inputData(){

        modelRecycles = new ArrayList<>();

        modelRecycles.add(new modelRecycle("Bayu", "Rp.150.000", "Rp.150.000"));
        modelRecycles.add(new modelRecycle("Digo", "Rp.210.000", "Rp.210.000"));
        modelRecycles.add(new modelRecycle("Aufa", "Rp.70.000", "Rp.70.000"));
        modelRecycles.add(new modelRecycle("Rusli", "Rp.210.000", "Rp.210.000"));
        return modelRecycles;
    }
}