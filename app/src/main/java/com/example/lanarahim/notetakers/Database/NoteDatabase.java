package com.example.lanarahim.notetakers.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.print.PageRange;

/**
 * Created by Lana Rahim on 12/20/2017.
 */

public class NoteDatabase  extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 5;
    private static final String DATABASE_NAME = "notedatabase";
    private static final String TABLE_NAME = "note";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_tanggal = "tanggal";
    private static final String COLUMN_JUDUL = "judul";
    private static final String COLUMN_konten = "konten";

    public NoteDatabase(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTE_TABLE = "CREATE    TABLE " +
                TABLE_NAME + "(" + COLUMN_ID + " INTEGER PRIMARY KEY," +
                COLUMN_tanggal + " DATE,"
                + COLUMN_JUDUL + " TEXT," +
                COLUMN_konten +"TEXT" + ")";

        db.execSQL(CREATE_NOTE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

}
