package com.example.marius.sportivebets.home.bottomNavFragments.withdrawMoney;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.FragmentWithdrawMoneyBinding;
import com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney.DepositMoneyActivity;
import com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney.DepositMoneyViewModel;

import es.dmoral.toasty.Toasty;

import static android.widget.Toast.LENGTH_SHORT;

public class WithdrawMoneyFragment extends Fragment implements IWithdrawMoney {
    WithdrawMoneyViewModel withdrawMoneyViewModel;
    FragmentWithdrawMoneyBinding withdrawMoneyBinding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        withdrawMoneyBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_withdraw_money,container,false);
        withdrawMoneyBinding.setIWithDrawMoney(this);
        withdrawMoneyBinding.cardFormWithdraw.cardRequired(true)
                .expirationRequired(true)
                .cvvRequired(true)
                .postalCodeRequired(false)
                .mobileNumberRequired(false)
                .setup(getActivity());
        withdrawMoneyBinding.cardFormWithdraw.getCvvEditText().setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        withdrawMoneyBinding.cardFormWithdraw.getCardEditText().setText("5539110002475800");
        withdrawMoneyBinding.cardFormWithdraw.getExpirationDateEditText().setText("102018");
        withdrawMoneyBinding.cardFormWithdraw.getCvvEditText().setText("455");
        withdrawMoneyBinding.howMuchWithdrawTV.setText("175.68");
        initViewModel();
        return withdrawMoneyBinding.getRoot();
    }

    private void initViewModel(){

        withdrawMoneyViewModel = ViewModelProviders.of(this).get(WithdrawMoneyViewModel.class);
        withdrawMoneyViewModel.getWithdrawSuccess().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.success(getContext(), s, Toast.LENGTH_LONG).show();
            }

        });
        withdrawMoneyViewModel.getWithdrawFailed().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.error(getContext(),s, LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onWithdrawClick() {
        withdrawMoneyViewModel.onWithdrawClick(withdrawMoneyBinding.cardFormWithdraw,
                withdrawMoneyBinding.howMuchWithdrawTV.getText().toString(),
                getArguments().getString("CNP"),
                getArguments().getString("email"),
                getArguments().getString("password"),
                getContext());
    }
}
