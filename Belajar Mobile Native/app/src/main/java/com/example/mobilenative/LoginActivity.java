package com.example.mobilenative;

import static com.example.mobilenative.MainActivity.CHANNEL_ID;
import static com.example.mobilenative.MainActivity.url;

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
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
//    public static final String url = "http://192.168.18.140/WGOptical/src/api/loginAPI.php", CHANNEL_ID = "technopoints_id";
    EditText email, pass;
    TextView msg;
    Button Lbutton, Rbutton;
    String putData, Nama;
    private static final String TAG = "PushNotification";
    static final String CHANNEL_NAME = "technopoints name";
    static final String CHANNEL_DESC = "technopoints desc";
    static String SHARED_PREF_NAME = "net.softglobe.fcmphpmysql";
    TextView Tokentxt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        createNotificationChannel();
//        getToken();
//        Tokentxt = (TextView) findViewById(R.id.tokentxt2);
        email = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.pass);
        Lbutton = (Button) findViewById(R.id.l_button);
        Rbutton = (Button) findViewById(R.id.l_button);
//        Tokentxt = (TextView) findViewById(R.id.tokentxt2);
//        msg = (TextView) findViewById(R.id.output) ;

        Lbutton.setOnClickListener(this);
        Rbutton.setOnClickListener(this);

        //Creating notification channel for devices on and above Android O
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (Preferences.getLoggedInStatus(getBaseContext())) {
            startActivity(new Intent(getBaseContext(), HomeActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        if (view == Lbutton) {
            String Email = this.email.getText().toString();
            String Pass = this.pass.getText().toString();
            String Message = "Hai "+Email+" Selamat datang Kembali :)";
//            System.out.println(Nama);

            StringRequest strinRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String status = jsonObject.getString("status");
                                String massage = jsonObject.getString("msg");
                                String data = jsonObject.getString("data");
                                JSONObject jsonDATA = new JSONObject(data);
                                String nama = jsonDATA.getString("nama");
//                                Nama = nama;
//                                System.out.println(Nama);
                                putData = data;
                                if (status.equals("success")) {
//                                    msg.setText(id_pegawai);
                                    ToHome();
                                    Toast.makeText(LoginActivity.this, massage, Toast.LENGTH_LONG).show();
//                                    Intent intent = new Intent(MainActivity.this, HomeActivity.class);
//                                    startActivity(intent);
                                }else {
                                    System.out.println("error");
                                    Toast.makeText(LoginActivity.this, massage, Toast.LENGTH_LONG).show();
                                }
                            }catch (JSONException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {

                }
            }){
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> params = new HashMap<>();

                    params.put("apikey","aoi12j1h7dwgopticalw1dggwuawdki");
                    params.put("ID", "1");
                    params.put("txt_email",Email);
                    params.put("txt_password",Pass);
                    params.put("txt_title","SI Gandrung");
//                    params.put("txt_Message", Message);

                    return params;
                }
            };
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(strinRequest);
        }else{

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