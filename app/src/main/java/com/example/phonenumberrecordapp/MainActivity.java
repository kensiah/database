package com.example.phonenumberrecordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnAdd;
    private ListView listView;

    private ContactsDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
    }

    private void findViews(){
        btnAdd = findViewById(R.id.btn_add);
        listView = findViewById(R.id.list_view);
    }

    private void setListeners(){
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, AddContactActivity.class);
                startActivity(i);
            }
        });
    }

    private void setUpDatabase(){
        dbHelper = new ContactsDBHelper(this);
    }

    private void setUpAdapter(){
        ArrayList<Contact> contactList = new ArrayList<>();
        contactList = dbHelper.getAllContacts();

        ContactsAdapter adapter = new ContactsAdapter(this,contactList);
        listView.setAdapter(adapter);
    }

}
