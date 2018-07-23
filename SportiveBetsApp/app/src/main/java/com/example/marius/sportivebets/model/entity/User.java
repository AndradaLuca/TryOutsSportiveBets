package com.example.marius.sportivebets.model.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "User")
public class User {


    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "CNP")
    private String CNP;

    @NonNull
    private String name;

    @NonNull
    private String mail;

    @NonNull
    private String address;

    @NonNull
    private String password;

    @NonNull
    private double mouney;

    public User() {
    }


    public User(@NonNull String CNP, @NonNull String name, @NonNull String mail, @NonNull String address, @NonNull String password, @NonNull double mouney) {
        this.CNP = CNP;
        this.name = name;
        this.mail = mail;
        this.address = address;
        this.password = password;
        this.mouney = mouney;
    }


    @NonNull
    public String getCNP() {
        return CNP;
    }

    public void setCNP(@NonNull String CNP) {
        this.CNP = CNP;
    }

    @NonNull
    public String getName() {
        return name;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }

    @NonNull
    public String getMail() {
        return mail;
    }

    public void setMail(@NonNull String mail) {
        this.mail = mail;
    }

    @NonNull
    public String getAddress() {
        return address;
    }

    public void setAddress(@NonNull String address) {
        this.address = address;
    }

    @NonNull
    public String getPassword() {
        return password;
    }

    public void setPassword(@NonNull String password) {
        this.password = password;
    }

    @NonNull
    public double getMouney() {
        return mouney;
    }

    public void setMouney(@NonNull double mouney) {
        this.mouney = mouney;
    }
}
