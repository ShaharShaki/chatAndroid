package com.example.chatandroid;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ContactUsersDao {

    @Query("SELECT * FROM contactuser")
    List<ContactUser> index();

    @Query("SELECT * FROM contactuser WHERE currentUserLogin = :currentUserLogin")
    List<ContactUser> get(String currentUserLogin);

    @Insert
    void insert(ContactUser... users);

    @Update
    void update(ContactUser... users);

    @Delete
    void delete(ContactUser... users);

}
