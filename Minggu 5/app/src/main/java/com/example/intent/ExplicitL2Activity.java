package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ExplicitL2Activity extends AppCompatActivity {
    TextView name_prouct, harga;
    ImageView imageView;
    private String nama;
    private String KEY_NAME = "KODE";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit_l2);

        name_prouct = (TextView) findViewById(R.id.name_product);
        harga = (TextView) findViewById(R.id.price);
        imageView = findViewById(R.id.image_product);

        Bundle extra = getIntent().getExtras();
        nama = extra.getString(KEY_NAME);
        if (nama.equals("e41210628")) {
            name_prouct.setText("Produk Baju Hari Raya");
            harga.setText("Rp.130.000");
        }
    }
}