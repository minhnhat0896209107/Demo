package com.example.loginapp.viewmodels;

import android.app.Application;

import androidx.lifecycle.ViewModel;


import com.example.loginapp.database.firebase_auth.FireBaseAuth;


public class MainViewModel extends ViewModel {
    FireBaseAuth mAuth;
    Application mContext;

    public MainViewModel(Application context) {
        this.mContext = context;
    }


    public void login(String email, String password, LoginSuccess loginSuccess) {
        mAuth.dangNhap(email, password, result -> {
            loginSuccess.success(true);
        });
    }

    public interface LoginSuccess {
        void success(boolean result);
    }
}
