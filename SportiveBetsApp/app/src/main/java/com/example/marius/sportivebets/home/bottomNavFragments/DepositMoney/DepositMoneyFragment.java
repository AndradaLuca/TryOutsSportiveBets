package com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.FragmentDepositMoneyBinding;

import es.dmoral.toasty.Toasty;

import static android.widget.Toast.LENGTH_SHORT;


public class DepositMoneyFragment extends Fragment implements IDepositMoney {
    FragmentDepositMoneyBinding depositMoneyBinding;
    DepositMoneyViewModel depositMoneyViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        depositMoneyBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_deposit_money, container, false);
        depositMoneyBinding.cardForm.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(false)
                .mobileNumberRequired(false)
                .setup(getActivity());
        depositMoneyBinding.cardForm.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        depositMoneyBinding.cardForm.getCardEditText().setText("5539110002475800");
        depositMoneyBinding.cardForm.getExpirationDateEditText().setText("102018");
        depositMoneyBinding.cardForm.getCvvEditText().setText("455");
        depositMoneyBinding.howMuchTV.setText("235.68");
        depositMoneyBinding.setIDepositMoney(this);
        initViewModel();
        return depositMoneyBinding.getRoot();
    }


    private void initViewModel() {
        depositMoneyViewModel = ViewModelProviders.of(this).get(DepositMoneyViewModel.class);
        depositMoneyViewModel.getDepositSuccess().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.success(getContext(), "Deposit succesfully!!!", Toast.LENGTH_LONG).show();
            }

        });
        depositMoneyViewModel.getDepositFailed().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.error(getContext(), s, LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onDepositClick() {


        if (depositMoneyBinding.cardForm.isValid()) {
            depositMoneyViewModel.onDepositClick(depositMoneyBinding.cardForm,
                    depositMoneyBinding.howMuchTV.getText().toString(),
                    getArguments().getString("CNP"),
                    getArguments().getString("email"),
                    getArguments().getString("password"),
                    getContext());
        }
    }
}
