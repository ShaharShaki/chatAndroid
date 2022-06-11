package com.example.chatandroid;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class FormActivity extends AppCompatActivity {

    private AppDB db;
    private ContactUsersDao contactUsersDao;
    private EditText editTextItem;
    private ContactUser contactUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "UsersDB")
                .allowMainThreadQueries()
                .build();

        contactUsersDao = db.contactUsersDao();

        editTextItem = findViewById(R.id.editTextItem);

        if (getIntent().getExtras() != null) {
            int id = getIntent().getExtras().getInt("id");
            contactUser = contactUsersDao.get(id);
            editTextItem.setText(contactUser.getPassword());
        }

        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            if(contactUser != null) {
                contactUser.setPassword(editTextItem.getText().toString());
                contactUsersDao.update(contactUser);
            }
            else {
//                ContactUser contactUser = new ContactUser(0, editTextItem.getText().toString());
                contactUsersDao.insert(contactUser);
            }

            finish();
        });
    }
}