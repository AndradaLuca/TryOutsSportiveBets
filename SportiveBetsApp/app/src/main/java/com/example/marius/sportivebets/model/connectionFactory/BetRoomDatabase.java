package com.example.marius.sportivebets.model.connectionFactory;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.marius.sportivebets.model.dao.UserDao;
import com.example.marius.sportivebets.model.entity.User;


@Database(entities = {User.class}, version = 1)
public abstract class BetRoomDatabase extends RoomDatabase{

    private static BetRoomDatabase connection;

    static BetRoomDatabase getConnection(final Context context)
    {
        if(connection== null){
            synchronized ( (BetRoomDatabase.class))
            {
                if( connection == null)
                {
                    connection= Room.databaseBuilder(context.getApplicationContext(),BetRoomDatabase.class,"BetDatabase").build();
                }
            }
    }

    return connection;
    }

    public abstract UserDao userDao();

    /*


     static WordRoomDatabase getDatabase(final Context context) {
       if (INSTANCE == null) {
           synchronized (WordRoomDatabase.class) {
               if (INSTANCE == null) {
                   INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                           WordRoomDatabase.class, "word_database")
                           .build();
     */

}
