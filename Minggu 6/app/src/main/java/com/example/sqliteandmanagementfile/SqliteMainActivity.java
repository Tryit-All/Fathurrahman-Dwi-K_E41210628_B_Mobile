package com.example.sqliteandmanagementfile;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class SqliteMainActivity extends AppCompatActivity {
    Button button;
    String[] daftar;
    Menu menu;
    ListView ListView01;
    protected Cursor cursor;
    DataHelper dbcenter;
    public static SqliteMainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sqlite_main);

        button = findViewById(R.id.add_data);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SqliteMainActivity.this, SqliteAddDataActivity.class);
                startActivity(intent);
            }
        });

        ma = this;
        dbcenter = new DataHelper(this);
        RefreshList();
    }

    public void RefreshList(){
        SQLiteDatabase db =dbcenter.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata", null);
        daftar = new String[cursor.getCount()];
        cursor.moveToFirst();
        for(int cc=0; cc<cursor.getCount(); cc++){
            cursor.moveToPosition(cc);
            daftar[cc] = cursor.getString(1).toString();
        }
        ListView01 = (ListView)findViewById(R.id.data_list);
        ListView01.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_1, daftar));
        ListView01.setSelected(true);
        ListView01.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView arg0, View arg1, int arg2, long arg3) {
                final String selection = daftar[arg2];
                final CharSequence[] dialogitem = {"Lihat Biodata", "Update Biodata", "Hapus Biodata"};
                AlertDialog.Builder builder = new AlertDialog.Builder(SqliteMainActivity.this);
                builder.setTitle("Pilihan");
                builder.setItems(dialogitem, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        switch (item){
                            case 0 :
                                Intent i = new Intent(getApplicationContext(), SqliteViewListActivity.class);
                                i.putExtra("nama", selection);
                                startActivity(i);
                                break;
                            case 1 :
                                Intent in = new Intent(getApplicationContext(), SqliteEditDataActivity.class);
                                in.putExtra("nama", selection);
                                startActivity(in);
                                break;
                            case 2 :
                                SQLiteDatabase db = dbcenter.getReadableDatabase();
                                db.execSQL("delete from biodata where nama = '"+selection+"'");
                                RefreshList();
                                break;
                        }
                    }
                });
                builder.create().show();
            }
        });
        ((ArrayAdapter)ListView01.getAdapter()).notifyDataSetInvalidated();
    }
}