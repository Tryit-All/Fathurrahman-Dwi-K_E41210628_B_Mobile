package com.example.mobilenative.Transaksi;

import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobilenative.R;

import java.util.ArrayList;

public class TransaksiActivity extends AppCompatActivity {
    ArrayList<ModelTransaksi> dataModels;
    ListView materi;
    private static AdapterTransaksi adapterTransaksi;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaksi);

        System.out.println("sini");
        materi = (ListView) findViewById(R.id.list_pesanan);
        dataModels = new ArrayList<>();

        dataModels.add(new ModelTransaksi("Dress Panjang Kondangan K..", "Rp.150.000", "Rp.150.000", R.drawable.invoice));
        dataModels.add(new ModelTransaksi("Dress Casual Pink", "Rp.210.000", "Rp.210.000", R.drawable.tsa_logo));
        dataModels.add(new ModelTransaksi("Celana Chinos Buat Perang ...", "Rp.70.000", "Rp.70.000", R.drawable.logo));
        dataModels.add(new ModelTransaksi("Dress Casual Pink", "Rp.210.000", "Rp.210.000", R.drawable.tsa_logo));
        adapterTransaksi = new AdapterTransaksi(dataModels, getApplicationContext());
        materi.setAdapter(adapterTransaksi);
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