package com.example.mobilenative.MateriPushNotification;

import static com.example.mobilenative.MainActivity.CHANNEL_ID;
import static com.example.mobilenative.MainActivity.Token;
import static com.example.mobilenative.MainActivity.url;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mobilenative.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class SendNotificationActivity extends AppCompatActivity {
//    public static final String url = "http://192.168.18.140/WGOptical/src/api/loginAPI.php", CHANNEL_ID = "technopoints_id";
    private static final String TAG = "PushNotification";
    static final String CHANNEL_NAME = "technopoints name";
    static final String CHANNEL_DESC = "technopoints desc";
    EditText nama, pesan;
    Button kbutton, anu;
    TextView TOKEN;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_notification);

        createNotificationChannel();
        nama = (EditText) findViewById(R.id.nama);
        pesan = (EditText) findViewById(R.id.pesan);
        kbutton = (Button) findViewById(R.id.kbutton);
        TOKEN = (TextView) findViewById(R.id.token);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription(CHANNEL_DESC);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
        TOKEN.setText(Token);
        kbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String Nama = nama.getText().toString();
                String Pesan = pesan.getText().toString();
//            String Title = "Pesan dari "+Nama;
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
//                                putData = data;
                                    if (status.equals("success")) {
                                        Toast.makeText(SendNotificationActivity.this, "Berhasil Mengirim", Toast.LENGTH_LONG).show();
                                    }else {
                                        System.out.println("error");
                                        Toast.makeText(SendNotificationActivity.this, "Gagal Mengirim", Toast.LENGTH_LONG).show();
                                    }
                                }catch (JSONException e) {
//                                Toast.makeText(SendNotificationActivity.this, e.toString(), Toast.LENGTH_LONG).show();
                                    throw new RuntimeException(e);
                                }
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
//                    Toast.makeText(SendNotificationActivity.this, error.toString(), Toast.LENGTH_LONG).show();
                    }
                }){
                    @Nullable
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();

                        params.put("apikey","aoi12j1h7dwgopticalw1dggwuawdki");
                        params.put("ID", "0");
                        params.put("txt_email",Nama);
                        params.put("txt_Message",Pesan);
//                    params.put("txt_title","SI Gandrung");
//                    params.put("txt_Message", Message);

                        return params;
                    }
                };
                RequestQueue queue = Volley.newRequestQueue(SendNotificationActivity.this);
                queue.add(strinRequest);
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
}