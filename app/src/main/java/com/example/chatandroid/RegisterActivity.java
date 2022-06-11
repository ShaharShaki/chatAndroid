package com.example.chatandroid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private final int GALLERY_REQ_CODE = 1000;
    ImageView imgGallery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        EditText username = findViewById(R.id.editTextTextPersonName);
        EditText password = findViewById(R.id.editTextTextPassword);
        EditText password2 = findViewById(R.id.registerPasswordValidation);

        ImageView imgGallery = findViewById(R.id.imgGallery);
        Button btnGallery = findViewById(R.id.btnImg);

        Button Submit = findViewById(R.id.btnSubmit);
        Submit.setOnClickListener(v -> {
            if ((password.getText().toString().equals(password2.getText().toString())) &&
                    !(MainActivity.usernamesList.contains(username.getText().toString()))) {
                MainActivity.usernamesList.add(username.getText().toString());
                MainActivity.usernamesList.add(password.getText().toString());
                Intent i2 = new Intent(this, MainActivity.class);
                startActivity(i2);
            }
            else {
                popupMessage();
//                onCreate(savedInstanceState);
            }

        });

//        btnGallery.setOnClickListener(v -> {
//            Intent iGallery = new Intent(Intent.ACTION_PICK);
//            iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//            startActivityForResult(iGallery, GALLERY_REQ_CODE);
//        });
    }

//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (resultCode == RESULT_OK) {
//            if(requestCode == GALLERY_REQ_CODE) {
//                imgGallery.setImageURI(data.getData());
//            }
//        }
//    }


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