package com.example.listviewspinnerandautocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> names = new ArrayList<String>();
    ListView listView;
    Spinner spinner;

    AutoCompleteTextView actv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        listView = findViewById(R.id.listview);
//        spinner = findViewById(R.id.spinner);
          actv = findViewById(R.id.autocomp);
        names.add("ram");
        names.add("raman");
        names.add("roju");
        names.add("ranku");
        names.add("ramu");
        names.add("ramu kaka");
        names.add("rinku");
        names.add("rinku kaki");
        names.add("rambha");
        names.add("ramesh");
        names.add("raidu");
        names.add("rajpal");
        names.add("ramalu");
        names.add("ramanujan");
        names.add("ayush");
        names.add("vikram");
        names.add("ankush");
        names.add("nitin");
        names.add("vedant");
        names.add("rohit");
        names.add("lakshman");
        names.add("prashant");

//        ArrayAdapter<String> adp = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1,names);
//        listView.setAdapter(adp);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                if (position==0){
//                    Toast.makeText(MainActivity.this, "khatam tata bye bye", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });

//        ArrayAdapter<String> adp = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,names);
//        spinner.setAdapter(adp);

        ArrayAdapter<String> adp = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_spinner_dropdown_item,names);
        actv.setAdapter(adp);
        actv.setThreshold(1);


    }
}