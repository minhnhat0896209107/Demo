package com.example.loginapp.DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.loginapp.Home.Achievement;
import com.example.loginapp.Home.Chat;
import com.example.loginapp.Home.Profile;
import com.example.loginapp.Home.Target;
import com.example.loginapp.R;

public class HomeActivity extends AppCompatActivity {
    Button btnbacktoSingin;
    LinearLayout target, chat, profile, achieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);

        btnbacktoSingin = findViewById(R.id.btn_backtoSignin);
        target = findViewById(R.id.target);
        chat = findViewById(R.id.chat);
        profile = findViewById(R.id.profile);
        achieve = findViewById(R.id.achieve);

        btnbacktoSingin.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
        target.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Target.class);
            startActivity(intent);
        });
        chat.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Chat.class);
            startActivity(intent);
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Profile.class);
            startActivity(intent);
        });
        achieve.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Achievement.class);
            startActivity(intent);
        });
    }
}