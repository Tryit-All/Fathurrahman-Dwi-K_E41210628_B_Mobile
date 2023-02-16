package com.example.mobilenative.Transaksi;

public class ModelTransaksi {

    String nama_produk;
    String harga;
    String sub_harga;
    int img;
    String feature;

    public ModelTransaksi(String nama_produk, String harga, String sub_harga, int img) {
        this.nama_produk=nama_produk;
        this.harga=harga;
        this.sub_harga=sub_harga;
        this.img=img;
        this.feature=feature;

    }

    public String getNama_produk() {
        return nama_produk;
    }

    public String getHarga() {
        return harga;
    }

    public String getSub_harga() {
        return sub_harga;
    }

    public int getImgs() {
        return img;
    }

    public String getFeatures() {
        return feature;
    }

}
