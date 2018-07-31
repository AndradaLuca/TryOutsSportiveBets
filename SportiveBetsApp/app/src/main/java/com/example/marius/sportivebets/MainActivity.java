package com.example.marius.sportivebets;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.example.marius.sportivebets.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private Button button1;
    NavigationView navigationView;
    ActivityMainBinding mainBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigationView);
        navigationView.setItemIconTintList(null);
        Bundle bundle = getIntent().getExtras();
        TextView textView = findViewById(R.id.blabla);
        textView.setText(bundle.getString("username"));
    }
}
