package com.example.marius.sportivebets.register;

import android.app.Activity;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingComponent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityRegisterBinding;
import com.example.marius.sportivebets.login.LoginActivity;



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
    }


    @Override
    public void showLoginActivity() {
        Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void register() {


    }
}
