package com.example.chatandroid;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ContactUser {

    @PrimaryKey(autoGenerate=true)
    private long id;
//    private int id;
//    private String content;

    private String Name;
    private String Password;
    private String Server;
    private String Lastdate;

//    private List<ContactUser> Contacts;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getServer() {
        return Server;
    }

    public void setServer(String server) {
        Server = server;
    }

    public String getLastdate() {
        return Lastdate;
    }

    public void setLastdate(String lastdate) {
        Lastdate = lastdate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        id = id;
    }

//    public List<ContactUser> getContacts() {
//        return Contacts;
//    }

//    public void setContacts(List<ContactUser> contacts) {
//        Contacts = contacts;
//    }
//    //    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    public ContactUser(int id, String content) {
//        this.id = id;
//        this.content = content;
//    }

    public ContactUser() {
    }

    @Override
    public String toString() {
        return "ContactUser{" + "id=" + id + ", content='"  + '\'' + '}';
    }
}
