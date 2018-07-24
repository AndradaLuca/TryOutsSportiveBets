package com.example.marius.sportivebets.ViewModel;



import android.app.Application;
import android.arch.lifecycle.LiveData;

public class UserViewModel {
    private BetRepository mRepository;
    private LiveData<String> username;
    public UserViewModel(Application application){
        //super(application);
        mRepository = new BetRepository(application);

    }
}
