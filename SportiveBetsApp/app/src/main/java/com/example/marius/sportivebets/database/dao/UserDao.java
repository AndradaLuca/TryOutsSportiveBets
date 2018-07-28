package com.example.marius.sportivebets.database.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marius.sportivebets.database.entity.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select * From User where name=:username & password = :pass ")
    LiveData<User> findByUsernameAndPAssword(String username, String pass);





}

