package com.example.focuson.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Tugas.class, Reward.class}, version = 2, exportSchema = false)
@TypeConverters({DateConverters.class})
public abstract class FocusOnRoomDatabase extends RoomDatabase {
    public abstract TugasDAO tugasDao();
    public abstract RewardDAO rewardDAO();

    private static FocusOnRoomDatabase INSTANCE;

    public static FocusOnRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (FocusOnRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    FocusOnRoomDatabase.class, "word_database")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;
    }

    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };

    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final TugasDAO mTugasDao;
        private static String [] namaTugas = {"Tugas Menggambar", "Menonton TV", "Tugas Mewarnai", "Mengikat Sepatu"};
        private static Integer [] durasi = {1800, 600, 1800, 600};

        PopulateDbAsync(FocusOnRoomDatabase db) {
            mTugasDao = db.tugasDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            if (mTugasDao.getTugas(0) == null) {
                for (int i = 0; i < namaTugas.length; i++) {
                    Tugas tugas = new Tugas(namaTugas[i], durasi[i]);
                    mTugasDao.insert(tugas);
                }
            }
            return null;
        }
    }
}
