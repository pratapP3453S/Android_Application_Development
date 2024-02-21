package com.example.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseFile extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "PersonalContacts";
    private static final int VERSION = 1;
    private static final String TABLE_NAME = "AllMyContacts";
    private static final String CONTACT_ID = "contact_id";
    private static final String CONTACT_NAME = "contact_name";
    private static final String CONTACT_NUMBER = "contact_number";
    public DatabaseFile(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+TABLE_NAME+" ("+CONTACT_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+CONTACT_NAME+" TEXT, "+CONTACT_NUMBER+" TEXT"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
         onCreate(db);
    }

    public void insertData(String name, String number){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CONTACT_NAME, name);
        values.put(CONTACT_NUMBER, number);

        db.insert(TABLE_NAME, null, values);

    }

    public ArrayList<ContactModel> readData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM "+TABLE_NAME, null);

        ArrayList<ContactModel> arrayList = new ArrayList<>();

        while(cursor.moveToNext()){
            ContactModel contactModel = new ContactModel();
            contactModel.id = cursor.getInt(0);
            contactModel.name = cursor.getString(1);
            contactModel.number = cursor.getString(2);
            arrayList.add(contactModel);
        }

        cursor.close();
        return arrayList;
    }


    //method 1 to update from defined method
    public void updateData(ContactModel contactModel){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(CONTACT_NUMBER, contactModel.number);

        db.update(TABLE_NAME, values, CONTACT_ID+" = "+contactModel.id, null);
    }

    //method 2 to update from qurey
    public void updateData(int id, String name, String number){
        ContactModel model = new ContactModel();
        model.id = id;
        model.name = name;
        model.number = number;

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("UPDATE "+TABLE_NAME+" SET "+CONTACT_NUMBER+" = "+number+" WHERE "+CONTACT_ID+" = "+model.id);
    }

    public void deleteData(int id){
        SQLiteDatabase db = this.getWritableDatabase();

        ContactModel model = new ContactModel();
        model.id = id;

        db.execSQL("DELETE FROM "+TABLE_NAME+" WHERE "+CONTACT_ID+" = "+model.id);
    }

//    public void deleteData(ContactModel contactModel, String name){
//        SQLiteDatabase db = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put(CONTACT_NAME, contactModel.name);
//
//        db.delete(TABLE_NAME, CONTACT_NAME+" = "+name, null);
//    }
}
