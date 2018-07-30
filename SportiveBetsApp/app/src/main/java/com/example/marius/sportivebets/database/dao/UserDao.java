package com.example.marius.sportivebets.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marius.sportivebets.database.entity.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select * From User where email = :username & password = :pass ")
    User findByUsernameAndPAssword(String username, String pass);
//    @Query("select * from User")
//    List<User> getUsers();




}

