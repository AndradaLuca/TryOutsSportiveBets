package com.example.marius.sportivebets.home;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.generated.callback.OnClickListener;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import com.example.marius.sportivebets.R;
import com.example.marius.sportivebets.databinding.ActivityMainBinding;
import com.example.marius.sportivebets.home.bottomNavFragments.betTicket.BetTicketFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.DepositMoney.DepositMoneyFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.HomeFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.MyBetsFragment;
import com.example.marius.sportivebets.home.bottomNavFragments.withdrawMoney.WithdrawMoneyFragment;
import com.example.marius.sportivebets.utils.Constants;

public class HomeActivity extends AppCompatActivity {



    ActivityMainBinding mainBinding;
    RecyclerView recyclerView,recyclerViewBetTicke;
    DrawerLayout drawerLayout;
    RecyclerView.Adapter adapter,adapterBetTicket;
    ActionBarDrawerToggle mToogle;
    private HomeViewModel homeViewModel;
    String CNP,email,password;
    Double ammount;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        CNP = getIntent().getStringExtra("CNP");
        email = getIntent().getStringExtra("email");
        password = getIntent().getStringExtra("password");
        mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainBinding.bottomNavView.enableAnimation(true);
        mainBinding.bottomNavView.enableItemShiftingMode(false);
        mainBinding.bottomNavView.enableShiftingMode(false);
        mainBinding.bottomNavView.setTextVisibility(false);

        recyclerView = mainBinding.recycleView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        drawerLayout = mainBinding.drawerLayout;
        recyclerView.setHasFixedSize(false);

        adapter = new HomeRecyclerAdapter(Constants.menuItems);
        recyclerView.setAdapter(adapter);


//        drawerLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                drawerLayout.closeDrawers();
//            }
//        });


        mToogle = new ActionBarDrawerToggle(this,mainBinding.drawerLayout,R.string.open,R.string.close);

        mainBinding.drawerLayout.addDrawerListener(mToogle);
        mToogle.syncState();

   
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

 
    


        Bundle bundle = new Bundle();
        bundle.putDouble("ammount", getIntent().getDoubleExtra("ammount",0.0));
        bundle.putString("CNP", getIntent().getStringExtra("CNP"));
        HomeFragment homeFragmentObject = new HomeFragment();
  homeFragmentObject.setArguments(bundle);
    
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder,homeFragmentObject).commit();




        mainBinding.bottomNavView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment selectedFragment = null;

                switch(item.getItemId()){
                    case R.id.home_menu:
                        initViewModel();
                        Bundle bundle = new Bundle();
                        bundle.putDouble("ammount", ammount);
                        bundle.putString("CNP", CNP);
                        HomeFragment fragobj = new HomeFragment();
                        fragobj.setArguments(bundle);
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right).replace(R.id.fragment_holder,fragobj).commit();
                        break;

                    case R.id.deposit_menu:
                        initViewModel();
                        Bundle bundle2 = new Bundle();
                        bundle2.putDouble("ammount", ammount);
                        bundle2.putString("CNP", CNP);
                        bundle2.putString("email", email);
                        bundle2.putString("password", password);
                        DepositMoneyFragment depositMoneyFragment = new DepositMoneyFragment();
                        depositMoneyFragment.setArguments(bundle2);
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right).replace(R.id.fragment_holder,depositMoneyFragment).commit();
                        break;
                    case R.id.withdraw_menu:
                        initViewModel();
                        Bundle bundle1 = new Bundle();
                        bundle1.putDouble("ammount", ammount);
                        bundle1.putString("CNP", CNP);
                        bundle1.putString("email", email);
                        bundle1.putString("password", password);
                        WithdrawMoneyFragment fragobj1 = new WithdrawMoneyFragment();
                        fragobj1.setArguments(bundle1);
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right).replace(R.id.fragment_holder,fragobj1).commit();
                        break;
                    case R.id.MyBets_menu:
                        selectedFragment = new MyBetsFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right).replace(R.id.fragment_holder,selectedFragment).commit();
                        break;
                    case R.id.betTicket_menu:
                        selectedFragment = new BetTicketFragment();
                        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right).replace(R.id.fragment_holder,selectedFragment).commit();
                       break;
                }

                return true;
            }
        });
    }



    private void initViewModel(){
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        ammount = homeViewModel.getBalance(email,password);
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)){

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
