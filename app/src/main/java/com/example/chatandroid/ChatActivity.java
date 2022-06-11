package com.example.chatandroid;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    private AppDB db;
    private ContactUsersDao contactUsersDao;
    private EditText editTextItem;
    private ContactUser contactUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

//        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "UsersDB")
//                .allowMainThreadQueries()
//                .build();
//
//        contactUsersDao = db.contactUsersDao();
//
//        editTextItem = findViewById(R.id.editTextItem);
//
//
//        if (getIntent().getExtras() != null) {
//            int id = getIntent().getExtras().getInt("id");
//            contactUser = contactUsersDao.get(id);
//            editTextItem.setText(contactUser.getContent());
//        }
    }

}