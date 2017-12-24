package com.example.lanarahim.notetakers.Data;

/**
 * Created by Lana Rahim on 12/24/2017.
 */

public class Pribadi{
    String judul;
    String konten;
    String tanggal;
    String kategori;

    public Pribadi(String judul, String konten, String tanggal, String kategori) {
        this.judul = judul;
        this.konten = konten;
        this.tanggal = tanggal;
        this.kategori = kategori;
    }

    public String getJudul() {
        return judul;
    }

    public String getKonten() {
        return konten;
    }

    public String getTanggal() {
        return tanggal;
    }

    public String getKategori() {
        return kategori;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public void setKonten(String konten) {
        this.konten = konten;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }
}
