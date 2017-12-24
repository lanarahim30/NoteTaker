package com.example.lanarahim.notetakers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lanarahim.notetakers.Database.NoteDatabase;

import java.util.Calendar;

public class TambahNote extends AppCompatActivity {
    private static TextView display;
    private Calendar calendar;
    private TextView dateview;
    private int year, month, day;
    Button btnsave, btncancel;

    NoteDatabase sqLiteHelper = new NoteDatabase(this);
    protected Cursor cursor;

    NoteDatabase noteDatabase;

    EditText editJudul, editKonten, editTanggal;
    Spinner editkategori;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_note);
        getSupportActionBar().setTitle("Note Taker");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dateview = (TextView) findViewById(R.id.tanggal);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year,month + 1,day);

        btnsave = (Button) findViewById(R.id.simpan);
        btncancel = (Button) findViewById(R.id.batal);

        editJudul = (EditText) findViewById(R.id.judul);
        editKonten = (EditText) findViewById(R.id.konten);
        editkategori = (Spinner) findViewById(R.id.spinner);

        final Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] kategori = {"Pribadi","Bisnis","Edukasi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,kategori);
        spinner.setAdapter(adapter);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String judul = editJudul.getText().toString();
                String konten = editKonten.getText().toString();
                String tanggal = dateview.getText().toString();
                String kategori = spinner.toString();

                ((Button) v).getText().toString();
                System.out.println(tanggal);

                sqLiteHelper.tambah_biodata(judul, konten,tanggal,kategori);
                finish();

                Intent tambahnote = new Intent(TambahNote.this, MainActivity.class);
                startActivity(tambahnote);
            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @SuppressWarnings("deprecation")
    public void setDate(View view){
       showDialog(999);
        Toast.makeText(getApplicationContext(),"Pilih Tanggal",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            showDate(arg1, arg2+1, arg3);
        }
    };
    private void showDate(int year, int month, int day){
        dateview.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
