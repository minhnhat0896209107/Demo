package com.example.loginapp.database.firebase_auth;

import android.app.Application;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.concurrent.Executor;

public class FireBaseAuth {
    FirebaseAuth auth;
    private Application application;

    public FireBaseAuth(Application application) {
        auth = FirebaseAuth.getInstance();
        this.application = application;
    }

    public void dangNhap(String tk, String mk, CallBack callBack) {
            auth.signInWithEmailAndPassword(tk, mk).addOnCompleteListener(task -> {
                if (task.isSuccessful()) {
                    callBack.success(true);

                }
                else {
                    callBack.success(false);
                }
            });
    }
    public void dangKy(String email, String password, CallBack callBack){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()){
                        callBack.success(true);
                    }
                    if (task.isCanceled()){
                        callBack.success(false);
                    }
                });
    }

    public interface CallBack {
        void success(boolean result);
    }

}
