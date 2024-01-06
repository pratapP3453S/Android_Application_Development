package com.example.intent_and_bundle_passing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1;

        button1 = findViewById(R.id.button1);

        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        intent.putExtra("title","Home");
        intent.putExtra("name","pratap");
        intent.putExtra("std", "sycs");
        intent.putExtra("rollno", 30);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });


    }
}