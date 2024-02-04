package com.example.sharedprefrences;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class frontPage extends AppCompatActivity {

    Button letsGoButt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);

        letsGoButt = findViewById(R.id.letsGoButt);

        letsGoButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences pref = getSharedPreferences("login", MODE_PRIVATE);
                Boolean check = pref.getBoolean("flag", false);

                Intent iNext;
                if(check){
                    iNext = new Intent(frontPage.this, MainActivity.class);
                }
                else {
                    iNext = new Intent(frontPage.this, loginPage.class);
                }
                startActivity(iNext);
            }
        });

    }
}