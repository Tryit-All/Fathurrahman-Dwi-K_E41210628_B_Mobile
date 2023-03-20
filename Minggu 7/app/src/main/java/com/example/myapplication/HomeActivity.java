package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView id = findViewById(R.id.id);
        id.setText("Your ID in this training class : ");
        TextView nama = findViewById(R.id.nama);
        nama.setText("Hello, "+ Preferences.getLoggedInUser(getBaseContext()));

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
}