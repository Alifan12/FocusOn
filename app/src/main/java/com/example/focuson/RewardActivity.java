package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

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
        setContentView(R.layout.activity_reward_list_add);

        addData();

        recyclerView = findViewById(R.id.rv_rewardList);

        adapter = new AdapterAddReward(rewardArray);

        gridLayoutManager = new GridLayoutManager(RewardActivity.this, 2);

        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }

    void addData() {
        rewardArray = new ArrayList<>();
        rewardArray.add(new Reward(R.drawable.sepatu, "Sepatu"));
    }

    public void backHomeActivity(View view) {RewardActivity.this.finish();
    }
}