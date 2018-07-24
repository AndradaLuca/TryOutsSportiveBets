package com.example.marius.sportivebets.Db.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.os.AsyncTask;

import com.example.marius.sportivebets.Db.connectionFactory.BetRoomDatabase;
import com.example.marius.sportivebets.Db.dao.UserDao;
import com.example.marius.sportivebets.Db.entity.User;

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
