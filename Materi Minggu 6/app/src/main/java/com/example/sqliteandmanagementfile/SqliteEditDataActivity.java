package com.example.sqliteandmanagementfile;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class SqliteEditDataActivity extends AppCompatActivity {
    Button b1, b2;
    DatePickerDialog pickerDialog;
    protected Cursor cursor;
    DataHelper dbHelper;
    EditText t1, t2, t3, t4, t5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_edit_data);

        dbHelper = new DataHelper(this);
        t1 = findViewById(R.id.id_e);
        t2 = findViewById(R.id.nama_e);
        t3 = findViewById(R.id.tgl_lahir_e);
        t4 = findViewById(R.id.jk_e);
        t5 = findViewById(R.id.alamat_e);

        t3.setInputType(InputType.TYPE_NULL);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                pickerDialog = new DatePickerDialog(SqliteEditDataActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                t3.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, year, month, day);
                pickerDialog.show();
            }
        });

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '"+getIntent().getStringExtra("nama")+"'", null);
        cursor.moveToFirst();

        if (cursor.getCount()>0){
            cursor.moveToPosition(0);
            t1.setText(cursor.getString(0).toString());
            t2.setText(cursor.getString(1).toString());
            t3.setText(cursor.getString(2).toString());
            t4.setText(cursor.getString(3).toString());
            t5.setText(cursor.getString(4).toString());
        }
        b1 = findViewById(R.id.back_e);
        b2 = findViewById(R.id.save_e);

        b2.setOnClickListener((arg0) -> {
            SQLiteDatabase dbs = dbHelper.getWritableDatabase();
            dbs.execSQL("UPDATE biodata SET nama='"+
                    t2.getText().toString()+"', tgl='"+
                    t3.getText().toString()+"',jk='"+
                    t4.getText().toString()+"',alamat='"+
                    t5.getText().toString()+"' where no='"+ t1.getText().toString()+"'");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            SqliteMainActivity.ma.RefreshList();
            finish();
        });
        b1.setOnClickListener((arg0) -> {
            finish();
        });
    }
}