package com.example.sqliteandmanagementfile;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class SqliteViewListActivity extends AppCompatActivity {
    Button button;
    protected Cursor cursor;
    DataHelper dbHelper;
    TextView t1, t2, t3, t4, t5;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_view_list);

        dbHelper = new DataHelper(this);
        t1 = findViewById(R.id.Id_list);
        t2 = findViewById(R.id.Nama_list);
        t3 = findViewById(R.id.Tgl_lahir_list);
        t4 = findViewById(R.id.Jenis_list);
        t5 = findViewById(R.id.Alamat_list);

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
        button = findViewById(R.id.back_button);
        button.setOnClickListener((parent) -> {
            finish();
        });
    }
}