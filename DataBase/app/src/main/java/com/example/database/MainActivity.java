package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseFile dbf = new DatabaseFile(this);
//        dbf.insertData("Pratap", "8779709849");
//        dbf.insertData("Priti", "9324250016");
//        dbf.insertData("Suryakant", "8898879177");
//        dbf.insertData("Shalini", "7506215206");
//        dbf.insertData("Pratap", "3434343434");

        ArrayList<ContactModel> arrayList = dbf.readData();

//        for (int i=0; i<arrayList.size(); i++){
//            Log.d("CONTACT_INFO", "Name : "+arrayList.get(i).name+" , Phone Number : "+arrayList.get(i).number);
//            System.out.println("Name : "+arrayList.get(i).name+" , Phone Number : "+arrayList.get(i).number);
//        }

        //method 1 update
//        ContactModel model = new ContactModel();
//        model.id = 5;
//        model.number = "4444444444";
//        dbf.updateData(model);

        //method 2 update
//        dbf.updateData(5, "pratap", "44444444444");

        //method 1 delete for 1 item
//        dbf.deleteData(6);

        //method 2 delete for 1 or more item
//        ContactModel model = new ContactModel();
//        model.name = "Pratap";
//        dbf.deleteData(model, "Pratap");

        dbf.deleteData(10);
    }
}