package com.example.marius.sportivebets.register;

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

import javax.inject.Inject;

import dagger.android.support.DaggerAppCompatActivity;

public class RegisterActivity extends AppCompatActivity implements RegisterViewModel.ViewListener {

    //data binding
    ActivityRegisterBinding mBinding;

    RegisterViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mBinding= DataBindingUtil.setContentView(this,R.layout.activity_register);


       mBinding.setViewModel(mViewModel);

    }

    public void initmViewModel()
    {
        mViewModel=ViewModelProviders.of(this).get(RegisterViewModel.class);
    }


    @Override
    public void onLoginHereClick() {
        Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
