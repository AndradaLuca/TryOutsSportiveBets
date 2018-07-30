package com.example.marius.sportivebets.database.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;
import android.util.Log;

import com.example.marius.sportivebets.database.connectionFactory.BetRoomDatabase;
import com.example.marius.sportivebets.database.dao.UserDao;
import com.example.marius.sportivebets.database.entity.User;

public class Repository {
    private UserDao userDao;
    private BetRoomDatabase db;
    private LiveData<User> userLiveData = null;



    public Repository(Application application){
        db = BetRoomDatabase.getDatabase(application);
        userDao = db.userDao();


    }


    public boolean findUser(String email, String password) {
        Boolean verific = false;
        System.out.println("FFFFFFFFFFFFFFFFFFFFFF" + userDao.findByUsernameAndPAssword(email, password).toString());
        if (userDao.findByUsernameAndPAssword(email, password) != null) {
            verific = true;
        }

        return verific;
    }


    public void addUser(User user) {
        new AddUser().execute(user);
        Log.d("addUser", "Success");
    }

    public class AddUser extends AsyncTask<User, Void, Void> {
        @Override
        protected Void doInBackground(User... users) {
            userDao.insertUser(users[0]);
            Log.d("", "Success");
            return null;
        }
    }
}
