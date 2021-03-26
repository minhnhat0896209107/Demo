package com.example.loginapp.DangNhap;

import androidx.annotation.LongDef;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.analytics.FirebaseAnalytics;
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
        setContentView(R.layout.activity_sign_up);
        init();
        mAuth = FirebaseAuth.getInstance();
        tvhaveAccount.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
        });

        btndangkytc.setOnClickListener(v -> {
            dangKy();
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
    private void dangKy(){
        String email = edtEmail.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        Log.d("AAA", email);
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