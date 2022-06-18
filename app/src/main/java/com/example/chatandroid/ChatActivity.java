package com.example.chatandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ChatActivity extends AppCompatActivity {

    private contactDB db;
    private ContactUsersDao contactUsersDao;
    private EditText editTextItem;
    private ContactUser contactUser;
    TextView userNameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        userNameView = findViewById(R.id.user_name);
        Intent activityIntent = getIntent();

        if(activityIntent != null) {
            String userName = activityIntent.getStringExtra("userName");

            userNameView.setText(userName);
        }



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