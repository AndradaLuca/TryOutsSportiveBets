package com.example.marius.sportivebets.register;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityRegisterBinding;
import com.example.marius.sportivebets.login.LoginActivity;

import static android.widget.Toast.LENGTH_SHORT;


public class RegisterActivity extends AppCompatActivity implements IRegisterActivity{

    //data binding
    ActivityRegisterBinding mBinding;

    RegisterViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding= DataBindingUtil.setContentView(this,R.layout.activity_register);
       mBinding.setIRegisterActivity(this);
       initmViewModel();

    }

    public void initmViewModel()
    {
        mViewModel=ViewModelProviders.of(this).get(RegisterViewModel.class);
        mViewModel.getRegisterFaild().observe(this, (message) -> {
            Toast.makeText(RegisterActivity.this, message, LENGTH_SHORT).show();
        });
        mViewModel.getRegisterSuccess().observe(this, (message) -> {
            Toast.makeText(RegisterActivity.this, message, LENGTH_SHORT).show();
        });


    }


    @Override
    public void showLoginActivity() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void register() {
        String username = mBinding.registerUsernameEditText.getText().toString();
        String email = mBinding.registerEmailEditText.getText().toString();
        String cnp = mBinding.registerCnpEditText.getText().toString();
        String password = mBinding.registerPasswordEditText.getText().toString();
        String secondPassword = mBinding.registerSecondPasswordEditText.getText().toString();
        String address = mBinding.registerAddressEditText.getText().toString();


        mViewModel.onRegisterClick(username, email, password, secondPassword, cnp, address);


    }
}
