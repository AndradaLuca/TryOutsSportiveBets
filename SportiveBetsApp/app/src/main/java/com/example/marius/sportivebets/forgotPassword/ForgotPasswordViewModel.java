package com.example.marius.sportivebets.forgotPassword;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.example.marius.sportivebets.utils.Validation;

public class ForgotPasswordViewModel extends AndroidViewModel {
    private MutableLiveData<String> submitSuccess = new MutableLiveData<>();
    private MutableLiveData<String> submitFaild = new MutableLiveData<>();
    public ForgotPasswordViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<String> getSubmitSuccess() {
        return submitSuccess;
    }

    public MutableLiveData<String> getSubmitFaild() {
        return submitFaild;
    }

    public void onSubmitClick(String email){
        //todo 1-Validare pe UI 2-
        // la validare fac un if else si daca ii facuta validare corect
        if (!Validation.isLoginEmailValid(email)) {
            submitFaild.postValue("Empty e-mail !!!");
        }else {
            submitSuccess.postValue("Submitted succesfully");
        }
        //Log.d("onLoginClick","Email:"+email+" Password:"+password+" isKeepLogged:"+isKeepLogged);
    }
}
