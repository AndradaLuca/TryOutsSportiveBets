package com.example.marius.sportivebets.login;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityLoginBinding;
import com.example.marius.sportivebets.forgotPassword.ForgotPasswordActivity;
import com.example.marius.sportivebets.register.RegisterActivity;

public class LoginActivity extends AppCompatActivity implements ILoginActivity {

    ActivityLoginBinding loginBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login);
        loginBinding.setILoginActivity((ILoginActivity)this);
    }

    @Override
    public void showRegisterActivity() {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivity(intent);

    }

    @Override
    public void login() {
        Toast.makeText(this, "Login Pressed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void forgotPassword() {
        Toast.makeText(this, "ForgotPassword Pressed", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(LoginActivity.this, ForgotPasswordActivity.class);
        startActivity(intent);
    }
}
