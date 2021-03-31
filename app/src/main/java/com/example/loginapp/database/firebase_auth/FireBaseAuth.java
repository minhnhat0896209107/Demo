package com.example.loginapp.database.firebase_auth;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.databinding.Bindable;

import com.example.loginapp.activities.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class FireBaseAuth {
    FirebaseAuth auth;
    private Application application;
    Context mContext;

    public FireBaseAuth(Application application) {
        auth = FirebaseAuth.getInstance();
        this.application = application;
    }

    public void dangNhap(String tk, String mk, CallBack callBack) {
        auth.signInWithEmailAndPassword(tk, mk).addOnCompleteListener((Executor) application, task -> {
            if (task.isSuccessful()) {
                callBack.success(true);
            } else {
                callBack.success(false);
                Toast.makeText(application, "Loi Dang Nhap", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public interface CallBack {
        void success(boolean result);
    }

}
