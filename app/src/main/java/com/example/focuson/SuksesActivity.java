package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class SuksesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sukses);
    }

    public void backHomeActivity(View view) {
        Intent intent = new Intent(this, TugasListActivity.class);
        startActivity(intent);
    }

    public void openListReward(View view){
        Intent intent = new Intent(this, RewardListActivity.class);
        startActivity(intent);
    }
}