package com.example.marius.sportivebets.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marius.sportivebets.database.entity.User;

public class LoginViewModel extends AndroidViewModel {
    // corect cu User
    private MutableLiveData<User> loginSuccess = new MutableLiveData<>();
    private MutableLiveData<String> loginFaild = new MutableLiveData<>();
    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<User> getLoginSuccess() {
        return loginSuccess;
    }

    public MutableLiveData<String> getLoginFaild() {
        return loginFaild;
    }

    public void onLoginClick(String email, String password, boolean isKeepLogged){
        //todo 1-Validare pe UI 2-
        // la validare fac un if else si daca ii facuta validare corect
        if (isKeepLogged) {
            loginSuccess.postValue(new User());
        }else
        loginFaild.postValue("loginFaild");
       //Log.d("onLoginClick","Email:"+email+" Password:"+password+" isKeepLogged:"+isKeepLogged);
    }
}
