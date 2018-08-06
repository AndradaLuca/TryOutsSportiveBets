package com.example.marius.sportivebets.home;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityMainBinding;
import com.example.marius.sportivebets.home.bottomNavFragments.BetTicketFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.DepositMoneyFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.HomeFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.MyBetsFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.WithdrawMoneyFragment;
import com.example.marius.sportivebets.utils.Constants;

public class HomeActivity extends AppCompatActivity {



    ActivityMainBinding mainBinding;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    RecyclerView.Adapter adapter;
    ActionBarDrawerToggle mToogle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = mainBinding.recycleView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        drawerLayout = mainBinding.drawerLayout;
        recyclerView.setHasFixedSize(false);

        adapter = new HomeRecyclerAdapter(Constants.menuItems);
        recyclerView.setAdapter(adapter);

        mToogle = new ActionBarDrawerToggle(this,mainBinding.drawerLayout,R.string.open,R.string.close);

        mainBinding.drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mainBinding.bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch(item.getItemId()){
                    case R.id.home_menu:
                        selectedFragment = new HomeFragment();
                        break;

                    case R.id.deposit_menu:
                            selectedFragment = new DepositMoneyFragment();
                        break;
                    case R.id.withdraw_menu:
                        selectedFragment = new WithdrawMoneyFragment();
                        break;
                    case R.id.MyBets_menu:
                        selectedFragment = new MyBetsFragment();
                        break;
                    case R.id.betTicket_menu:
                        selectedFragment = new BetTicketFragment();
                       break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment).commit();
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
