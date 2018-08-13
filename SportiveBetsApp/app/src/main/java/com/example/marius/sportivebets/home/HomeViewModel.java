package com.example.marius.sportivebets.home;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;

import com.example.marius.sportivebets.database.Repository.Repository;

public class HomeViewModel extends AndroidViewModel {
    private Repository repository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public Double getBalance(String email, String password) {
        return repository.findUser(email, password).getMouney();
    }
}
