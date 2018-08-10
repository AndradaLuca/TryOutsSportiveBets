package com.example.marius.sportivebets.login;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.database.entity.User;
import com.example.marius.sportivebets.databinding.ActivityLoginBinding;
import com.example.marius.sportivebets.forgotPassword.ForgotPasswordActivity;
import com.example.marius.sportivebets.home.HomeActivity;
import com.example.marius.sportivebets.register.RegisterActivity;

import es.dmoral.toasty.Toasty;

import static android.widget.Toast.LENGTH_SHORT;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {

    private ActivityLoginBinding loginBinding;
    private LoginViewModel loginViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginBinding.setILoginActivity(this);
        loginBinding.loginPasswordEditText.setText("asd");
        loginBinding.loginUsernameEditText.setText("asd@asd.com");
        initViewModel();

    }

    private void initViewModel(){
        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel.class);
        loginViewModel.getLoginSuccess().observe(this, new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                intent.putExtra("CNP",user.getCNP());
                intent.putExtra("email",user.getMail());
                intent.putExtra("password",user.getPassword());
                intent.putExtra("ammount",user.getMouney());
                startActivity(intent);
                finish();
            }
        });
        loginViewModel.getLoginFailed().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.error(LoginActivity.this,s, LENGTH_SHORT).show();
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
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}
