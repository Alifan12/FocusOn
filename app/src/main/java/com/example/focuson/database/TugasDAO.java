package com.example.focuson.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface TugasDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Tugas... tugas);

    @Query("DELETE FROM tugas_table")
    void deleteAll();

    @Delete
    void deleteTugas(Tugas... tugas);

    @Query("SELECT * from tugas_table WHERE id == :id")
    Tugas getTugas(Integer id);

    @Query("SELECT * from tugas_table WHERE is_done == 0 ORDER BY id ASC")
    LiveData<List<Tugas>> getAllNotDoneTugas();

    @Query("SELECT * from tugas_table WHERE is_done == 1 ORDER BY id ASC")
    List<Tugas> getAllDoneTugas();
}
