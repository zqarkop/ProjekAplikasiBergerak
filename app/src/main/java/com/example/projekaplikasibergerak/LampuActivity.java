package com.example.projekaplikasibergerak;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import com.akaita.android.circularseekbar.CircularSeekBar;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DecimalFormat;

public class LampuActivity extends AppCompatActivity {

    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lampu);

        mDatabase = FirebaseDatabase.getInstance();

        CircularSeekBar lampuRuang1 = (CircularSeekBar) findViewById(R.id.lampuRuang1);
        lampuRuang1.setProgressTextFormat(new DecimalFormat("###,###,##0.00"));
        lampuRuang1.setRingColor(Color.GREEN);

        lampuRuang1.setOnCenterClickedListener(new CircularSeekBar.OnCenterClickedListener() {
            @Override
            public void onCenterClicked(CircularSeekBar seekBar, float progress) {
                Snackbar.make(seekBar, "Reset", Snackbar.LENGTH_SHORT)
                        .show();
                seekBar.setProgress(0);
            }
        });

        lampuRuang1.setOnCircularSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar seekBar, float progress, boolean fromUser) {
                int nilaiSeekBar;
                nilaiSeekBar = (int)progress;
                mDatabase.getReference("lampuRuang1").setValue(nilaiSeekBar).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }
        });

        CircularSeekBar lampuRuang2 = (CircularSeekBar) findViewById(R.id.lampuRuang2);
        lampuRuang2.setProgressTextFormat(new DecimalFormat("###,###,##0.00"));
        lampuRuang2.setRingColor(Color.BLUE);

        lampuRuang2.setOnCenterClickedListener(new CircularSeekBar.OnCenterClickedListener() {
            @Override
            public void onCenterClicked(CircularSeekBar seekBar, float progress) {
                Snackbar.make(seekBar, "Reset", Snackbar.LENGTH_SHORT)
                        .show();
                seekBar.setProgress(0);
            }
        });

        lampuRuang2.setOnCircularSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar seekBar, float progress, boolean fromUser) {
                int nilaiSeekBar;
                nilaiSeekBar = (int)progress;
                mDatabase.getReference("lampuRuang2").setValue(nilaiSeekBar).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }
        });

        CircularSeekBar lampuRuang3 = (CircularSeekBar) findViewById(R.id.lampuRuang3);
        lampuRuang3.setProgressTextFormat(new DecimalFormat("###,###,##0.00"));
        lampuRuang3.setRingColor(Color.RED);

        lampuRuang3.setOnCenterClickedListener(new CircularSeekBar.OnCenterClickedListener() {
            @Override
            public void onCenterClicked(CircularSeekBar seekBar, float progress) {
                Snackbar.make(seekBar, "Reset", Snackbar.LENGTH_SHORT)
                        .show();
                seekBar.setProgress(0);
            }
        });

        lampuRuang3.setOnCircularSeekBarChangeListener(new CircularSeekBar.OnCircularSeekBarChangeListener() {
            @Override
            public void onProgressChanged(CircularSeekBar seekBar, float progress, boolean fromUser) {
                int nilaiSeekBar;
                nilaiSeekBar = (int)progress;
                mDatabase.getReference("lampuRuang3").setValue(nilaiSeekBar).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
            }

            @Override
            public void onStartTrackingTouch(CircularSeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(CircularSeekBar seekBar) {

            }
        });

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}