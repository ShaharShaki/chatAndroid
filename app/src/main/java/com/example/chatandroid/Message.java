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

    @PrimaryKey(autoGenerate = false)
    private int id;
    private String firstUser;
    private String secondUser;
    private String content;
    private String created;
    private boolean sent;


    public Message(String firstUser1, String secondUser1, String message1, String created1, boolean sent1) {
        firstUser = firstUser1;
        secondUser = secondUser1;
        content = message1;
        created = created1;
        sent = sent1;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
