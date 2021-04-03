package com.example.loginapp.activities.signup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.R;
import com.example.loginapp.activities.home.HomeActivity;
import com.example.loginapp.activities.login.LoginActivity;

public class SignUpActivity extends AppCompatActivity {
    TextView tvhaveAccount;
    Button btndangkytc;
    EditText edtUser,edtEmail, edtPassword, edtPhone;
    SignUpViewModel signUpViewModel = new SignUpViewModel(getApplication());
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_sign_up);
        init();
        tvhaveAccount.setOnClickListener(v -> {
            Intent i = new Intent(SignUpActivity.this, LoginActivity.class);
            startActivity(i);
        });

        btndangkytc.setOnClickListener(v -> {
            showInformation();
        });
    }
    private void init(){
        tvhaveAccount = findViewById(R.id.tv_haveAccount);
        btndangkytc = findViewById(R.id.btn_dangkytc);
        edtUser = findViewById(R.id.edt_user);
        edtPassword = findViewById(R.id.edt_password);
        edtEmail = findViewById(R.id.edt_email);
        edtPhone = findViewById(R.id.edt_phone);
    }
    public void showInformation(){
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String user = edtUser.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(user) || TextUtils.isEmpty(phone)){
            Toast.makeText(this, "Please input information", Toast.LENGTH_SHORT).show();
        }else if(user.length() < 4){
            Toast.makeText(this, "Please input user than 4 characters", Toast.LENGTH_SHORT).show();

        }
        else if(!email.contains("@gmail.com")){
            Toast.makeText(this, "Please input email need @gmail.com", Toast.LENGTH_SHORT).show();

        }else if(password.length() < 5){
            Toast.makeText(this, "Please input password than 5 characters", Toast.LENGTH_SHORT).show();

        }
        else if(phone.length() < 9){
            Toast.makeText(this, "Please input phone than 9 characters", Toast.LENGTH_SHORT).show();

        }
        else{
            signUpViewModel.signUp(email, password,result -> {
                startActivity(new Intent(SignUpActivity.this, HomeActivity.class));
                Toast.makeText(this, "Sign Up Success", Toast.LENGTH_SHORT).show();
            });
        }
    }
}