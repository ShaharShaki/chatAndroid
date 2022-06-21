package com.example.chatandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.chatandroid.api.UserAPI;

public class RegisterActivity extends AppCompatActivity {

    private final int GALLERY_REQ_CODE = 1000;
    ImageView imgGallery;
    private ContactUsersDao dao;
    private contactDB db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = Room.databaseBuilder(getApplicationContext(), contactDB.class, "UsersDB")
                .allowMainThreadQueries()
                .build();

        dao = db.contactUsersDao();

//        EditText username = findViewById(R.id.editTextTextPersonName);
//        EditText nickname = findViewById(R.id.editTextTextPersonNickname);
//        EditText password = findViewById(R.id.editTextTextPassword);
//        EditText password2 = findViewById(R.id.registerPasswordValidation);

//        ImageView imgGallery = findViewById(R.id.imgGallery);
        Button btnGallery = findViewById(R.id.btnImg);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, 3);
            }
        });


        Button Submit = findViewById(R.id.btnSubmit);
        Submit.setOnClickListener(v -> {
//            if ((password.getText().toString().equals(password2.getText().toString())) &&
//                    !(MainActivity.usernamesList.contains(username.getText().toString()))) {
                EditText username = findViewById(R.id.editTextTextPersonUsername);
                EditText nickname = findViewById(R.id.editTextTextPersonNickname);
                EditText password = findViewById(R.id.registerPassword);
                if (nickname.getText().toString()!= null) {
                    ContactUser user = new ContactUser(username.getText().toString(),nickname.getText().toString(),password.getText().toString());
                    UserAPI userAPI = new UserAPI(dao);
                    userAPI.registerUser(username.getText().toString(), nickname.getText().toString(), password.getText().toString());
                    user.setCurrentUserLogin(username.getText().toString());
                    dao.insert(user);
                 //   MainActivity.usernamesList.add(username.getText().toString());
                 //   MainActivity.usernamesList.add(password.getText().toString());
                }
                Intent i2 = new Intent(this, MainActivity.class);
                startActivity(i2);
               // finish();
//            } else {
//                popupMessage();
////                onCreate(savedInstanceState);
//            }

        });


    }


    public void popupMessage() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Not a valid input, please try again.");
        alertDialogBuilder.setTitle("Wrong input");
        alertDialogBuilder.setNegativeButton("ok", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d("internet", "Ok btn pressed");
                // add these two lines, if you wish to close the app:
                finishAffinity();
                System.exit(0);
            }
        });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            Uri selectedImage = data.getData();
            ImageView imageView = findViewById(R.id.imageView);
            imageView.setImageURI(selectedImage);
        }
    }
}