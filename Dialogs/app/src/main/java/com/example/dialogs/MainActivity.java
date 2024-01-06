package com.example.dialogs;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
Button firstButton, secondButton, thirdButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstButton = findViewById(R.id.firstButton);
        secondButton = findViewById(R.id.secondButton);
        thirdButton = findViewById(R.id.thirdButton);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                alertDialog.setIcon(R.drawable.baseline_content_paste_off_24);
                alertDialog.setTitle("Terms & Conditions");
                alertDialog.setMessage("Accept terms and conditions to proceed...");
                alertDialog.setButton(1,"Accept", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Yes you can proceed...", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setIcon(R.drawable.baseline_delete_24);
                alertDialog.setTitle("Delete ? ");
                alertDialog.setMessage("Are you sure want to delete...");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Item deleted;", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Item not delted", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.show();
            }
        });

        thirdButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setIcon(R.drawable.baseline_calendar_view_week_24);
                alertDialog.setTitle("Exit ? ");
                alertDialog.setMessage("Are you sure want to exit...");
                alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        MainActivity.super.getOnBackPressedDispatcher().onBackPressed();
                    }
                });
                alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(MainActivity.this, "Welcome back", Toast.LENGTH_SHORT).show();
                    }
                });
                alertDialog.setNeutralButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                alertDialog.show();
            }
        });

    }
}