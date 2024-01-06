package com.example.intent_and_bundle_passing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        String name = intent.getStringExtra("name");
        String std = intent.getStringExtra("std");
        int rollno = intent.getIntExtra("rollno",0);

        TextView studenttxt;

        studenttxt = findViewById(R.id.studenttxt);

        studenttxt.setText("name : "+name+" std : "+std+" rollno : "+rollno);

//        getSupportActionBar().setTitle(title);



    }
}