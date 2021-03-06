package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_home);
    }

    public void openListReward(View view) {
        Intent intent = new Intent(this, RewardActivity.class);
        startActivity(intent);
    }

    public void openListTugas(View view) {
        Intent intent = new Intent(this, TugasListActivity.class);
        startActivity(intent);
    }

    public void Out(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}