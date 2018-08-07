package com.example.marius.sportivebets.home;

import android.content.Intent;
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
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityMainBinding;
import com.example.marius.sportivebets.home.bottomNavFragments.BetTicketFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney.DepositMoneyActivity;
import com.example.marius.sportivebets.home.bottomNavFragments.HomeFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.MyBetsFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.WithdrawMoneyFragment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {


    Toolbar toolbar;
    ActivityMainBinding mainBinding;
    RecyclerView recyclerView;
    DrawerLayout drawerLayout;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<String> sportsList = new ArrayList<>();
    List<Integer> images = Arrays.asList(R.drawable.soccer, R.drawable.tennisball, R.drawable.pingpong, R.drawable.basketball, R.drawable.cricket, R.drawable.badminton, R.drawable.americanfootball, R.drawable.bowling, R.drawable.chess, R.drawable.golf, R.drawable.hockey, R.drawable.boxing, R.drawable.volleyball);
    ActionBarDrawerToggle mToogle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = mainBinding.recycleView;
        layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);

        drawerLayout = mainBinding.drawerLayout;
        recyclerView.setHasFixedSize(false);

        String[] items = getResources().getStringArray(R.array.Sports);
        sportsList.addAll(Arrays.asList(items));


        adapter = new RecycleAdapter(sportsList, images);
        recyclerView.setAdapter(adapter);

        mToogle = new ActionBarDrawerToggle(this,mainBinding.drawerLayout,R.string.open,R.string.close);

        mainBinding.drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,new HomeFragment()).commit();
        Bundle bundle = new Bundle();
        bundle.putString("ammount", getIntent().getStringExtra("ammount"));
        bundle.putString("CNP", getIntent().getStringExtra("CNP"));
        HomeFragment homeFragmentObject = new HomeFragment();
        homeFragmentObject.setArguments(bundle);


        mainBinding.bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch(item.getItemId()){
                    case R.id.home_menu:
                        selectedFragment = new HomeFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment).commit();
                        Bundle bundle = new Bundle();
                        bundle.putString("ammount", getIntent().getStringExtra("ammount"));
                        bundle.putString("CNP", getIntent().getStringExtra("CNP"));
                        HomeFragment fragobj = new HomeFragment();
                        fragobj.setArguments(bundle);
                        break;

                    case R.id.deposit_menu:
                        Intent intent = new Intent(HomeActivity.this, DepositMoneyActivity.class);
                        intent.putExtra("CNP",getIntent().getStringExtra("CNP"));
                        startActivity(intent);
                        break;
                    case R.id.withdraw_menu:
                        selectedFragment = new WithdrawMoneyFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment).commit();
                        break;
                    case R.id.MyBets_menu:
                        selectedFragment = new MyBetsFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment).commit();
                        break;
                    case R.id.betTicket_menu:
                        selectedFragment = new BetTicketFragment();
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,selectedFragment).commit();
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
