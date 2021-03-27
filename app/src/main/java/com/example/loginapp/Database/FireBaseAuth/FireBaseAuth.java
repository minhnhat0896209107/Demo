package com.example.loginapp.Database.FireBaseAuth;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.example.loginapp.Activity.Login.MainActivity;
import com.example.loginapp.DangNhap.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class FireBaseAuth {
    FirebaseAuth auth;
    private Application context;

    public FireBaseAuth(Application context) {
        auth =  FirebaseAuth.getInstance();
        this.context = context;
    }

    public void dangNhap(String tk, String mk, CallBack callBack){
        auth.signInWithEmailAndPassword(tk, mk).addOnCompleteListener((Executor) context, task -> {
            if (task.isSuccessful()){
                callBack.success(true);
            }
            else {
                Toast.makeText(context, "Loi Dang Nhap", Toast.LENGTH_SHORT).show();
                callBack.success(false);
            }
        });
    }
    public interface CallBack {
        void success(boolean result);
    }
}
