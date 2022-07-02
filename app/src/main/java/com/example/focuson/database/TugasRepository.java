package com.example.focuson.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class TugasRepository {
    private TugasDAO mTugasDAO;
    private LiveData<List<Tugas>> mAllTugas;

    TugasRepository(Application application) {
        FocusOnRoomDatabase db = FocusOnRoomDatabase.getDatabase(application);
        mTugasDAO = db.tugasDao();
        mAllTugas = mTugasDAO.getAllNotDoneTugas();
    }

    LiveData<List<Tugas>> getAllTugas() {
        return mAllTugas;
    }

    public void insert(Tugas tugas) {
        new insertAsyncTask(mTugasDAO).execute(tugas);
    }

    public void deleteAll() {
        new deleteAllWordsAsyncTask(mTugasDAO).execute();
    }

    // Need to run off main thread
    public void deleteTugas(Tugas tugas) {
        new deleteWordAsyncTask(mTugasDAO).execute(tugas);
    }

    /**
     * Insert a word into the database.
     */
    private static class insertAsyncTask extends AsyncTask<Tugas, Void, Void> {

        private TugasDAO mAsyncTaskDao;

        insertAsyncTask(TugasDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Tugas... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    /**
     * Delete all words from the database (does not delete the table)
     */
    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private TugasDAO mAsyncTaskDao;

        deleteAllWordsAsyncTask(TugasDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            mAsyncTaskDao.deleteAll();
            return null;
        }
    }

    /**
     *  Delete a single word from the database.
     */
    private static class deleteWordAsyncTask extends AsyncTask<Tugas, Void, Void> {
        private TugasDAO mAsyncTaskDao;

        deleteWordAsyncTask(TugasDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Tugas... params) {
            mAsyncTaskDao.deleteTugas(params[0]);
            return null;
        }
    }
}
