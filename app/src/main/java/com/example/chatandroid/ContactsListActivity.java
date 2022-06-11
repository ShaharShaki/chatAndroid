package com.example.chatandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ContactsListActivity extends AppCompatActivity {
    private AppDB db;
    private ContactUsersDao contactUsersDao;
    private List<ContactUser> contactUsers;
    private ArrayAdapter<ContactUser> adapter;
    private ListView myContactsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactslist);

        db = Room.databaseBuilder(getApplicationContext(), AppDB.class, "UsersDB")
                .allowMainThreadQueries()
                .build();

        contactUsersDao = db.contactUsersDao();

        FloatingActionButton BtnAdd = findViewById(R.id.BtnAdd);
        BtnAdd.setOnClickListener(v -> {
            Intent i = new Intent(this, FormActivity.class);
            startActivity(i);
        });

        contactUsers = new ArrayList<>();

        myContactsListView = findViewById(R.id.myContactsListView);
        adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, contactUsers);

        myContactsListView.setAdapter(adapter);

        myContactsListView.setOnItemLongClickListener((adapterView, view, i, l) -> {
            ContactUser contactUser = contactUsers.remove(i);
            contactUsersDao.delete(contactUser);
            adapter.notifyDataSetChanged();
            return true;
        });

//        myContactsListView.setOnClickListener( v -> {
//            Intent intent = new Intent(this, ChatActivity.class);
//            startActivity(intent);
//        });

        myContactsListView.setOnItemClickListener((adapterView, view, i, l) ->{
            Intent intent = new Intent(this, ChatActivity.class);
//            Intent intent = new Intent(this, FormActivity.class);
//            intent.putExtra("id", contactUsers.get(i).getId());
            startActivity(intent);
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        contactUsers.clear();
        contactUsers.addAll(contactUsersDao.index());
        adapter.notifyDataSetChanged();
    }
}