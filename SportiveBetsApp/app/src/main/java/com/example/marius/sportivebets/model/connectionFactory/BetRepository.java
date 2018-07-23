package com.example.marius.sportivebets.model.connectionFactory;

import android.app.Application;
import android.os.AsyncTask;

import com.example.marius.sportivebets.model.dao.UserDao;
import com.example.marius.sportivebets.model.entity.User;

public class BetRepository {
    private UserDao userDao;
    private String username;


    public BetRepository(Application application){
        BetRoomDatabase db = BetRoomDatabase.getConnection(application);
        userDao = db.userDao();
    }
    public void insert (User user) {
        new insertAsyncTask(userDao).execute(user);
    }
    private static class insertAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao mAsyncTaskDao;

        insertAsyncTask(UserDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final User... params) {
            mAsyncTaskDao.insertUser(params[0]);
            return null;
        }
    }
}
