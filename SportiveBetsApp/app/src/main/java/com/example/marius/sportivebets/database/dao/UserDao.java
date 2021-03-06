package com.example.marius.sportivebets.database.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.marius.sportivebets.database.entity.User;

@Dao
public interface UserDao {

    @Insert
    void insertUser(User user);

    @Query("select * From User where Email = :email AND Password = :pass")
    User findByUsernameAndPAssword(String email, String pass);

    @Query("select * From User where Email = :email")
    User findUserForSubmit(String email);

    @Query("UPDATE User SET Ammount = :ammount  WHERE CNP = :CNP")
    void updateAmaunt(String CNP, Double ammount);

    @Query("UPDATE User SET password = :newPassword  WHERE email = :email")
    void updatePassword(String email, String newPassword);

    @Query("DELETE FROM User")
    public void nukeTable();








}

