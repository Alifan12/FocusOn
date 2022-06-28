package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import java.util.ArrayList;
import java.util.List;

public class TugasListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    AdapterTugas tugasAdapter;
    List<String> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tugas_list);


        recyclerView = findViewById(R.id.rvTugas);
        listData = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            listData.add("tugas ke " + i);
        }
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        tugasAdapter = new AdapterTugas(this, listData);
        recyclerView.setAdapter(tugasAdapter);
        tugasAdapter.notifyDataSetChanged();
    }


    public void backHomeActivity(View view) {

    }
}