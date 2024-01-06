package com.example.contactapp1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<imageStructure> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.front);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new imageStructure(R.drawable.a, "Pratap", "8779709849"));

        runMachine adapter = new runMachine(this, arrayList);
        recyclerView.setAdapter(adapter);



    }
}