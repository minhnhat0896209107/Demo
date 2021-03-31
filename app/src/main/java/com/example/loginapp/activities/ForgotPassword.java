package com.example.loginapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.loginapp.R;
import com.example.loginapp.activities.login.MainActivity;

public class ForgotPassword extends AppCompatActivity {
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_forgot_password);

        btnback = findViewById(R.id.btn_back);

        btnback.setOnClickListener(v -> {
            Intent i = new Intent(ForgotPassword.this, MainActivity.class);
            startActivity(i);
            finish();
        });
    }
}