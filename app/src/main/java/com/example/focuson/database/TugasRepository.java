package com.example.focuson.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

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

    public Tugas getTugas(int id) {
        try {
            return new getTugasAsyncTask(mTugasDAO).execute(id).get();
        } catch (ExecutionException | InterruptedException ei) {
            ei.printStackTrace();
            return null;
        }
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

    private static class getTugasAsyncTask extends AsyncTask <Integer, Void, Tugas> {
        private TugasDAO mAsyncTaskDAO;
        private Tugas tugas;
        getTugasAsyncTask(TugasDAO dao) {mAsyncTaskDAO = dao;}

        @Override
        protected Tugas doInBackground(Integer... id){
            this.tugas = mAsyncTaskDAO.getTugas(id[0]);
            return this.tugas;
        }

        @Override
        protected void onPostExecute(Tugas tugas) {
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
