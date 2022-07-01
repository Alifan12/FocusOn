package com.example.focuson.database;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import androidx.lifecycle.LiveData;

import java.util.List;

@Dao
public interface TugasDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Tugas tugas);

    @Query("DELETE FROM tugas_table")
    void deleteAll();

    @Delete
    void deleteTugas(Tugas tugas);

    @Query("SELECT * from tugas_table WHERE id == :id LIMIT 1")
    Tugas getTugas(Integer id);

    @Query("SELECT * from tugas_table WHERE is_done == 0 ORDER BY id ASC")
    LiveData<List<Tugas>> getAllNotDoneTugas();

    @Query("SELECT * from tugas_table WHERE is_done == 1 ORDER BY id ASC")
    LiveData<List<Tugas>> getAllDoneTugas();
}
