package com.example.phonenumberrecordapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddContactActivity extends AppCompatActivity {
    private Button btnSave;
    private EditText editName,editPhone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);
    }

    private void findViews(){
        btnSave = findViewById(R.id.btn_save);
        editName = findViewById(R.id.edit_name);
        editPhone = findViewById(R.id.edit_phone);
    }

    private void setListeners(){
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!editName.getText().toString().isEmpty() &&
                !editPhone.getText().toString().isEmpty()){
                    ContactsDBHelper dbHelper = new ContactsDBHelper(AddContactActivity.this);
                    Contact contact = new Contact();
                    contact.setName(editName.getText().toString());
                    contact.setPhoneNumber(editPhone.getText().toString());
                    dbHelper.insertContact(contact);
                }else{
                    if(editName.getText().toString().isEmpty()){
                        editName.setError("Cannot be empty");
                    }

                    if(editPhone.getText().toString().isEmpty()){
                        editPhone.setError("Cannot be empty");

                    }
                }
            }
        });
    }
}
