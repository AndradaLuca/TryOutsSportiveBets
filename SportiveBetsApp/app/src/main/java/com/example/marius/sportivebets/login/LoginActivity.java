package com.example.marius.sportivebets.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.database.entity.User;
import com.example.marius.sportivebets.databinding.ActivityLoginBinding;
import com.example.marius.sportivebets.forgotPassword.ForgotPasswordActivity;
import com.example.marius.sportivebets.register.RegisterActivity;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {

    private ActivityLoginBinding loginBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginBinding.setILoginActivity(this);
        initViewModel();
    }

    private void initViewModel(){
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.getLoginSuccess().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                Toast.makeText(LoginActivity.this,"login sucses", LENGTH_SHORT).show();
            }
        });
        loginViewModel.getLoginFaild().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toast.makeText(LoginActivity.this,s+" bla bla", LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void showRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    @Override
    public void login() {
        loginViewModel.onLoginClick(loginBinding.loginUsernameEditText.getText().toString(),loginBinding.loginPasswordEditText.getText().toString(),loginBinding.loginSwitch.isChecked());
    }

    @Override
    public void forgotPassword() {
        Toast.makeText(this, "ForgotPassword Pressed", LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}
