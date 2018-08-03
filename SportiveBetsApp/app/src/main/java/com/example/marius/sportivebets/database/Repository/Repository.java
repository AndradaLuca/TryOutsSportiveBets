package com.example.marius.sportivebets.database.Repository;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import com.example.marius.sportivebets.database.DataGenerator;
import com.example.marius.sportivebets.database.connectionFactory.BetRoomDatabase;
import com.example.marius.sportivebets.database.dao.UserDao;
import com.example.marius.sportivebets.database.entity.User;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class Repository {
    private UserDao userDao;
    private BetRoomDatabase db;
    private User user;
    private static boolean isEmpty = true;

    public Repository(Application application){
        db = BetRoomDatabase.getDatabase(application);
        userDao = db.userDao();
        if (isEmpty) {
            deleteAll();
            isEmpty = false;
            List<User> users = DataGenerator.generateUsers();
            for (User user : users) {
                this.addUser(user);
                Log.d("FFFFFFFFFFFFFFFFFFFF", "USER INDRODUS");
            }
        }

    }

    public void deleteAll() {
        new DeleteAll().execute();
    }

    private class DeleteAll extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.nukeTable();
            return null;
        }
    }



    public User findUserForSubmit(String email) {
        try {
            user = new FindUserForSubmit().execute(new String[]{email}).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("Function "+user);
        return user;
    }
    public class FindUserForSubmit extends AsyncTask<String, Void, User> {
        @Override
        protected User doInBackground(String... strings) {
            user = userDao.findUserForSubmit(strings[0]+"");
            System.out.println("   Asynk   "+user);
            return user;
        }
    }

    public User findUser(String email, String password) {
        try {
            user = new FindUser().execute(new String[]{email,password}).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return user;
    }
    public class FindUser extends AsyncTask<String, Void, User> {
        @Override
        protected User doInBackground(String... strings) {
            user = userDao.findByUsernameAndPAssword(strings[0]+"", strings[1]+"");
            return user;
        }
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
