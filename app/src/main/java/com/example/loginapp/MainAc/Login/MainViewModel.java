package com.example.loginapp.MainAc.Login;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.loginapp.DangNhap.HomeActivity;
import com.example.loginapp.Database.FireBaseAuth.FireBaseAuth;
import com.example.loginapp.Models.User;

public class MainViewModel extends AndroidViewModel {
    FireBaseAuth mAuth;

    public MainViewModel(@NonNull Application application) {
       super(application);
       mAuth = new FireBaseAuth(application);
    }

    public void login(String email, String password, LoginSuccess loginSuccess){
        mAuth.dangNhap(email, password, result -> {
            loginSuccess.success(true);

        });
    }

    public interface LoginSuccess{
        void success(boolean result);
    }

}
