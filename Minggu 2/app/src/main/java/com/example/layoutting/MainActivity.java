package com.example.layoutting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button b1, b2, b3, b4, b5, b6, b7, b8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.B1);
        b2 = (Button) findViewById(R.id.B2);
        b3 = (Button) findViewById(R.id.B3);
        b4 = (Button) findViewById(R.id.B4);
        b5 = (Button) findViewById(R.id.B5);
        b6 = (Button) findViewById(R.id.B6);
        b7 = (Button) findViewById(R.id.B7);
        b8 = (Button) findViewById(R.id.B8);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){
        if (view == b1){
            Intent intent = new Intent(MainActivity.this, LinearLayoutActivity.class);
            startActivity(intent);
        }else if (view == b2){
            Intent intent = new Intent(MainActivity.this, RelativeLayoutActivity.class);
            startActivity(intent);
        }else if (view == b3){
            Intent intent = new Intent(MainActivity.this, ConstraintLayoutActivity.class);
            startActivity(intent);
        }else if (view == b4){
            Intent intent = new Intent(MainActivity.this, FrameLayoutActivity.class);
            startActivity(intent);
        }else if (view == b5){
            Intent intent = new Intent(MainActivity.this, TableLayoutActivity.class);
            startActivity(intent);
        }else if (view == b6){
            Intent intent = new Intent(MainActivity.this, CustomizeLayoutActivity.class);
            startActivity(intent);
        }else if (view == b7){
            Intent intent = new Intent(MainActivity.this, ScrollViewActivity.class);
            startActivity(intent);
        }else if (view == b8){
            Intent intent = new Intent(MainActivity.this, HorizontalScrollActivity.class);
            startActivity(intent);
        }
    }

}