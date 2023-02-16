package com.example.mobilenative;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {
    public static final String url = "http://192.168.0.103/WGOptical/src/api/loginAPI.php";
    public static final String CHANNEL_ID = "technopoints_id";
    public static String Token = "";
    EditText email, pass;
    TextView msg;
    Button Lbutton, Rbutton;
    String putData, Nama;
    private static final String TAG = "PushNotification";
    //    static final String CHANNEL_ID = "technopoints_id";
    static final String CHANNEL_NAME = "technopoints name";
    static final String CHANNEL_DESC = "technopoints desc";
    static String SHARED_PREF_NAME = "net.softglobe.fcmphpmysql";
    TextView Tokentxt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createNotificationChannel();
        getToken();
//        createNotificationChannel();
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        Lbutton = (Button) findViewById(R.id.login);
        Rbutton = (Button) findViewById(R.id.SignIn);

        Lbutton.setOnClickListener(this::onClick);
        Rbutton.setOnClickListener(this::onClick);
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())) {
            startActivity(new Intent(getBaseContext(), HomeActivity.class));
            finish();
        }
    }

    public void onClick(View view) {
        if (view == Lbutton) {
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }else{
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            startActivity(intent);
        }

    }

    private void getToken(){
        FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() {
            @Override
            public void onComplete(@NonNull Task<String> task) {
                if (!task.isSuccessful()) {
                    Log.d(TAG, "onComplete: Failed to get the Token");
                }
                String token = task.getResult();
//                Tokentxt.setText(""+token);
                Log.d(TAG, "onComplete: "+token);
                Token = token;
            }
        });
    }

    private void createNotificationChannel() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "FirebaseNotifChannel";
            String description = "Lorem loermefaslkasmc";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    private void ToHome() {
        Preferences.setLoggedInUser(getBaseContext(), putData);
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(),HomeActivity.class));
        finish();
    }
}