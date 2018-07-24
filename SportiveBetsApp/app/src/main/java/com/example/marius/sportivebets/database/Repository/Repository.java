package com.example.marius.sportivebets.database.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.marius.sportivebets.database.connectionFactory.BetRoomDatabase;
import com.example.marius.sportivebets.database.dao.UserDao;
import com.example.marius.sportivebets.database.entity.User;

import java.util.List;

public class Repository {
    private UserDao userDao;
    private LiveData<List<User>> mAllUsers;
    private BetRoomDatabase db;

    public LiveData<List<User>> getmAllUsers() {
        return mAllUsers;
    }

    public Repository(Application application){
        db = BetRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        mAllUsers = userDao.viewAllUsers();
    }

    public void insert (User user){
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

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }
    }
}
