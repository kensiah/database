package com.example.phonenumberrecordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListItem extends AppCompatActivity {
    private ListView listView;
    private ArrayList<Contact> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);

        listView = findViewById(R.id.list_view);

        ArrayAdapter<Contact> dataAdapter =
                new ArrayAdapter<Contact>(this,R.layout.activity_list_item,data);

        listView.setAdapter(dataAdapter);
    }
}
