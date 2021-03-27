package com.example.loginapp.Activity.Login;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.Bindable;
import androidx.lifecycle.AndroidViewModel;

import com.example.loginapp.BR;
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
