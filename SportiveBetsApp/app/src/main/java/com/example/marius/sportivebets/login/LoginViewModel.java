package com.example.marius.sportivebets.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.database.entity.User;
import com.example.marius.sportivebets.utils.Validation;

public class LoginViewModel extends AndroidViewModel {
    private MutableLiveData<User> loginSuccess = new MutableLiveData<>();
    private MutableLiveData<String> loginFailed = new MutableLiveData<>();
    private Repository repository;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<User> getLoginSuccess() {
        return loginSuccess;
    }


    public MutableLiveData<String> getLoginFailed() {
        return loginFailed;
    }

    public void onLoginClick(String email, String password, boolean isKeepLogged){
        if (!Validation.isLoginEmailValid(email)) {
            loginFailed.postValue("Empty e-mail !!!");
        }else if (!Validation.isLoginPasswordValid(password)){
            loginFailed.postValue("Empty password !!!");
        }else {
            if (repository.findUserForSubmit(email) != null){


            if(repository.findUser(email, password)!= null){
                if (repository.findUser(email, password).getMail().equals(email) && repository.findUser(email, password).getPassword().equals(password)){
                    loginSuccess.postValue(repository.findUser(email, password));
                }
            }else{
                loginFailed.postValue("Wrong password !!!");
            }
            }
            else{
                loginFailed.postValue("Not registered yet !!!");
            }
        }

    }
}
