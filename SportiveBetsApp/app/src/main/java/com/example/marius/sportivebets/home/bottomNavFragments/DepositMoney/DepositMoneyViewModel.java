package com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.braintreepayments.cardform.view.CardForm;
import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.database.entity.User;

import es.dmoral.toasty.Toasty;

public class DepositMoneyViewModel extends AndroidViewModel {
    private MutableLiveData<String> depositSuccess = new MutableLiveData<>();
    private MutableLiveData<String> depositFailed = new MutableLiveData<>();
    private Repository repository;

    public DepositMoneyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<String> getDepositSuccess() {
        return depositSuccess;
    }

    public MutableLiveData<String> getDepositFailed() {
        return depositFailed;
    }

    protected void onConfirmDepositClick(String ammount, String CNP,String email,String password){
        Double updateAmmount = Double.parseDouble(ammount)+ repository.findUser(email,password).getMouney();
        repository.updateBalance(CNP,updateAmmount.toString());
        depositSuccess.postValue("Deposit succesfuly !!!");
    }


}
