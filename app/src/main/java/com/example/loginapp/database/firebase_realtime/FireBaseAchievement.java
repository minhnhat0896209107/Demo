package com.example.loginapp.database.firebase_realtime;

import com.example.loginapp.models.Achieve;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class FireBaseAchievement {
    FirebaseAuth mAuth;
    Achieve achieve = new Achieve();
    public FireBaseAchievement(FirebaseAuth mAuth) {
        this.mAuth = mAuth;
    }


    public void pushData(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("Target name", "2 Week");
        map.put("Start date", "21/07/2000");
        map.put("End date", "21/07/2021");
        map.put("Target", "2");
        map.put("Used", "5");
        FirebaseDatabase.getInstance().getReference().child("Achievement").push().updateChildren(map);

    }

}
