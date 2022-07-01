package com.example.focuson;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class TugasDetailActivity extends AppCompatActivity {
    private static final long START_IN_MILLISECOND = 600000;
    private TextView text_view_countdown;
    private Button button_abort;

    private CountDownTimer countDownTimer;

    private long time_left =  START_IN_MILLISECOND;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_tugas_detail);

        this.countDownTimer = new CountDownTimer(time_left, 1000) {
            @Override
            public void onTick(long l) {
                time_left = l;
                updateCountDown();
            }

            @Override
            public void onFinish() {

            }
        }.start();
        this.text_view_countdown = findViewById(R.id.textViewCountdown);
        this.button_abort = findViewById(R.id.selesaiButton);

        this.button_abort.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TugasDetailActivity.this.finish();
            }
        });

    }

    private void updateCountDown(){
        int minutes = (int) (time_left / 1000) / 60;
        int seconds = (int) (time_left / 1000) % 60;

        String timeLeftFormatted = String.format(Locale.getDefault(),"%20d:%20d", minutes, seconds);
        this.text_view_countdown.setText(timeLeftFormatted);
    }

    public void backHomeActivity(View view) {
    }
}