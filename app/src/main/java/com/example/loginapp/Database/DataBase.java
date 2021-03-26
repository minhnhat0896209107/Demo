package com.example.loginapp.Database;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class DataBase {
    public void inPutData(){
        Used1();
        Used2();
    }
    public void Used1(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", "nhat@gmail.com");
        map.put("phone", "0896209107");
        map.put("user", "nguyen van minh nhat");

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("Target name","2 Week");
        map1.put("Start date","21/07/2000");
        map1.put("End date","21/07/2021");
        map1.put("Target",5);
        map1.put("Used", 1);

        FirebaseDatabase.getInstance().getReference().push()
                .child("User1").updateChildren(map);

        FirebaseDatabase.getInstance().getReference()
                .child("Home").push().updateChildren(map1);
    }
    public void Used2(){
        HashMap<String, Object> map = new HashMap<>();
        map.put("email", "nhat@gmail.com");
        map.put("phone", "0896209107");
        map.put("user", "nguyen van minh nhat");

        HashMap<String, Object> map1 = new HashMap<>();
        map1.put("Target name","1 Week");
        map1.put("Start date","24/01/2000");
        map1.put("End date","05/04/2021");
        map1.put("Target",6);
        map1.put("Used", 2);

        FirebaseDatabase.getInstance().getReference().push()
                .child("User2").updateChildren(map);
        FirebaseDatabase.getInstance().getReference()
                .child("Home").push().updateChildren(map1);
    }
}
