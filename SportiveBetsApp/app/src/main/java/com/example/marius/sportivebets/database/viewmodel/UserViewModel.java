package com.example.marius.sportivebets.database.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.database.entity.User;

import java.util.List;

public class UserViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<User>> mAllUsers;

    public UserViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        mAllUsers = repository.getmAllUsers();
    }

    LiveData<List<User>> getAllUsers(){
        return mAllUsers;
    }

    public void insert(User user){
        repository.insert(user);
    }
}
