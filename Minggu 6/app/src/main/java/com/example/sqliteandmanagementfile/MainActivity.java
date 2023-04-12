package com.example.sqliteandmanagementfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button button, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);

        button.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == button) {
            Intent intent = new Intent(MainActivity.this, ManagementFileMainActivity.class);
            startActivity(intent);
        }else if (v == button2){
            Intent intent = new Intent(MainActivity.this, SqliteMainActivity.class);
            startActivity(intent);
        }
    }
}