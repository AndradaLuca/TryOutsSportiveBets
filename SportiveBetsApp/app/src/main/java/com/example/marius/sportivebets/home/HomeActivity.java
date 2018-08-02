package com.example.marius.sportivebets.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.MenuItem;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityMainBinding;
import com.example.marius.sportivebets.home.bottomNavFragments.DepositMoneyFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.HomeFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.MyBetsFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.WithdrawMoneyFragment;

public class HomeActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    private ActionBarDrawerToggle mToogle;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.navigationView.setItemIconTintList(null);
        mToogle = new ActionBarDrawerToggle(this,mainBinding.drawerLayout,R.string.open,R.string.close);

        mainBinding.drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();
        mToogle.setDrawerIndicatorEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,new HomeFragment()).commit();


        mainBinding.bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()){
                    case R.id.home_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,new HomeFragment()).commit();
                        break;

                    case R.id.deposit_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,new DepositMoneyFragment()).commit();
                        break;
                    case R.id.withdraw_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,new WithdrawMoneyFragment()).commit();
                        break;
                    case R.id.MyBets_menu:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,new MyBetsFragment()).commit();
                        break;
                    case R.id.betTicket_menu:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.myTicketFragment,new BetTicketFragment()).commit();
                        if (mainBinding.drawerLayout.isDrawerOpen(Gravity.END)){
                            mainBinding.drawerLayout.closeDrawer(Gravity.END);
                        }else{
                            mainBinding.drawerLayout.openDrawer(Gravity.END);
                        }
                       break;
                }

                return true;
            }
        });



    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
