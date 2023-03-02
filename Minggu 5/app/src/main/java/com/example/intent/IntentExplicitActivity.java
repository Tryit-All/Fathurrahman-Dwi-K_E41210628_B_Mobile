package com.example.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentExplicitActivity extends AppCompatActivity {
    EditText kode;
    Button add;
    private String KEY_KODE = "KODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_explicit);

        kode = (EditText) findViewById(R.id.kode);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String kode_e = kode.getText().toString();
                    if (kode_e.equals("e41210628")){
                        Intent i = new Intent(IntentExplicitActivity.this, ExplicitL2Activity.class);
                        i.putExtra(KEY_KODE, kode_e);
                        startActivity(i);
                    }else {
                        Toast.makeText(IntentExplicitActivity.this, "YOU NEED TO FILL YOUR NAME", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}