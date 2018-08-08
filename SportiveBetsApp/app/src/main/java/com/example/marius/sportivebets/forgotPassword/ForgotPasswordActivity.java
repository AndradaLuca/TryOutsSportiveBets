package com.example.marius.sportivebets.forgotPassword;

import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityForgotPasswordBinding;
import com.example.marius.sportivebets.utils.mailHelpers.GMailSender;

import es.dmoral.toasty.Toasty;

import static android.widget.Toast.LENGTH_SHORT;

public class ForgotPasswordActivity extends AppCompatActivity implements IForgotPasswordActivity {
    ActivityForgotPasswordBinding forgotPasswordBinding;
    private ForgotPasswordViewModel forgotPasswordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        forgotPasswordBinding = DataBindingUtil.setContentView(this,R.layout.activity_forgot_password);
        forgotPasswordBinding.setIForgotPasswordActivity((IForgotPasswordActivity)this);
        forgotPasswordBinding.editText.setText("pascalaumarius3@gmail.com");
        initViewModel();
    }

    private void initViewModel(){
        forgotPasswordViewModel = ViewModelProviders.of(this).get(ForgotPasswordViewModel.class);
        forgotPasswordViewModel.getSubmitSuccess().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.success(ForgotPasswordActivity.this,s, LENGTH_SHORT,true).show();
            }
        });
        forgotPasswordViewModel.getSubmitFailed().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                Toasty.error(ForgotPasswordActivity.this,s, LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public void onSubmitClick() {
        final ProgressDialog dialog = new ProgressDialog(ForgotPasswordActivity.this);
        dialog.setTitle("Sending Email");
        dialog.setMessage("Please wait");
        dialog.show();
        forgotPasswordViewModel.onSubmitClick(forgotPasswordBinding.editText.getText().toString());
        dialog.dismiss();
    }
}