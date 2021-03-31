package com.example.loginapp.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.R;
import com.example.loginapp.activities.login.MainActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    TextView tvhaveAccount;
    Button btndangkytc;
    EditText edtUser,edtEmail, edtPassword, edtPhone;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();

        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_sign_up);
        init();
        mAuth = FirebaseAuth.getInstance();
        tvhaveAccount.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
        });

        btndangkytc.setOnClickListener(v -> {
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
                dangKy(email, phone);
            }

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
    private void dangKy(String email, String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(SignUp.this, "Sign Up Successfully", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(SignUp.this, "Sign Up Invalid", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}