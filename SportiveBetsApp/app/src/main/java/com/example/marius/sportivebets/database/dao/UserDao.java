package com.example.marius.sportivebets.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marius.sportivebets.database.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select name From User where name=:username & password = :pass ")
    String findByUsernameAndPAssword(String username, String pass);

    @Query("SELECT * FROM User")
    List<User> getAll();



}

