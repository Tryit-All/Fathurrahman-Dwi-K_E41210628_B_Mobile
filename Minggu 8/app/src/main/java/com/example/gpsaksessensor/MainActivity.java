package com.example.gpsaksessensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button to_GPS, to_Sensor;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        to_GPS = findViewById(R.id.buttonGPS);
        to_Sensor = findViewById(R.id.buttonSENSOR);

        to_GPS.setOnClickListener(this);
        to_Sensor.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == to_GPS){
            Intent to_GPS = new Intent(MainActivity.this, MapsActivity.class);
            startActivity(to_GPS);
        }else{
            Intent to_SENSOR = new Intent(MainActivity.this, MainSensorActivity.class);
            startActivity(to_SENSOR);
        }
    }
}