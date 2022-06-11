package com.example.chatandroid.entities;

import java.util.List;

@Entity
public class User {
    @PrimaryKey(autoGenerate = true)

    private String Name;
    private String Password;
    private String Server;
    private String Lastdate;
    private String Id;
    private List<User> Contacts;
//    private List<Conversation> Conversations { get; set; }


    public User(String name, String password, String server, String lastdate, String id, List<User> contacts) {
        Name = name;
        Password = password;
        Server = server;
        Lastdate = lastdate;
        Id = id;
        Contacts = contacts;
    }

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

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public List<User> getContacts() {
        return Contacts;
    }

    public void setContacts(List<User> contacts) {
        Contacts = contacts;
    }
}