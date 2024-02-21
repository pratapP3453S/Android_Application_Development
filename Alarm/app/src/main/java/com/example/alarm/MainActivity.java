package com.example.alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    static final int REQ_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        findViewById(R.id.alarmButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int timeGiven = Integer.parseInt(((EditText)(findViewById(R.id.editText))).getText().toString());
                long time = System.currentTimeMillis()+(timeGiven* 1000L);

                Intent intent = new Intent(MainActivity.this, BroadCastReciver.class);

                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this, REQ_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP, time, pendingIntent);
            }
        });

    }
}