package com.example.sqliteandmanagementfile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class SqliteAddDataActivity extends AppCompatActivity {
    protected Cursor cursor;
    DatePickerDialog pickerDialog;
    DataHelper dbHelper;
    Button b1, b2;
    EditText t1, t2, t3, t4, t5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_add_data);

        dbHelper = new DataHelper(this);
        t1 = (EditText) findViewById(R.id.t1);
        t2 = (EditText) findViewById(R.id.t2);
        t3 = (EditText) findViewById(R.id.t3);
        t4 = (EditText) findViewById(R.id.t4);
        t5 = (EditText) findViewById(R.id.t5);
        b1 = (Button) findViewById(R.id.save);
        b2 = (Button) findViewById(R.id.back);

        t3.setInputType(InputType.TYPE_NULL);
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                pickerDialog = new DatePickerDialog(SqliteAddDataActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                t3.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, year, month, day);
                pickerDialog.show();
            }
        });

        b1.setOnClickListener((arg0) -> {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            db.execSQL("insert into biodata(no, nama, tgl, jk, alamat) values ('"+
                    t1.getText().toString() +"','"+
                    t2.getText().toString() +"','"+
                    t3.getText().toString() +"','"+
                    t4.getText().toString() +"','"+
                    t5.getText().toString() +"')");
            Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
            SqliteMainActivity.ma.RefreshList();
            finish();
        });
        b2.setOnClickListener((arg0) -> {
            finish();
        });

    }
}