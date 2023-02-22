package com.example.recycle_view;

public class modelRecycle {

    String nama_mahasiswa;
    String nim_mahasiswa;
    String nohp_mahasiswa;
    String feature;

    public modelRecycle(String nama_mahasiswa, String nim_mahasiswa, String nohp_mahasiswa) {
        this.nama_mahasiswa=nama_mahasiswa;
        this.nim_mahasiswa=nim_mahasiswa;
        this.nohp_mahasiswa=nohp_mahasiswa;

    }

    public String getNama_mahasiswa() {
        return nama_mahasiswa;
    }

    public void setNama_mahasiswa(String nama_mahasiswa){
        this.nama_mahasiswa = nama_mahasiswa;
    }

    public String getNim_mahasiswa() {
        return nim_mahasiswa;
    }

    public void setNim_mahasiswa(String nim_mahasiswa){
        this.nim_mahasiswa = nim_mahasiswa;
    }

    public String getNohp_mahasiswa() {
        return nohp_mahasiswa;
    }

    public void setNohp_mahasiswa(String nohp_mahasiswa){
        this.nohp_mahasiswa = nohp_mahasiswa;
    }

    public String getFeatures() {
        return feature;
    }

}
