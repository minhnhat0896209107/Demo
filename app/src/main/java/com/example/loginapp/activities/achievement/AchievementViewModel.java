package com.example.loginapp.activities.achievement;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.loginapp.adapter.AchieveAdapter;
import com.example.loginapp.models.Achieve;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class AchievementViewModel extends ViewModel {
    FirebaseAuth mAuth;
    Context mContext;
    public AchievementViewModel(Context context){
        mAuth = FirebaseAuth.getInstance();
        this.mContext = context;
    }

    public String layKey(){
        String keyId = FirebaseDatabase.getInstance().getReference().child("Achievement").getKey();
        return keyId;
    }
}
