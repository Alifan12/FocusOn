package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class FailedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_failed);
    }

    public void backListActivity(View view) {
        Intent intent = new Intent(this, TugasListActivity.class);
        startActivity(intent);
    }

    public void Coba(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}