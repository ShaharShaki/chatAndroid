package com.example.chatandroid;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ContactUser {

    @PrimaryKey(autoGenerate=true)
    private int id;
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ContactUser(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public ContactUser() {
    }

    @Override
    public String toString() {
        return "ContactUser{" + "id=" + id + ", content='" + content + '\'' + '}';
    }
}