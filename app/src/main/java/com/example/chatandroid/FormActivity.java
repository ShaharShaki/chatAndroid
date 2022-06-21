package com.example.chatandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.chatandroid.api.UserAPI;

public class FormActivity extends AppCompatActivity {

    private contactDB db;
    private ContactUsersDao contactUsersDao;
    private EditText editTextItem;
 //   private ContactUser contactUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        db = Room.databaseBuilder(getApplicationContext(), contactDB.class, "UsersDB")
                .allowMainThreadQueries()
                .build();

        contactUsersDao = db.contactUsersDao();

        Intent intent1 = getIntent();
        String currentUser = intent1.getStringExtra("currentUser");



        //???
        /*
        if (getIntent().getExtras() != null) {
            String id = getIntent().getExtras().getString("id");
//            contactUser = contactUsersDao.get();
          //  editTextItem.setText(contactUser.getContent());
        }
*/      ContactUser user = new ContactUser();
        Button btnSave = findViewById(R.id.btnSave);
        btnSave.setOnClickListener(v -> {
            EditText nickname = findViewById(R.id.editTextNickname);
            EditText server = findViewById(R.id.editServer);
            EditText name = findViewById(R.id.editTextItem);
            user.setName(nickname.getText().toString());
            user.setId(name.getText().toString());
            user.setServer(server.getText().toString());
            if(user != null) {
            //    contactUser.setContent(editTextItem.getText().toString());
                user.setCurrentUserLogin(currentUser);

                UserAPI userAPI = new UserAPI(contactUsersDao);
                userAPI.postContact(user,currentUser);
              //  contactUsersDao.update(user);

                contactUsersDao.insert(user);

                //contactUsersDao.update();
            }
           // else {
             //   ContactUser contactUser = new ContactUser(0, editTextItem.getText().toString());
             //   contactUsersDao.insert(contactUser);
           // }
            finish();
//            Intent i4 = new Intent(this, ContactsListActivity.class);
//            startActivity(i4);
        });
    }
}