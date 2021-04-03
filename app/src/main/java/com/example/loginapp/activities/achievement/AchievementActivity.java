package com.example.loginapp.activities.achievement;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.loginapp.activities.home.HomeActivity;
import com.example.loginapp.adapter.AchieveAdapter;
import com.example.loginapp.R;
import com.example.loginapp.models.Achieve;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class AchievementActivity extends AppCompatActivity {
    ImageView imgBack;
    FirebaseAuth mAuth;
    RecyclerView rcvAchieve;
    List<Achieve> mList = new ArrayList<>();
    AchieveAdapter achieveAdapter;
    Achieve achieve;
    AchievementViewModel achievementViewModel = new AchievementViewModel(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_achievement);

        init();
        imgBack.setOnClickListener(v -> {
            startActivity(new Intent(AchievementActivity.this, HomeActivity.class));
        });

       // achievement.pushData();

        //load data;
        rcvAchieve.hasFixedSize();
        rcvAchieve.setLayoutManager(new LinearLayoutManager(this));
        loadData();

    }
    private void init(){
        imgBack = findViewById(R.id.img_backachive);
        rcvAchieve = findViewById(R.id.rcv_listAchieve);
        mList = new ArrayList<>();

    }
    public void loadData(){
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Achievement");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot: snapshot.getChildren()){
                        achieve = (Achieve) dataSnapshot.child(achievementViewModel.layKey()).getValue(Achieve.class);
                        mList.add(achieve);
                        Log.d("achieve", achieve + "");
                    }
                }
                Log.d("data", snapshot + "");
                achieveAdapter = new AchieveAdapter(mList, getApplicationContext());
                rcvAchieve.setAdapter(achieveAdapter);
                achieveAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }


}