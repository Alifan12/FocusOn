package com.example.focuson.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class RewardRepository {
    private RewardDAO mRewardDAO;
    private LiveData<List<Reward>> mAllReward;

    RewardRepository(Application application) {
        FocusOnRoomDatabase db = FocusOnRoomDatabase.getDatabase(application);
        mRewardDAO = db.rewardDAO();
        mAllReward = mRewardDAO.getAllReward();
    }

    LiveData<List<Reward>> getAllReward() {
        return mAllReward;
    }

    public Reward getReward(int id) {
        try {
            return new RewardRepository.getRewardAsyncTask(mRewardDAO).execute(id).get();
        } catch (ExecutionException | InterruptedException ei) {
            ei.printStackTrace();
            return null;
        }
    }

    public void insert(Reward reward) {
        new RewardRepository.insertAsyncTask(mRewardDAO).execute(reward);
    }

    public void deleteAll() {
        new RewardRepository.deleteAllWordsAsyncTask(mRewardDAO).execute();
    }

    // Need to run off main thread
    public void deleteReward(Reward reward) {
        new RewardRepository.deleteWordAsyncTask(mRewardDAO).execute(reward);
    }

    /**
     * Insert a word into the database.
     */
    private static class insertAsyncTask extends AsyncTask<Reward, Void, Void> {

        private RewardDAO mAsyncTaskDao;

        insertAsyncTask(RewardDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Reward... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class getRewardAsyncTask extends AsyncTask <Integer, Void, Reward> {
        private RewardDAO mAsyncTaskDAO;
        private Reward reward;
        getRewardAsyncTask(RewardDAO dao) {mAsyncTaskDAO = dao;}

        @Override
        protected Reward doInBackground(Integer... id){
            this.reward = mAsyncTaskDAO.getReward(id[0]);
            return this.reward;
        }

        @Override
        protected void onPostExecute(Reward reward) {
        }
    }

    /**
     * Delete all words from the database (does not delete the table)
     */
    private static class deleteAllWordsAsyncTask extends AsyncTask<Void, Void, Void> {
        private RewardDAO mAsyncTaskDao;

        deleteAllWordsAsyncTask(RewardDAO dao) {
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
    private static class deleteWordAsyncTask extends AsyncTask<Reward, Void, Void> {
        private RewardDAO mAsyncTaskDao;

        deleteWordAsyncTask(RewardDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Reward... params) {
            mAsyncTaskDao.deleteReward(params[0]);
            return null;
        }
    }
}
