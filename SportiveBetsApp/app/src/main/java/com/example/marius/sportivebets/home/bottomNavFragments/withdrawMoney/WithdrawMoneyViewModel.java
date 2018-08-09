package com.example.marius.sportivebets.home.bottomNavFragments.withdrawMoney;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;

import com.braintreepayments.cardform.view.CardForm;
import com.example.marius.sportivebets.database.Repository.Repository;
import com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney.DepositMoneyActivity;

import es.dmoral.toasty.Toasty;

import static android.widget.Toast.LENGTH_SHORT;

public class WithdrawMoneyViewModel extends AndroidViewModel {
    private MutableLiveData<String> withdrawSuccess = new MutableLiveData<>();
    private MutableLiveData<String> withdrawFailed = new MutableLiveData<>();
    private Repository repository;

    public WithdrawMoneyViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
    }

    public MutableLiveData<String> getWithdrawSuccess() {
        return withdrawSuccess;
    }

    public MutableLiveData<String> getWithdrawFailed() {
        return withdrawFailed;
    }
    protected void onWithdrawClick(CardForm cardForm,String ammount, String CNP, String email, String password,Context context){

        if (cardForm.isValid()) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context);
            alertBuilder.setTitle("Confirm before purchase");
            alertBuilder.setMessage("Card number: " + cardForm.getCardNumber() + "\n" +
                    "Card expiry date: " + cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                    "Card CVV: " + cardForm.getCvv() + "\n" +
                    "Sum: "+ ammount);
            alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.out.println(email+"  "+password);
                    if (repository.findUser(email, password).getMouney() - Double.parseDouble(ammount) >= 0) {
                        Double updateAmmount = repository.findUser(email, password).getMouney() - Double.parseDouble(ammount);
                        repository.updateBalance(CNP,updateAmmount.toString());
                        withdrawSuccess.postValue("Withdraw succesfuly !!!");
                        dialogInterface.dismiss();
                    } else {
                        withdrawFailed.postValue("Insufficient funds");
                    }
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

        }else {
            withdrawFailed.postValue("Please complete the form correctly");
        }
    }
}
