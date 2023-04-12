package com.example.sqliteandmanagementfile;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class ManagementFileMainActivity extends AppCompatActivity {
    private  int STORAGE_PERMISSIO_CODE = 28;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_file_main);
        editText = findViewById(R.id.textField);
    }

    public void next(View view){
        Intent intent = new Intent(ManagementFileMainActivity.this, ManagementFileValueActivity.class);
        startActivity(intent);
    }

    public void savePublic(View view){
        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSIO_CODE);
        String info = editText.getText().toString();
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File fileName = new File(folder, "HasilData1.txt");
        writeData(fileName, info);
        editText.setText("");
    }

    public void savePrivate(View view){
        String info = editText.getText().toString();
        File folder = getExternalFilesDir("fathur");
        File fileName = new File(folder, "HasilData2.txt");
        writeData(fileName, info);
        editText.setText("");
    }

    private void writeData(File fileName, String info) {
        FileOutputStream fileOutputStream = null;

        try {
            System.out.println(info.getBytes());
            fileOutputStream = new FileOutputStream(fileName);
                fileOutputStream.write(info.getBytes());
            Toast.makeText(this, "Done" + fileName.getAbsolutePath(), Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}