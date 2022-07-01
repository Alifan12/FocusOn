package com.example.focuson.database;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.sql.Time;

@Entity(tableName = "tugas_table")
public class Tugas {
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "id")
    private Integer id;

    @ColumnInfo(name = "name")
    private String nama;

    @ColumnInfo(name = "duration")
    private Integer duration;

    @ColumnInfo(name = "is_done")
    private Boolean is_done;

    @ColumnInfo(name = "time_start")
    private Time time_start;

    @ColumnInfo(name = "time_end")
    private Time time_end;

    @ColumnInfo(name = "reward_id")
    private int reward_id;


    public Tugas(@NonNull  Integer id,
                 @NonNull String nama,
                 @NonNull Integer duration,
                 @NonNull Boolean is_done,
                 @NonNull Time time_start,
                 Time time_end,
                 int reward_id) {
        this.id = id;
        this.nama = nama;
        this.duration = duration;
        this.is_done = is_done;
        this.time_start = time_start;
        this.time_end = time_end;
        this.reward_id = reward_id;
    }

    public Tugas(@NonNull String nama,
                 @NonNull Integer duration,
                 @NonNull Boolean is_done,
                 @NonNull Time time_start,
                 Time time_end,
                 int reward_id) {
        this.nama = nama;
        this.duration = duration;
        this.is_done = is_done;
        this.time_start = time_start;
        this.time_end = time_end;
        this.reward_id = reward_id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public boolean getIsDone() {
        return this.is_done;
    }

    public void setDuration(boolean is_done) {
        this.is_done = is_done;
    }

    public Time getTimeStart() {
        return this.time_start;
    }

    public void setTimeStart(Time time_start) {
        this.time_start = time_start;
    }

    public Time getTimeEnd() {
        return this.time_end;
    }

    public void setTimeEnd(Time time_end) {
        this.time_end = time_end;
    }

    public int getRewardId() {
        return this.reward_id;
    }

    public void setRewardId(int reward_id) {
        this.reward_id = reward_id;
    }
}
