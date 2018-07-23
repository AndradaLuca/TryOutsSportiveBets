package com.example.marius.sportivebets.model.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marius.sportivebets.model.entity.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select name From User where name=:username & password = :pass ")
    LiveData<String> serchLogin(String username,String pass);

}

