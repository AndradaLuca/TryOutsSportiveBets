package com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.braintreepayments.cardform.view.CardForm;
import com.example.marius.sportivebets.database.Repository.Repository;

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

    protected void onDepositClick(CardForm cardForm, String ammount, String CNP, String email, String password, Context context) {

        if (cardForm.isValid()) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setTitle("Confirm before purchase");
            alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                    "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                    "Card CVV: " + cardForm.getCvv() + "\n" +
                    "Sum: " + ammount);
            alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Double updateAmmount = Double.parseDouble(ammount) + repository.findUser(email, password).getMouney();
                    repository.updateBalance(CNP, updateAmmount.toString());
                    depositSuccess.postValue("Deposit succesfuly !!!");
                    dialogInterface.dismiss();
                }
            });
            alertBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialogInterface.dismiss();
                }
            });
            AlertDialog alertDialog = alertBuilder.create();
            alertDialog.show();

        } else {
            depositFailed.postValue("Please complete the form correctly");
        }


    }


}
