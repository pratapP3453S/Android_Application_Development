package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//        initalization
        EditText feet, inch, weight;
        Button calculatebmi;
        TextView result;
        LinearLayout window;

//        get by id
        feet = findViewById(R.id.feet);
        inch = findViewById(R.id.inch);
        weight = findViewById(R.id.weight);
        calculatebmi = findViewById(R.id.calculatebmi);
        result = findViewById(R.id.result);
        window = findViewById(R.id.window);



//        calculating main logic of bmi
        calculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //        getting value (converting to string)
                int calfeet = Integer.parseInt(feet.getText().toString());
                int calinch = Integer.parseInt(inch.getText().toString());
                int calweight = Integer.parseInt(weight.getText().toString());

                int height = calfeet*12 + calinch;
                double heightInCM = height*2.53;
                double heightInMeter = heightInCM/100;
                double calculatedbmi = calweight/(heightInMeter*heightInMeter);

//        condition
                if(calculatedbmi>26){
                    result.setText("OverWeight");
                    window.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(calculatedbmi<19){
                    result.setText("UnderWeight");
                    window.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else{
                    result.setText("Healthy Weight !");
                    window.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });
    }
}