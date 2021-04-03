package com.example.loginapp.activities.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.service.controls.templates.ControlTemplate;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;


import com.example.loginapp.activities.home.HomeActivity;
import com.example.loginapp.database.firebase_auth.FireBaseAuth;
import com.example.loginapp.database.firebase_realtime.PushUser;

import org.w3c.dom.Text;


public class LoginViewModel extends AndroidViewModel {
    FireBaseAuth auth = new FireBaseAuth(getApplication());

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }


    public void login(String email, String password, LoginSuccess loginSuccess) {
            auth.dangNhap(email, password, result -> {
                loginSuccess.success(true);
            });
    }

    public interface LoginSuccess {
        void success(boolean result);
    }

}
