package com.example.chatandroid;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Message {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Message(){}

    @PrimaryKey(autoGenerate = true)
    private int id;
    private String firstUser;
    private String secondUser;
    private String message;


    public Message(String firstUser1, String secondUser1, String message1) {
        firstUser = firstUser1;
        secondUser = secondUser1;
        message = message1;
    }

    public String getFirstUser() {
        return firstUser;
    }

    public void setFirstUser(String firstUser) {
        this.firstUser = firstUser;
    }

    public String getSecondUser() {
        return secondUser;
    }

    public void setSecondUser(String secondUser) {
        this.secondUser = secondUser;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
