package com.example.loginapp.activities.home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.loginapp.activities.achievement.AchievementActivity;
import com.example.loginapp.activities.chat.ChatActivity;
import com.example.loginapp.activities.proflie.ProfileActivity;
import com.example.loginapp.activities.target.TargetActivity;
import com.example.loginapp.R;
import com.example.loginapp.activities.login.LoginActivity;

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
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
        target.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, TargetActivity.class);
            startActivity(intent);
            finish();
        });
        chat.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ChatActivity.class);
            startActivity(intent);
            finish();
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            startActivity(intent);
            finish();
        });
        achieve.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, AchievementActivity.class);
            startActivity(intent);
            finish();
        });
    }
}