package com.example.chatandroid;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Message.class}, version = 1)
public abstract class messagesDB extends RoomDatabase {

    public abstract messagesDao messagesDao();
}
