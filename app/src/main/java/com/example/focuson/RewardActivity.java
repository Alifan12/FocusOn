package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.focuson.database.Reward;

import java.util.ArrayList;

public class RewardActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterAddReward adapter;
    private ArrayList<Reward> rewardArray;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_add_reward);

        addData();

        recyclerView = findViewById(R.id.rv_rewardList);

        adapter = new AdapterAddReward(rewardArray);

        gridLayoutManager = new GridLayoutManager(RewardActivity.this, 2);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    void addData() {
        rewardArray = new ArrayList<>();
        rewardArray.add(new Reward("Sepatu", R.drawable.sepatu));
        rewardArray.add(new Reward("Permen",R.drawable.permen));
        rewardArray.add(new Reward("Baju", R.drawable.baju));
    }

    public void backHomeActivity(View view) {RewardActivity.this.finish();
    }

    public void openListReward(View view) {
        Intent intent = new Intent(this, RewardListActivity.class);
        startActivity(intent);
    }
}