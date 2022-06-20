package com.example.chatandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.chatandroid.api.UserAPI;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<String> usernamesList;
    static List<String> passwordsList;
    private ContactUsersDao dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // dao.update();

        usernamesList = new ArrayList<String>();
        passwordsList = new ArrayList<String>();

        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);


        if (!password.toString().isEmpty() && !username.toString().isEmpty()) {
        //    UserAPI userAPI = new UserAPI(dao);
         //   userAPI.validateLogin(username.getText().toString(), password);
        }

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            if (!password.toString().isEmpty() && !username.toString().isEmpty()) {
                UserAPI userAPI = new UserAPI(dao);
                userAPI.validateLogin(username.getText().toString(), password.getText().toString());
                Intent in = new Intent(this, ContactsListActivity.class);
                in.putExtra("username", username.getText().toString());
                startActivity(in);
            }
            //Intent in = new Intent(this, ContactsListActivity.class);
            //        in.putExtra("username", username.getText().toString());
            //        startActivity(in);
        });

        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> {
            Intent i2 = new Intent(this, RegisterActivity.class);
            startActivity(i2);
        });

        Button btnSettings = findViewById(R.id.btnSettings);


    }

    public void popupMessage(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Not a valid input, please try again.");
        alertDialogBuilder.setTitle("Wrong input");
        alertDialogBuilder.setNegativeButton("ok", new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("internet","Ok btn pressed");
                // add these two lines, if you wish to close the app:
                finishAffinity();
                System.exit(0);
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}