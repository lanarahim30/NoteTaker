package com.example.lanarahim.notetakers.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PageRange;
import android.util.Log;

/**
 * Created by Lana Rahim on 12/20/2017.
 */

public class NoteDatabase  extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "note.db";
    private static final int DATABASE_VERSION = 1;
    public NoteDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table note(id int auto_increment, " +
                "judul text null, " +
                "konten text null," +
                " tanggal DATE null, " +
                "kategori text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO note (id, judul, konten, tanggal, kategori) VALUES ('1','Makan','Indramayu','10/02/1997','Pribadi');";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
    }

    public void tambah_biodata(String judul, String konten, String tanggal, String kategori) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("judul", judul);
        values.put("konten", konten);
        values.put("tanggal", tanggal);
        values.put("kategori", kategori);
        database.insert("note", null, values);
        database.close();
    }

    public int update_biodata(String id, String judul, String konten,String tanggal, String kategori) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues recordBiodata = new ContentValues();
        recordBiodata.put("judul", judul);
        recordBiodata.put("konten", konten);
        recordBiodata.put("tanggal", tanggal);
        recordBiodata.put("kategori", kategori);
        return database.update("note", recordBiodata, "id=" + id, null);
    }
}
