package com.example.mobilenative.MateriListView;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


import com.example.mobilenative.R;

import java.util.ArrayList;

public class MateriListViewActivity extends AppCompatActivity {
    ArrayList<ModelTomateri> dataModels;
    ListView materi;
    private static AdapterToMateri adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materi_list_view);

        System.out.println("sini");
        materi = (ListView) findViewById(R.id.materi_list_item);
        dataModels = new ArrayList<>();

        dataModels.add(new ModelTomateri("LISTVIEW", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.invoice));
        dataModels.add(new ModelTomateri("PUSH NOTIFICATION", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.log));
        dataModels.add(new ModelTomateri("LISTVIEW", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.logo));
        dataModels.add(new ModelTomateri("PUSH NOTIFICATION", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.tsa_logo));
        dataModels.add(new ModelTomateri("LISTVIEW", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.splash));
        dataModels.add(new ModelTomateri("PUSH NOTIFICATION", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.log));
        dataModels.add(new ModelTomateri("LISTVIEW", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.invoice));
        dataModels.add(new ModelTomateri("PUSH NOTIFICATION", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.log));
        dataModels.add(new ModelTomateri("LISTVIEW", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.invoice));
        dataModels.add(new ModelTomateri("PUSH NOTIFICATION", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.log));
        dataModels.add(new ModelTomateri("LISTVIEW", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.invoice));
        dataModels.add(new ModelTomateri("PUSH NOTIFICATION", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.log));
        dataModels.add(new ModelTomateri("LISTVIEW", "ListView merupakan tampilan yang mengelompokkan beberapa item data dalam bentuk daftar yang dapat kita scroll secara vertikal. Item data pada ListView dapat ", R.drawable.invoice));
        dataModels.add(new ModelTomateri("PUSH NOTIFICATION", "Push Notification adalah pesan singkat atau notifikasi yang dikirim oleh aplikasi smartphone ke semua orang yang telah menginstal aplikasi tersebut", R.drawable.log));
        adapter = new AdapterToMateri(dataModels, getApplicationContext());

        materi.setAdapter(adapter);
//        materi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//
//                ModelTomateri model= dataModels.get(i);
//
////                if (i == 0) {
////                    Intent intent = new Intent(MateriList.this, ContentMateri.class);
////                    startActivity(intent);
////                }else if (i == 1) {
//////                    Intent intent = new Intent(MateriList.this, HomeActivity.class);
//////                    startActivity(intent);
////                    Toast.makeText(MateriList.this,"ini Push notificaiton",Toast.LENGTH_LONG).show();
////                }
//            }
//        });

//
//        try {
//            JSONObject jsonObject = new JSONObject(Preferences.getLoggedInUser(getBaseContext()));
//            String ID = jsonObject.getString("id_pegawai");
//            String name = jsonObject.getString("nama");
//            System.out.println(jsonObject);
//            TextView id = findViewById(R.id.id);
//            id.setText("Your ID in this training class : "+ID);
//            TextView nama = findViewById(R.id.nama);
//            nama.setText("Hello, "+name);
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
////        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
////        if (id == R.id.action_settings) {
////            return true;
////        }
//
//        return super.onOptionsItemSelected(item);
    }
}