package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(MainActivity.this);

                View view = LayoutInflater.from(MainActivity.this).inflate(R.layout.custom_toast_layout,
                        (ViewGroup) findViewById(R.id.container));

                toast.setView(view);

                TextView txtmsg = view.findViewById(R.id.txtmsg);
                String text = "This is customized text edit at runtime";
                txtmsg.setText(text);

                toast.setDuration(Toast.LENGTH_LONG);

                toast.setGravity(Gravity.RIGHT|Gravity.TOP,0,0);

                toast.show();
            }
        });

    }
}