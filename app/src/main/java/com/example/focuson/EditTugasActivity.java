package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.Window;

import com.example.focuson.database.TugasViewModel;

public class EditTugasActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    private static TugasViewModel tugasViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_edit_tugas);


        recyclerView = findViewById(R.id.rvEditTugas);
        final AdapterEditTugas adapter = new AdapterEditTugas(this);
        recyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        tugasViewModel = new ViewModelProvider(this).get(TugasViewModel.class);
        tugasViewModel.getAllTugas().observe(this, tugas -> {
            adapter.setTugas(tugas);
        });
    }

    public void openAddTugas(View view) {

    }

    public void backHomeActivity(View view) {
        EditTugasActivity.this.finish();
    }
}