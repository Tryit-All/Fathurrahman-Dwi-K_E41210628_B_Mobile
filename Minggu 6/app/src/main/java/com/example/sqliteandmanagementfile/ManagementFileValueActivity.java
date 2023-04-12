package com.example.sqliteandmanagementfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ManagementFileValueActivity extends AppCompatActivity {

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_file_value);
        textView = findViewById(R.id.text_view);
    }

    public void back(View view){
        Intent intent = new Intent(ManagementFileValueActivity.this, ManagementFileMainActivity.class);
        startActivity(intent);
    }

    public void getPublic(View view){
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File fileName = new File(folder, "HasilData1.txt");
        String text = getdata(fileName);
        if (text != null){
            textView.setText(text);
        }else {
            textView.setText("No Data");
        }
    }

    public void getPrivate(View view){
        File folder = getExternalFilesDir("fathur");
        File fileName = new File(folder, "HasilData2.txt");
        String text = getdata(fileName);
        if (text != null){
            textView.setText(text);
        }else if (text.equals("")){
            textView.setText("No Data");
        }
    }

    private String getdata(File fileName) {
        FileInputStream fileInputStream = null;

        try {
            fileInputStream = new FileInputStream(fileName);
            int i = -1;
            StringBuffer buffer = new StringBuffer();
                    while ((i = fileInputStream.read()) != -1){
                        buffer.append((char) i);
                    }return buffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}