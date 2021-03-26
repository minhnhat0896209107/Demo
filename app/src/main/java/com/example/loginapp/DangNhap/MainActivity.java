package com.example.loginapp.DangNhap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.Database.DataBase;
import com.example.loginapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView tvforgot, tvdangky;
    Button btnDangNhap;
    EditText edtTk, edtMk;
    FirebaseAuth mAuth;
    DataBase mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);

        init();
        mAuth = FirebaseAuth.getInstance();
        tvdangky.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, SignUp.class);
            startActivity(i);
        });
        tvforgot.setOnClickListener(v -> {
            Intent i = new Intent(MainActivity.this, ForgotPassword.class);
            startActivity(i);
        });

        btnDangNhap.setOnClickListener(v -> {
            String Tk = edtTk.getText().toString().trim();
            String Mk = edtMk.getText().toString().trim();
            if (TextUtils.isEmpty(Tk) || TextUtils.isEmpty(Mk)) {
                Toast.makeText(this, "Invalid Information", Toast.LENGTH_SHORT).show();
            } else {
                dangNhap(Tk, Mk);
            }

        });
        mData = new DataBase();
        mData.inPutData();

    }

    private void init() {
        tvforgot = findViewById(R.id.tv_forgot);
        tvdangky = findViewById(R.id.tv_dangky);
        btnDangNhap = findViewById(R.id.btn_dangnhap);

        edtTk = findViewById(R.id.edt_TK);
        edtMk = findViewById(R.id.edt_MK);
    }

    private void dangNhap(String Tk, String Mk) {
        mAuth.signInWithEmailAndPassword(Tk, Mk).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}