package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText emailLogin, passLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        /* Menginisialisasi variable dengan Form User dan Form Password dari Layout LoginActivity */
        emailLogin=findViewById(R.id.email);
        passLogin =findViewById(R.id.pass);
        /* Menjalankan Method razia() Jika tombol SignIn di keyboard di sentuh */
        passLogin.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    razia();
                    return true;
                }
                return false;
            }
        });

        /* Menjalankan Method razia() jika merasakan tombol SignIn disentuh */
        findViewById(R.id.l_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                razia();
            }
        });
//        /* Ke RegisterActivity jika merasakan tombol SignUp disentuh */
//        findViewById(R.id.button_signupSignin).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getBaseContext(),RegisterActivity.class));
//            }
//        });
    }

    private void razia() {
        /* Mereset semua Error dan fokus menjadi default */
        emailLogin.setError(null);
        passLogin.setError(null);
        View fokus = null;
        boolean cancel = false;

        /* Mengambil text dari form User dan form Password dengan variable baru bertipe String*/
        String user = emailLogin.getText().toString();
        String password = passLogin.getText().toString();

        /* Jika form user kosong atau TIDAK memenuhi kriteria di Method cekUser() maka, Set error
         *  di Form User dengan menset variable fokus dan error di Viewnya juga cancel menjadi true*/
        if (TextUtils.isEmpty(user)){
            emailLogin.setError("This field is required");
            fokus = emailLogin;
            cancel = true;
        }else if(!cekUser(user)){
            emailLogin.setError("This Username is not found");
            fokus = emailLogin;
            cancel = true;
        }

        /* Sama syarat percabangannya dengan User seperti di atas. Bedanya ini untuk Form Password*/
        if (TextUtils.isEmpty(password)){
            passLogin.setError("This field is required");
            fokus = passLogin;
            cancel = true;
        }else if (!cekPassword(password)){
            passLogin.setError("This password is incorrect");
            fokus = passLogin;
            cancel = true;
        }

        /* Jika cancel true, variable fokus mendapatkan fokus */
        if (cancel) fokus.requestFocus();
        else ToHome();
    }

    private void ToHome() {
        Preferences.setLoggedInUser(getBaseContext(), Preferences.getRegisteredUser(getBaseContext()));
        Preferences.setLoggedInStatus(getBaseContext(),true);
        startActivity(new Intent(getBaseContext(),HomeActivity.class));
        finish();
    }

    private boolean cekPassword(String password){
        return password.equals(Preferences.getRegisteredPass(getBaseContext()));
    }

    /** True jika parameter user sama dengan data user yang terdaftar dari Preferences */
    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}