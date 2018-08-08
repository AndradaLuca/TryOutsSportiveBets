package com.example.marius.sportivebets.forgotPassword;

import android.app.Application;
import android.app.ProgressDialog;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.database.entity.User;
import com.example.marius.sportivebets.utils.Validation;
import com.example.marius.sportivebets.utils.mailHelpers.GMailSender;

import java.util.Random;

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

    public void onSubmitClick(String email, Context context){
        if (!Validation.isLoginEmailValid(email)) {
            submitFailed.postValue("Empty e-mail !!!");
        }else {
            if (repository.findUserForSubmit(email) != null){
                final String DATA = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz|!£$%&/=@#";
                Random RANDOM = new Random();
                StringBuilder sb = new StringBuilder(10);
                for (int i = 0; i < 10; i++) {
                    sb.append(DATA.charAt(RANDOM.nextInt(DATA.length())));
                }
                String newPassword = sb.toString();
                repository.updatePassword(email,newPassword);
                User user = repository.findUserForSubmit(email);
                final ProgressDialog dialog = new ProgressDialog(context);
                dialog.setTitle("Sending Email");
                dialog.setMessage("Please wait");
                dialog.show();
                Thread sender = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            GMailSender sender = new GMailSender("sportivebets@gmail.com", "sportiveBetsA&M");
                            sender.sendMail("Recover Password",
                                    "The new password for "+user+" is: "+newPassword,
                                    "SportiveBets",
                                    email);
                            dialog.dismiss();
                            submitSuccess.postValue("Submitted succesfully");
                        } catch (Exception e) {
                            Log.e("mylog", "Error: " + e.getMessage());
                        }
                    }
                });
                sender.start();
            }
            else{
                submitFailed.postValue("Not registered yet !!!");
            }
        }
    }
}
