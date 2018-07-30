package com.example.marius.sportivebets.login;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.database.entity.User;
import com.example.marius.sportivebets.utils.Validation;

public class LoginViewModel extends AndroidViewModel {
    // corect cu User
    private MutableLiveData<User> loginSuccess = new MutableLiveData<>();
    private MutableLiveData<String> loginFaild = new MutableLiveData<>();
//    private LiveData<User> user;
    private Repository repository;
    private User user;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);

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
//        List<User> users = repository.getUsers();
//        for (int i=0;i<users.size();i++){
//            System.out.println(users.get(i).toString());
//        }
        if (!Validation.isLoginEmailValid(email)) {
            loginFaild.postValue("Empty e-mail !!!");

        }else if (!Validation.isLoginPasswordValid(password)){
            loginFaild.postValue("Empty password !!!");
        }else {

            user = repository.findUserByEmailAndPassword(email,password);
            System.out.println(user);
            loginSuccess.postValue(user);
        }
       //Log.d("onLoginClick","Email:"+email+" Password:"+password+" isKeepLogged:"+isKeepLogged);
    }
    public User getUser(){
        return this.user;
    }
}
