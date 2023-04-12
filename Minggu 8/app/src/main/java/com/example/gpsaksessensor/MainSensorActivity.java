package com.example.gpsaksessensor;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainSensorActivity extends AppCompatActivity implements View.OnClickListener {

    private Button ImgAllSensor, ImgProximitySensor, ImgLightSensor;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_sensor);

        ImgAllSensor = findViewById(R.id.img_list_all_sensor);
        ImgProximitySensor = findViewById(R.id.img_proximity_sensor);
        ImgLightSensor = findViewById(R.id.img_light_sensor);
        ImgAllSensor.setOnClickListener(this);
        ImgProximitySensor.setOnClickListener(this);
        ImgLightSensor.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        int id = v.getId();
        switch (id){
            case R.id.img_list_all_sensor:
                Intent intentAll = new Intent(MainSensorActivity.this, AllSensorActivity.class);
                startActivity(intentAll);
                break;
            case R.id.img_proximity_sensor:
                Intent intentProximity = new Intent(MainSensorActivity.this, ProximitySensorActivity.class);
                startActivity(intentProximity);
                break;
            case R.id.img_light_sensor:
                Intent intentLight = new Intent(MainSensorActivity.this, LightSensorActivity.class);
                startActivity(intentLight);
                break;
        }
    }
}