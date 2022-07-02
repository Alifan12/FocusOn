package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.focuson.database.Reward;

import java.util.ArrayList;
import java.util.List;

public class RewardListActivity extends AppCompatActivity {
    RecyclerView rewardList;
    List<String> titles;
    List<Integer> images;
    ArrayList<Reward> rewardArray;
    RewardListAdapter adapter;
    AdapterAddReward adapterAddReward;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        addData();

        rewardList = findViewById(R.id.rv_rewardList);

        titles = new ArrayList<>();
        images = new ArrayList<>();

        titles.add("Mainan");
        titles.add("Sepatu");
        titles.add("Permen");
        titles.add("Baju");
        titles.add("Lainnya+");

        images.add(R.drawable.reward1);
        images.add(R.drawable.reward2);
        images.add(R.drawable.reward3);
        images.add(R.drawable.reward4);
        images.add(R.drawable.tambah_lainnya);

        adapter = new RewardListAdapter(this, titles, images);
        adapterAddReward = new AdapterAddReward(rewardArray);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2, GridLayoutManager.VERTICAL, false);
        rewardList.setLayoutManager(gridLayoutManager);
        rewardList.setAdapter(adapter);
        rewardList.setAdapter(adapterAddReward);
    }

    void addData() {
        rewardArray = new ArrayList<>();
    }
}
