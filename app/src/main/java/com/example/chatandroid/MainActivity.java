package com.example.chatandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    static List<String> usernamesList;
    static List<String> passwordsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usernamesList = new ArrayList<String>();
        passwordsList = new ArrayList<String>();

        String username = findViewById(R.id.editTextTextPersonName).toString();
        String password = findViewById(R.id.editTextTextPassword).toString();

        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            Intent in = new Intent(this, ContactsListActivity.class);
                    startActivity(in);
        });

        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(v -> {
            Intent i2 = new Intent(this, RegisterActivity.class);
            startActivity(i2);
        });

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