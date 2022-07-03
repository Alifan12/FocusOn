package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.focuson.database.Tugas;
import com.example.focuson.database.TugasViewModel;

import java.util.Locale;

public class TugasDetailActivity extends AppCompatActivity {
    private static TugasViewModel tugasViewModel;
    private long START_IN_MILLISECOND;
    private TextView text_view_countdown;
    private Button button_abort;
    private Intent prevIntent;
    private int idTugas;
    private Tugas data;

    private CountDownTimer countDownTimer;

    private long time_left;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tugas_detail);

        this.prevIntent = getIntent();
        this.idTugas = prevIntent.getIntExtra("id", 1);

        this.tugasViewModel = new ViewModelProvider(this).get(TugasViewModel.class);
        this.data = tugasViewModel.getTugas(idTugas);
        this.START_IN_MILLISECOND = data.getDuration()*1000;
        this.time_left = START_IN_MILLISECOND;

        this.countDownTimer = new CountDownTimer(time_left, 1000) {
            @Override
            public void onTick(long l) {
                time_left = l;
                updateCountDown();
            }

            @Override
            public void onFinish() {
                time_left = 0;
            }
        }.start();

        this.text_view_countdown = findViewById(R.id.textViewCountdown);
        this.button_abort = findViewById(R.id.selesaiButton);

//        this.button_abort.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                TugasDetailActivity.this.finish();
//            }
//        });

    }

    private void updateCountDown(){
        int minutes = (int) (time_left / 1000) / 60;
        int seconds = (int) (time_left / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%20d:%20d", minutes, seconds);
        this.text_view_countdown.setText(timeLeftFormatted);
    }

    public void backHomeActivity(View view) {TugasDetailActivity.this.finish();}

    public void openSuksesTugas(View view) {
        if(time_left <= 0){
            prevIntent = new Intent(this, SuksesActivity.class);
            startActivity(prevIntent);
        }else if(time_left > 0){
            prevIntent = new Intent(this, FailedActivity.class);
            startActivity(prevIntent);
        }
    }
}