package com.example.marius.sportivebets.register;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.database.entity.User;
import com.example.marius.sportivebets.utils.Validation;


public class RegisterViewModel extends AndroidViewModel {

    private MutableLiveData<String> registerFaild = new MutableLiveData<>();
    private MutableLiveData<String> registerSuccess = new MutableLiveData<>();
    private Repository repository;

      public RegisterViewModel(@NonNull Application application)
      {
          super(application);
          repository = new Repository(application);
      }

    public MutableLiveData<String> getRegisterFaild() {
        return registerFaild;
    }

    public MutableLiveData<String> getRegisterSuccess() {
        return registerSuccess;
    }

    private Boolean isValid(String username, String email, String password, String secondPassword, String cnp, String address) {
        if (!Validation.isUsernameValid(username)) {
            registerFaild.postValue("Invalid username");
            return false;
        } else if (!Validation.isEmailValid(email)) {
            registerFaild.postValue("Invalid e-mail ");
            return false;
        } else if (!Validation.isCnpValid(cnp)) {
            registerFaild.postValue("Invalid CNP");
            return false;
        } else if (!Validation.isPasswordValid(password, secondPassword)) {
            registerFaild.postValue("The passwords do not match");
            return false;

        } else if (!Validation.isAddressValid(address)) {
            registerFaild.postValue("Invalid address ");
            return false;
        }

        return true;
    }

    public void onRegisterClick(String username, String email, String password, String secondPassword, String cnp, String address) {
        if (isValid(username, email, password, secondPassword, cnp, address)) {  //create user and send it to repository

            registerSuccess.postValue("You have been successfully registered");
            User user = new User(cnp, username, email, address, password, 0);
            repository.addUser(user);

        }
    }

}
