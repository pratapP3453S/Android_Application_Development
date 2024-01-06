package com.example.recyclerviewexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    recyclerContactAdapter adapter;
    recyclerContactAdapter.ViewHolder holder;
    ArrayList<contact_model> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.firstRCView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new contact_model(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new contact_model(R.drawable.b, "Ankush", "9898979695"));
        arrayList.add(new contact_model(R.drawable.c, "Rohit", "9059569595"));
        arrayList.add(new contact_model(R.drawable.d, "Deepak", "9546950696"));
        arrayList.add(new contact_model(R.drawable.e, "Vedant", "7898596857"));
        arrayList.add(new contact_model(R.drawable.f, "Abhishek", "7089597959"));
        arrayList.add(new contact_model(R.drawable.g, "Ritesh", "8909562873"));
        arrayList.add(new contact_model(R.drawable.h, "Om", "7859496399"));
        arrayList.add(new contact_model(R.drawable.i, "Laksman", "9966478385"));
        arrayList.add(new contact_model(R.drawable.j, "Akash", "7898944536"));
        arrayList.add(new contact_model(R.drawable.k, "Avkash", "99875752536"));
        arrayList.add(new contact_model(R.drawable.l, "Aman", "8774535348"));

        adapter = new recyclerContactAdapter(this, arrayList);
        recyclerView.setAdapter(adapter);

        FloatingActionButton actionButton;
        actionButton = findViewById(R.id.addtionButton);

        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.crud_operation_ui);

                EditText editName = dialog.findViewById(R.id.editName);
                EditText editNumber = dialog.findViewById(R.id.editNumber);
                Button operationButton = dialog.findViewById(R.id.operationButton);
                operationButton.setText("Add");
                TextView operationName = dialog.findViewById(R.id.operationName);
                operationName.setText("Add Contact");

                operationButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name = "", number = "";

                        if(editName.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Please enter name", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            name = editName.getText().toString();
                        }

                        if(editName.getText().toString().equals("")){
                            Toast.makeText(MainActivity.this, "Please enter number", Toast.LENGTH_SHORT).show();
                        }
                        else{
                            number = editNumber.getText().toString();
                        }

                        arrayList.add(new contact_model(R.drawable.contact, name, number));

                        adapter.notifyItemInserted(arrayList.size()-1);

                        recyclerView.scrollToPosition(arrayList.size()-1);

                        dialog.dismiss();

                    }
                });
                dialog.show();
            }
        });


    }
}