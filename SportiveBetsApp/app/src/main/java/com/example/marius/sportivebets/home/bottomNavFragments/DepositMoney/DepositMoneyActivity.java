package com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.widget.Toast;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.FragmentDepositMoneyBinding;

import es.dmoral.toasty.Toasty;

import static android.widget.Toast.LENGTH_SHORT;


public class DepositMoneyActivity extends AppCompatActivity implements IDepositMoney {
    FragmentDepositMoneyBinding depositMoneyBinding;
    DepositMoneyViewModel depositMoneyViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        depositMoneyBinding = DataBindingUtil.setContentView(this,R.layout.fragment_deposit_money);
        depositMoneyBinding.cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(false)
                .mobileNumberRequired(false)
                .setup(DepositMoneyActivity.this);
        depositMoneyBinding.cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        depositMoneyBinding.setIDepositMoney(this);
        initViewModel();
    }



    private void initViewModel(){
        depositMoneyViewModel = ViewModelProviders.of(this).get(DepositMoneyViewModel.class);
        depositMoneyViewModel.getDepositSuccess().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.success(getApplication(), "Deposit succesfully!!!", Toast.LENGTH_LONG).show();
            }

        });
        depositMoneyViewModel.getDepositFailed().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.error(DepositMoneyActivity.this,s, LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDepositClick() {



        if (depositMoneyBinding.cardForm.isValid()) {
            AlertDialog.Builder alertBuilder = new AlertDialog.Builder(DepositMoneyActivity.this);
            alertBuilder.setTitle("Confirm before purchase");
            alertBuilder.setMessage("Card number: " + depositMoneyBinding.cardForm.getCardNumber() + "\n" +
                    "Card expiry date: " + depositMoneyBinding.cardForm.getExpirationDateEditText().getText().toString() + "\n" +
                    "Card CVV: " + depositMoneyBinding.cardForm.getCvv() + "\n" +
                    "Phone number: " + depositMoneyBinding.cardForm.getMobileNumber()+"\n"+
                    "Sum: "+ depositMoneyBinding.howMuchTV.getText().toString());
            alertBuilder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    depositMoneyViewModel.onConfirmDepositClick(depositMoneyBinding.howMuchTV.getText().toString(),getIntent().getStringExtra("CNP"));
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

        }else {
            Toasty.error(this,"Please complete the form",LENGTH_SHORT,true);
        }
    }
}
