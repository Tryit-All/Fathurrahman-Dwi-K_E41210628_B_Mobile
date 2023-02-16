package com.example.mobilenative;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilenative.MateriListView.MateriListViewActivity;
import com.example.mobilenative.MateriPushNotification.SendNotificationActivity;
import com.example.mobilenative.Transaksi.TransaksiActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    ArrayList<Model> dataModels, dataModels2;
    ListView materi, ViewDoang;
    private static Adapter adapter;
    private static Adapter2 adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        materi = (ListView) findViewById(R.id.list_item);
//        ViewDoang = (ListView) findViewById(R.id.view_horizontal);

        dataModels = new ArrayList<>();
//        dataModels2 = new ArrayList<>();

        dataModels.add(new Model("Listview & Dialog", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.invoice));
        dataModels.add(new Model("Push Notivication", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.log));
        dataModels.add(new Model("Listview Movie", "The Movie Database (TMDb) adalah database film yang menyediakan data-data lengkap seperti data film yang akan datang,", R.drawable.db));
        adapter = new Adapter(dataModels, getApplicationContext());

//        dataModels2.add(new Model("LISTVIEW & DIALOG", "view", R.drawable.invoice));
//        dataModels2.add(new Model("PUSH NOTIFICATION", "view", R.drawable.log));
//        adapter2 = new Adapter2(dataModels2, getApplicationContext());

        materi.setAdapter(adapter);
//        ViewDoang.setAdapter(adapter2);
        materi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posisi, long l) {

                Model model= dataModels.get(posisi);

                if (posisi == 0) {
                    Intent intent = new Intent(HomeActivity.this, MateriListViewActivity.class);
                    startActivity(intent);
                }else if (posisi == 1) {
                    Intent intent = new Intent(HomeActivity.this, SendNotificationActivity.class);
                    startActivity(intent);
                }else if (posisi == 2) {
                    Intent intent = new Intent(HomeActivity.this, TransaksiActivity.class);
                    startActivity(intent);
                }
//                Toast.makeText(HomeActivity.this, model.getMessage(), Toast.LENGTH_LONG).show();
            }
        });

        try {
            JSONObject jsonObject = new JSONObject(Preferences.getLoggedInUser(getBaseContext()));
            String ID = jsonObject.getString("id_pegawai");
            String name = jsonObject.getString("nama");
            System.out.println(jsonObject);
            TextView id = findViewById(R.id.id);
            id.setText("Your ID in this training class : "+ID);
            TextView nama = findViewById(R.id.nama);
            nama.setText("Hello, "+name);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        findViewById(R.id.button).setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Menghapus Status login dan kembali ke Login Activity
                Preferences.clearLoggedInUser(getBaseContext());
                startActivity(new Intent(getBaseContext(),MainActivity.class));
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }
}