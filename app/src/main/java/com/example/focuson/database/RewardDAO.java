package com.example.focuson.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RewardDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Reward... reward);

    @Query("DELETE FROM reward_table")
    void deleteAll();

    @Delete
    void deleteReward(Reward... reward);

    @Query("SELECT * from reward_table WHERE id == :id")
    Reward getReward(Integer id);

    @Query("SELECT * from reward_table ORDER BY id ASC")
    LiveData<List<Reward>> getAllReward();

}
