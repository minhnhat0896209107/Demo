package com.example.loginapp.home_models;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.loginapp.activities.HomeActivity;
import com.example.loginapp.DuLieu.Catelogy;
import com.example.loginapp.DuLieu.CateloryAdapter;
import com.example.loginapp.R;

import java.util.ArrayList;
import java.util.List;

public class Target extends AppCompatActivity{
    ImageView imgBack;
    Spinner startdate, enddate, countcigarette;
    Spinner spinnertarget;
    CateloryAdapter target, start, end, count;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        View decorView = getWindow().getDecorView();
        // Hide the status bar.
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_target);
        init();

        imgBack.setOnClickListener(v -> {
            finish();
        });

        spinnertarget.setAdapter(target);
        spinnertarget.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        startdate.setAdapter(start);
        startdate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        enddate.setAdapter(end);
        enddate.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        countcigarette.setAdapter(count);
        countcigarette.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void init() {
        imgBack = findViewById(R.id.img_backtarget);
        startdate = findViewById(R.id.spin_startdate);
        enddate = findViewById(R.id.spin_enddate);
        countcigarette = findViewById(R.id.spin_count);
        spinnertarget = findViewById(R.id.spin_choosetarget);

        target = new CateloryAdapter(this, R.layout.item_selected, getListTarget());
        start = new CateloryAdapter(this, R.layout.item_selected, getListStartdate());
        end = new CateloryAdapter(this, R.layout.item_selected, getListEnddate());
        count = new CateloryAdapter(this, R.layout.item_selected, getListCount());
    }
    private List<Catelogy> getListTarget(){
        List<Catelogy> list = new ArrayList<>();
        list.add(new Catelogy("--Choose your target--"));
        list.add(new Catelogy("User"));
        list.add(new Catelogy("Chat"));
        list.add(new Catelogy("Target"));
        list.add(new Catelogy("Achivement"));
        return list;
    }
    private List<Catelogy> getListStartdate(){
        List<Catelogy> list = new ArrayList<>();
        list.add(new Catelogy("21/07/2000"));
        list.add(new Catelogy("01/01/2000"));
        list.add(new Catelogy("15/09/2010"));
        list.add(new Catelogy("02/03/2012"));
        return list;
    }
    private List<Catelogy> getListEnddate(){
        List<Catelogy> list = new ArrayList<>();
        list.add(new Catelogy("21/07/2020"));
        list.add(new Catelogy("01/01/2021"));
        list.add(new Catelogy("15/09/2019"));
        list.add(new Catelogy("02/03/2015"));
        return list;
    }
    private List<Catelogy> getListCount(){
        List<Catelogy> list = new ArrayList<>();
        list.add(new Catelogy("10 year"));
        list.add(new Catelogy("2 year"));
        list.add(new Catelogy("1 year"));
        list.add(new Catelogy("5 year"));
        return list;
    }
}