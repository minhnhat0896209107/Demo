package com.example.loginapp.home_models;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.loginapp.adapter.AchieveAdapter;
import com.example.loginapp.activities.HomeActivity;
import com.example.loginapp.R;
import com.example.loginapp.models.Achieve;

import java.util.List;

public class Achievement extends AppCompatActivity {
    ImageView imgBack;
    AchieveAdapter achieveAdapter;
    RecyclerView rcvListAchievement;
    List<Achieve> mList;
    View mView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_achievement);
        init();

//        rcvListAchievement.setAdapter(achieveAdapter);

        imgBack.setOnClickListener(v -> {
            finish();
        });
    }
    private void init(){
        imgBack = findViewById(R.id.img_backachive);
//        mList = new ArrayList<>();
//        achieveAdapter = new AchieveAdapter(mList);
    }

}