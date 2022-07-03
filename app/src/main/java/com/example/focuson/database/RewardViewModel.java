package com.example.focuson.database;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class RewardViewModel extends AndroidViewModel {
    private RewardRepository mRepository;

    private LiveData<List<Reward>> mAllReward;

    public RewardViewModel(Application application) {
        super(application);
        mRepository = new RewardRepository(application);
        mAllReward = mRepository.getAllReward();
    }

    public LiveData<List<Reward>> getAllReward() {
        return mAllReward;
    }

    public Reward getReward(int id) {
        return mRepository.getReward(id);
    }
}
