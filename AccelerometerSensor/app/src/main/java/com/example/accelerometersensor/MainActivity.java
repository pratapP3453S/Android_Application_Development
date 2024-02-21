package com.example.accelerometersensor;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        if (sm != null){
            Sensor accleSensor = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
            if (accleSensor != null){
                sm.registerListener(this, accleSensor, SensorManager.SENSOR_DELAY_NORMAL);
            }
        }
        else {
            Toast.makeText(this, "No Sensor Feature Found In This Phone...", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
            ((TextView) findViewById(R.id.sensor)).setText("X : "+event.values[0]+ "Y : "+event.values[1]+" Z : "+event.values[2]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}