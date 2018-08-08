package com.example.marius.sportivebets.forgotPassword;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.utils.Validation;
import com.example.marius.sportivebets.utils.mailHelpers.GMailSender;

public class ForgotPasswordViewModel extends AndroidViewModel {

    private Repository repository;
    private MutableLiveData<String> submitSuccess = new MutableLiveData<>();
    private MutableLiveData<String> submitFailed = new MutableLiveData<>();
    public ForgotPasswordViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<String> getSubmitSuccess() {
        return submitSuccess;
    }

    public MutableLiveData<String> getSubmitFailed() {
        return submitFailed;
    }

    public void onSubmitClick(String email){
        if (!Validation.isLoginEmailValid(email)) {
            submitFailed.postValue("Empty e-mail !!!");
        }else {
            if (repository.findUserForSubmit(email) != null){
                Thread sender = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            GMailSender sender = new GMailSender("sportivebets@gmail.com", "sportiveBetsA&M");
                            sender.sendMail("Recover Password",
                                    "the new password is Bla Bla Bla",
                                    "SportiveBets",
                                    email);
                            submitSuccess.postValue("Submitted succesfully");
                        } catch (Exception e) {
                            Log.e("mylog", "Error: " + e.getMessage());
                        }
                    }
                });
                sender.start();
                // TODO implement sending email to user with the new password
            }
            else{
                submitFailed.postValue("Not registered yet !!!");
            }
        }
    }
}
