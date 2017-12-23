package com.example.lanarahim.notetakers.Data;

/**
 * Created by Lana Rahim on 12/20/2017.
 */

public class Note {
    private int id;
    private String judul;
    private String konten;
    private String tanggal;

    public Note(){}

    public void setId(int id) {
        this.id = id;
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

    public int getId() {
        return id;
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

}
