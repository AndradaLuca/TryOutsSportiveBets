package com.example.marius.sportivebets.database;

import com.example.marius.sportivebets.database.entity.User;

import java.util.List;

public class Data {

    public static List<User> users;
    private User user1;

    public Data() {
        users.add(new User("2970312125857", "andrada", "andradaa.luca@gmail.com", "asdds", "andrada", 0));
    }


}
