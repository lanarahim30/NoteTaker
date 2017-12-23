package com.example.lanarahim.notetakers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class TambahNote extends AppCompatActivity {
    private static TextView display;
    private Calendar calendar;
    private TextView dateview;
    private int year, month, day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_note);
        getSupportActionBar().setTitle("Note Taker");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        dateview = (TextView) findViewById(R.id.set_tanggal);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year,month + 1,day);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        String[] kategori = {"Pribadi","Bisnis","Edukasi"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,kategori);
        spinner.setAdapter(adapter);
    }
    @SuppressWarnings("deprecation")
    public void setDate(View view){
       showDialog(999);
        Toast.makeText(getApplicationContext(),"Pilih Tanggal",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 999){
            return new DatePickerDialog(this,myDateListener,year,month,day);
        }
        return null;
    }
    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
            showDate(year, month+1,day);
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
