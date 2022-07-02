package com.example.focuson.database;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.sql.Date;

@Entity(tableName = "tugas_table")
public class Tugas {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    public Integer id;

    @ColumnInfo(name = "name")
    public String nama;

    @ColumnInfo(name = "duration")
    public Integer duration;

    @ColumnInfo(name = "is_done")
    public Boolean is_done;

    @ColumnInfo(name = "time_start")
    public Date time_start;

    @ColumnInfo(name = "time_end")
    public Date time_end;

    @ColumnInfo(name = "reward_id")
    public int reward_id;


    @Ignore
    public Tugas(Integer id,
                 String nama,
                 Integer duration
                 ) {
        this.setId(id);
        this.setNama(nama);
        this.setDuration(duration);
        this.setIsDone(Boolean.FALSE);
    }

    public Tugas(String nama,
                 Integer duration) {
        this.setNama(nama);
        this.setDuration(duration);
        this.setIsDone(Boolean.FALSE);
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Boolean getIsDone() {
        return this.is_done;
    }

    public void setIsDone(boolean is_done) {
        this.is_done = is_done;
    }

    public Date getTimeStart() {
        return this.time_start;
    }

    public void setTimeStart(Date time_start) {
        this.time_start = time_start;
    }

    public Date getTimeEnd() {
        return this.time_end;
    }

    public void setTimeEnd(Date time_end) {
        this.time_end = time_end;
    }

    public Integer getRewardId() {
        return this.reward_id;
    }

    public void setRewardId(int reward_id) {
        this.reward_id = reward_id;
    }

    @NonNull
    public Integer getId() {
        return id;
    }

    public void setId(@NonNull Integer id) {
        this.id = id;
    }
}
