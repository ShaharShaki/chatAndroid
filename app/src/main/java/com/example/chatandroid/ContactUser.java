package com.example.chatandroid;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ContactUser {


    @PrimaryKey(autoGenerate=true)
    private int ID;
    private String id;
    private String name;
    private String server;
    private String last;
    private String lastdate;


    public ContactUser(int ID, String id, String name, String server, String last, String lastdate) {
        this.ID = ID;
        this.id = id;
        this.name = name;
        this.server = server;
        this.last = last;
        this.lastdate = lastdate;
    }

    public ContactUser() {
    }

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }


    public String getID() {
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