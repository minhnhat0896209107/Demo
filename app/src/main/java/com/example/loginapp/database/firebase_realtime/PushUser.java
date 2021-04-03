package com.example.loginapp.database.firebase_realtime;

import com.google.firebase.database.FirebaseDatabase;

public class PushUser {
    public String pushKeyUID(){
        String keyId = FirebaseDatabase.getInstance().getReference().child("https://login-97956-default-rtdb").getKey();
        return keyId;
    }

}
