package com.example.loginapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.loginapp.home_models.Achievement;
import com.example.loginapp.home_models.Chat;
import com.example.loginapp.home_models.Profile;
import com.example.loginapp.home_models.Target;
import com.example.loginapp.R;
import com.example.loginapp.activities.login.MainActivity;

public class HomeActivity extends AppCompatActivity {
    Button btnbacktoSingin;
    LinearLayout target, chat, profile, achieve;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_home);

        btnbacktoSingin = findViewById(R.id.btn_backtoSignin);
        target = findViewById(R.id.target);
        chat = findViewById(R.id.chat);
        profile = findViewById(R.id.profile);
        achieve = findViewById(R.id.achieve);

        btnbacktoSingin.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
        target.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Target.class);
            startActivity(intent);
            finish();
        });
        chat.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Chat.class);
            startActivity(intent);
            finish();
        });
        profile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Profile.class);
            startActivity(intent);
            finish();
        });
        achieve.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, Achievement.class);
            startActivity(intent);
            finish();
        });
    }
}