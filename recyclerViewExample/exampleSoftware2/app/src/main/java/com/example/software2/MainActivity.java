package com.example.software2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ArrayList<structure> arrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.firstDisplay);

        int columnCount = 2;

        recyclerView.setLayoutManager(new GridLayoutManager(this, columnCount));

        arrayList.add(new structure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.b, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.c, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.d, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.e, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.f, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.g, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.h, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.i, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.j, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.k, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.l, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.b, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.c, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.d, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.e, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.f, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.g, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.h, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.i, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.j, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.k, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.l, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.a, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.b, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.c, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.d, "Pratap", "8779709849"));
        arrayList.add(new structure(R.drawable.e, "Pratap", "8779709849"));

        mainMachine machine = new mainMachine(this, arrayList);
        recyclerView.setAdapter(machine);

    }
}