package com.example.marius.sportivebets.register;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.View;

import com.example.marius.sportivebets.login.LoginActivity;




public class RegisterViewModel extends AndroidViewModel {

        private ViewListener viewListener;
        private String name;
        private String email;
        private String cnp;
        private String password;
        private String address;



        public RegisterViewModel (@NonNull Application application)
        {
            super(application);
        }


        public void showLoginScreen()
        {

        }


    public interface ViewListener
    {
        void onLoginHereClick();
    }

}
