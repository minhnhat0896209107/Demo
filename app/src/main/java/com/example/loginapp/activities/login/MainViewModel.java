package com.example.loginapp.activities.login;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.loginapp.activities.HomeActivity;
import com.example.loginapp.database.LoginUser;
import com.example.loginapp.database.firebase_auth.FireBaseAuth;

import java.util.ArrayList;
import java.util.List;

public class MainViewModel extends ViewModel {
    FireBaseAuth mAuth;
    List<LoginUser> mListLoginUser;
    MutableLiveData<List<LoginUser>> mListUserLoginData;
    Context mContext;
    public MainViewModel(Context context) {
        mListUserLoginData = new MutableLiveData<>();
        initData();
        this.mContext = context;
    }

    private void initData() {
        mListLoginUser = new ArrayList<>();
        mListUserLoginData.setValue(mListLoginUser);
    }

    public void login(String email, String password, LoginSuccess loginSuccess){
        mAuth.dangNhap(email, password, result -> {
            loginSuccess.success(true);
//            getListUserLoginData();
            mContext.startActivity(new Intent(mContext, HomeActivity.class));
        });
    }

    public interface LoginSuccess{
        void success(boolean result);
    }

    public MutableLiveData<List<LoginUser>> getListUserLoginData(){
        return mListUserLoginData;
    }

}
