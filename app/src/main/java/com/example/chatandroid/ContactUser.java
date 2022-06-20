package com.example.chatandroid;

import androidx.annotation.NonNull;
import androidx.room.Entity;

@Entity (primaryKeys = {"id", "currentUserLogin"})
public class ContactUser {



    @NonNull
    private String id;
    private String name;
    private String server;
    private String last;
    private String lastdate;
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ContactUser(@NonNull String id, String password) {
        this.id = id;
        this.password = password;
    }

    public String getCurrentUserLogin() {
        return currentUserLogin;
    }

    public void setCurrentUserLogin(String currentUserLogin) {
        this.currentUserLogin = currentUserLogin;
    }

    @NonNull
    private String currentUserLogin;


    public ContactUser(String id, String name, String server, String last, String lastdate) {
        this.id = id;
        this.name = name;
        this.server = server;
        this.last = last;
        this.lastdate = lastdate;
    }

    public ContactUser() {
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }


//    public ContactUser() {
//    }

    @Override
    public String toString() {
        return "ContactUser{" + "id=" + id + ", content='" + name + '\'' + '}';
    }
}