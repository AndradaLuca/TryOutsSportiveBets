package com.example.marius.sportivebets.Db.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marius.sportivebets.Db.entity.User;

import java.util.List;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select name From users where name=:username & password = :pass ")
    LiveData<String> serchLogin(String username,String pass);

    @Query("select * from users")
    LiveData<List<User>> viewAllUsers();

}

