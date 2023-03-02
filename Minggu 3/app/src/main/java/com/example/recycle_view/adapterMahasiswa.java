package com.example.recycle_view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class adapterMahasiswa extends RecyclerView.Adapter<adapterMahasiswa.MahasiswaViewHolder> {

    private ArrayList<modelRecycle> datalist;

    public adapterMahasiswa(ArrayList<modelRecycle> datalist, Context applicationContext){
        this.datalist = datalist;
    }

    public adapterMahasiswa(List<modelRecycle> inputData, Context context) {
    }

    @NonNull
    @Override
    public MahasiswaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.baris_list, parent, false);
        return new MahasiswaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MahasiswaViewHolder holder, int position) {
        holder.NamaMahasiswa.setText(datalist.get(position).getNama_mahasiswa());
        holder.NimMahasiswa.setText(datalist.get(position).getNim_mahasiswa());
        holder.NohpMahasiswa.setText(datalist.get(position).getNohp_mahasiswa());
    }

    @Override
    public int getItemCount() {
        return (datalist != null) ? datalist.size() :0;
    }

    public class MahasiswaViewHolder extends RecyclerView.ViewHolder{
        private TextView NamaMahasiswa, NimMahasiswa, NohpMahasiswa;

        public MahasiswaViewHolder(View itemView){
            super(itemView);
            NamaMahasiswa = (TextView) itemView.findViewById(R.id.nama_mahasiswa);
            NimMahasiswa = (TextView) itemView.findViewById(R.id.nim_mahasiswa);
            NohpMahasiswa = (TextView) itemView.findViewById(R.id.nohp_mahasiswa);
        }
    }
}
