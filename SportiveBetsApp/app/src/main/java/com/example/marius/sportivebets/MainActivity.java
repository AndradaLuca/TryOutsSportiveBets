package com.example.marius.sportivebets;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.example.marius.sportivebets.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
//        Intent intent= getIntent();
//        mainBinding.blabla.setText(intent.getStringExtra("username"));
    }
}
