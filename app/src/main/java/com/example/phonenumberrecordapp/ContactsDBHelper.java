package com.example.phonenumberrecordapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ContactsDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "MyDatabase.db";

    public ContactsDBHelper(Context context){
        super(context,DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Same as:
        // CREATE TABLE contacts (id INTEGER PRIMARY KEY, name TEXT, phoneNumber TEXT);
        db.execSQL(
                "CREATE TABLE " + Contact.TABLE_NAME
        + " (" + Contact.COLUMN_ID + "INTEGER PRIMARY KEY, "
        +Contact.COLUMN_NAME + "TEXT, "
        +Contact.COLUMN_PHONE_NUMBER + " TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +Contact.TABLE_NAME);
        onCreate(db);
    }

    public boolean insertContact(Contact contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contact.COLUMN_NAME, contact.getName());
        values.put(Contact.COLUMN_PHONE_NUMBER,contact.getPhoneNumber());
        db.insert(Contact.TABLE_NAME,null,values);
        return true;
    }

    public void updateContact(Contact contact){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contact.COLUMN_NAME, contact.getName());
        values.put(Contact.COLUMN_PHONE_NUMBER,contact.getPhoneNumber());
        db.update(Contact.TABLE_NAME,values,Contact.COLUMN_ID + " = ?",
                new String[]{Integer.toString(contact.getId())});
    }

    public void deleteContact(Integer id){

    }
}
