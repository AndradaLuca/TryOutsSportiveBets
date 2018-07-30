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
    private LiveData<User> userLiveData;
//    private List<User> users;



    public Repository(Application application){
        db = BetRoomDatabase.getDatabase(application);
        userDao = db.userDao();


    }
//    public List<User> getUsers(){
//        return users;
//    }


    public User findUserByEmailAndPassword(String email, String password) {
        final User[] user = new User[1];
        new Thread(new Runnable() {
            @Override
            public void run() {
                user[0] = userDao.findByUsernameAndPAssword(email, password);
            }
        }).start();

        return user[0];
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
