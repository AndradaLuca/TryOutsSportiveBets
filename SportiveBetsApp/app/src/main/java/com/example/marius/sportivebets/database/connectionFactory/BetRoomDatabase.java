package com.example.marius.sportivebets.database.connectionFactory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.marius.sportivebets.database.DataGenerator;
import com.example.marius.sportivebets.database.dao.UserDao;
import com.example.marius.sportivebets.database.entity.User;

import java.util.List;


@Database(entities = {User.class}, version = 2)
public abstract class BetRoomDatabase extends RoomDatabase {

    private static BetRoomDatabase instance;

    public abstract UserDao userDao();



    public static synchronized BetRoomDatabase getDatabase(final Context context) {




        if (instance == null)

            {
                instance = Room.databaseBuilder(context.getApplicationContext(), BetRoomDatabase.class, "user-database").build();

            }
        return instance;

    }


    public static void destroyInstance() {
        instance = null;
    }


    private void populateInitialData()
    {
        List<User>users= DataGenerator.generateUsers();

        beginTransaction();
        try {
            for (User user : users) {
                userDao().insertUser(user);
            }

            setTransactionSuccessful();
        }finally {
            endTransaction();
        }


    }
}
