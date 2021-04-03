package com.example.loginapp.activities.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.loginapp.R;
import com.example.loginapp.activities.forgot.ForgotPasswordActivity;
import com.example.loginapp.activities.home.HomeActivity;
import com.example.loginapp.activities.signup.SignUpActivity;
import com.example.loginapp.database.firebase_realtime.PushUser;


public class LoginActivity extends AppCompatActivity {
    TextView tvforgot, tvdangky;
    Button btnDangNhap;
    EditText edtTk, edtMk;
    Context mContext;
    LoginViewModel loginViewModel = new LoginViewModel(getApplication());
    long backPressedTime;
    PushUser pushUser;
    Toast mToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        init();

        tvdangky.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, SignUpActivity.class);
            startActivity(i);
            finish();
        });
        tvforgot.setOnClickListener(v -> {
            Intent i = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
            startActivity(i);
        });

        btnDangNhap.setOnClickListener(v -> {
            String tk = edtTk.getText().toString().trim();
            String mk = edtMk.getText().toString().trim();
            if (TextUtils.isEmpty(tk) || TextUtils.isEmpty(mk)){
                Toast.makeText(this, "Input information", Toast.LENGTH_SHORT).show();
            }
            else{
                loginViewModel.login(tk, mk, result -> {
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    Toast.makeText(this, "LoginSuccess", Toast.LENGTH_SHORT).show();
                    this.finish();
                });
            }
            
        });

    }

    private void init() {
        tvforgot = findViewById(R.id.tv_forgot);
        tvdangky = findViewById(R.id.tv_dangky);
        btnDangNhap = findViewById(R.id.btn_dangnhap);

        edtTk = findViewById(R.id.edt_TK);
        edtMk = findViewById(R.id.edt_MK);
    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()) {
            mToast.cancel();
            super.onBackPressed();
            return;
        } else {
            mToast = Toast.makeText(this, "Press back again to exit the application", Toast.LENGTH_SHORT);
            mToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }
}