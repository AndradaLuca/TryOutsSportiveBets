package com.example.marius.sportivebets.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityMainBinding;

public class HomeActivity extends AppCompatActivity {

    private Button button1;
    NavigationView navigationView;
    ActivityMainBinding mainBinding;
    private ActionBarDrawerToggle mToogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.navigationView.setItemIconTintList(null);
        mToogle = new ActionBarDrawerToggle(this,mainBinding.drawerLayout,R.string.open,R.string.close);
        mainBinding.drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
