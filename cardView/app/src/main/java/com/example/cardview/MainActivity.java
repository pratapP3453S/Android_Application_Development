package com.example.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardView cardView;

        cardView = findViewById(R.id.cardding);
        cardView.setCardElevation(15.0f);
        cardView.setUseCompatPadding(true);

    }
}