package com.example.chatandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ContactsListActivity extends AppCompatActivity {
    private contactDB db;
    private ContactUsersDao contactUsersDao;
    private List<ContactUser> contactUsers;
//    private ArrayAdapter<ContactUser> adapter;
    private ContactsListAdapter adapter;
    private ListView myContactsListView;
    private ArrayList<ContactUser> tempList = new ArrayList<>();
    private ContactUsersDao dao;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contactslist);

        db = Room.databaseBuilder(getApplicationContext(), contactDB.class, "contactsDB").allowMainThreadQueries().build();
        dao = db.contactUsersDao();

        tempList.add(new ContactUser("Ido", "Ido2", "2222", "asdasd", "20:00"));
        tempList.get(0).setCurrentUserLogin("Shahar");

        tempList.add(new ContactUser("eeee", "Ido3", "2222", "asdasd", "19:40"));
        tempList.get(1).setCurrentUserLogin("Shahar");

        tempList.add(new ContactUser("tttt", "Ido4", "2222", "asdasd", "18:32"));
        tempList.get(2).setCurrentUserLogin("Shahar");

        tempList.add(new ContactUser("Ido4", "Ido5", "2222", "asdasd", "10:22"));
        tempList.get(3).setCurrentUserLogin("Erel");

        for(int i = 0; i < 4; i++) {
            try {
                dao.insert(tempList.get(i));
            }
            catch (Exception e) {
                dao.update(tempList.get(i));
            }
        }

        Intent intent1 = getIntent();
        String username1 = intent1.getStringExtra("username");

        ArrayList<ContactUser> contactsList = new ArrayList<>(dao.get(username1));

        FloatingActionButton BtnAdd = findViewById(R.id.BtnAdd);
        BtnAdd.setOnClickListener(v -> {
            Intent in = new Intent(this, FormActivity.class);
            startActivity(in);
        });

        myContactsListView = findViewById(R.id.myContactsListView);
//        adapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_list_item_1, dao.get(username1));

        adapter = new ContactsListAdapter(getApplicationContext(), contactsList);

        myContactsListView.setAdapter(adapter);

//        myContactsListView.setOnItemLongClickListener((adapterView, view, i, l) -> {
////            ContactUser contactUser = tempList.remove(i);
////            contactUsersDao.delete(contactUser);
////            adapter.notifyDataSetChanged();
////            return true;
////        });

        myContactsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Intent intent = new Intent(getApplicationContext(), ChatActivity.class);

                intent.putExtra("username", tempList.get(i).getName());
                intent.putExtra("lastMessage", tempList.get(i).getLast());
                intent.putExtra("time", tempList.get(i).getLastdate());

                startActivity(intent);



            }
        });


//
//        myContactsListView.setOnItemClickListener((adapterView, view, i, l) ->{
//            String username = contactUsers.get(i).getName();
//            Intent intent = new Intent(this, ChatActivity.class);
//            intent.putExtra("username",username);
//            startActivity(intent);
//        });

    }

//    @Override
//    protected void onResume()
//    {
//        super.onResume();
//        contactUsers.clear();
//        adapter.set
//        contactUsers.addAll(dao.get());
//        adapter.notifyDataSetChanged();
//    }
}