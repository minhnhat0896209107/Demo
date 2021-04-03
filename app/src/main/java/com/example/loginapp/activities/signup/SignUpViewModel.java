package com.example.loginapp.activities.signup;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Application;
import android.text.TextUtils;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.loginapp.database.firebase_auth.FireBaseAuth;
import com.google.firebase.auth.FirebaseAuth;

public class SignUpViewModel extends AndroidViewModel {
    FireBaseAuth auth = new FireBaseAuth(getApplication());
    public SignUpViewModel(@NonNull Application application) {
        super(application);
    }

    public void signUp(String email, String password, SignUpSuccess signUpSuccess){
        signUpSuccess.success(false);
        auth.dangKy(email, password, result -> {
            signUpSuccess.success(true);
        });
    }

    public interface SignUpSuccess{
        void success(boolean result);
    }
}
