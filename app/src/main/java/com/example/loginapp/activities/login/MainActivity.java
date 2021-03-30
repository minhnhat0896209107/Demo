package com.example.loginapp.activities.login;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.loginapp.R;
import com.example.loginapp.activities.ForgotPassword;
import com.example.loginapp.activities.HomeActivity;
import com.example.loginapp.activities.SignUp;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    TextView tvforgot, tvdangky;
    Button btnDangNhap;
    EditText edtTk, edtMk;
    FirebaseAuth mAuth;
    MainViewModel mainViewModel = new MainViewModel(getApplication());
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
            String tk = edtTk.getText().toString().trim();
            String mk = edtMk.getText().toString().trim();

            if (TextUtils.isEmpty(tk) || TextUtils.isEmpty(mk)) {
                Toast.makeText(this, "Invalid Information", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    mainViewModel.login(tk, mk, result -> {
                        Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(MainActivity.this, HomeActivity.class));
                    });
                }catch (Exception e){
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    private void init() {
        tvforgot = findViewById(R.id.tv_forgot);
        tvdangky = findViewById(R.id.tv_dangky);
        btnDangNhap = findViewById(R.id.btn_dangnhap);

        edtTk = findViewById(R.id.edt_TK);
        edtMk = findViewById(R.id.edt_MK);
    }
}