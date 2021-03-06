package com.example.projekaplikasibergerak;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

//    import android.support.v7.app.AppCompatActivity; Done
//    import android.support.annotation.NonNull;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mButtonKipas;
    ImageView mButtonLampu;
    ImageView mButtonAlarm;
    ImageView mButtonAc;

    boolean keadaanKipas = false;
    boolean keadaanLampu = false;
    boolean keadaanAlarm = false;
    boolean keadaanAc = false;

    int countKipas = 1;
    int countAlarm = 1;
    int countAC = 1;

    Animation scaleUp,scaleDown;

    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatabase = FirebaseDatabase.getInstance();

        mButtonKipas = findViewById(R.id.button_kipas);
        mButtonLampu = findViewById(R.id.button_lampu);
        mButtonAlarm = findViewById(R.id.button_alarm);
        mButtonAc = findViewById(R.id.button_ac);

        scaleUp = AnimationUtils.loadAnimation(this,R.anim.scale_up);
        scaleDown = AnimationUtils.loadAnimation(this,R.anim.scale_down);

        mButtonKipas.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()== MotionEvent.ACTION_UP) {
                    mButtonKipas.startAnimation(scaleUp);
                }else if(motionEvent.getAction()== MotionEvent.ACTION_DOWN) {
                    mButtonKipas.startAnimation(scaleDown);
                }
                if(keadaanKipas == false){
                    turnOffKipas();
                    keadaanKipas = true;
                    countKipas++;
                }
                else{
                    if(countKipas == 2){
                        turnOnKipas();
                        countKipas = 0;
                    }
                    keadaanKipas = false;
                }

                return true;
            }
        });
        mButtonAlarm.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()== MotionEvent.ACTION_UP) {
                    mButtonAlarm.startAnimation(scaleUp);
                }else if(motionEvent.getAction()== MotionEvent.ACTION_DOWN) {
                    mButtonAlarm.startAnimation(scaleDown);
                }
                if(keadaanAlarm == false){
                    turnOffAlarm();
                    keadaanAlarm = true;
                    countAlarm++;
                }
                else{
                    if(countAlarm == 2){
                        turnOnAlarm();
                        countAlarm = 0;
                    }
                    keadaanAlarm = false;
                }

                return true;
            }
        });
        mButtonAc.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                if(motionEvent.getAction()== MotionEvent.ACTION_UP) {
                    mButtonAc.startAnimation(scaleUp);
                }else if(motionEvent.getAction()== MotionEvent.ACTION_DOWN) {
                    mButtonAc.startAnimation(scaleDown);
                }
                if(keadaanAc == false){
                    turnOffAc();
                    keadaanAc = true;
                    countAC++;
                }
                else{
                    if(countAC == 2){
                        turnOnAc();
                        countAC = 0;
                    }
                    keadaanAc = false;
                }

                return true;
            }
        });
        mButtonLampu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LampuActivity.class));
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_kipas:
                if(keadaanKipas == false){
                    turnOnKipas();
                    keadaanKipas = true;
                    break;
                }
                else{
                    turnOffKipas();
                    keadaanKipas = false;
                    break;
                }
        }
        switch (view.getId()) {
            case R.id.button_lampu:
                if(keadaanLampu == false){
                    turnOnLampu();
                    keadaanLampu = true;
                    break;
                }
                else{
                    turnOffLampu();
                    keadaanLampu = false;
                    break;
                }
        }
        switch (view.getId()) {
            case R.id.button_alarm:
                if(keadaanAlarm == false){
                    turnOnAlarm();
                    keadaanAlarm = true;
                    break;
                }
                else{
                    turnOffAlarm();
                    keadaanAlarm = false;
                    break;
                }
        }
        switch (view.getId()) {
            case R.id.button_ac:
                if(keadaanAc == false){
                    turnOnAc();
                    keadaanAc = true;
                    break;
                }
                else{
                    turnOffAc();
                    keadaanAc = false;
                    break;
                }
        }
    }

    void turnOnKipas() {
        mDatabase.getReference("kipas").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "KIPAS MENYALA", Toast.LENGTH_SHORT).show();
                    mButtonKipas.setImageResource(R.drawable.ic_fan);
                }
            }
        });
    }

    void turnOffKipas() {
        mDatabase.getReference("kipas").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "KIPAS MATI", Toast.LENGTH_SHORT).show();
                    mButtonKipas.setImageResource(R.drawable.ic_fan_off);
                }
            }
        });
    }



    void turnOnLampu() {
        mDatabase.getReference("lampu").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "LAMPU MENYALA", Toast.LENGTH_SHORT).show();
                    mButtonLampu.setImageResource(R.drawable.light_on);
                }
            }
        });
    }

    void turnOffLampu() {
        mDatabase.getReference("lampu").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "LAMPU MATI", Toast.LENGTH_SHORT).show();
                    mButtonLampu.setImageResource(R.drawable.ic_lightbulb_outline);
                }
            }
        });
    }


    void turnOnAlarm() {
        mDatabase.getReference("alarm").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "ALARM MENYALA", Toast.LENGTH_SHORT).show();
                    mButtonAlarm.setImageResource(R.drawable.ic_alarm_light);
                }
            }
        });
    }

    void turnOffAlarm() {
        mDatabase.getReference("alarm").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "ALARM MATI", Toast.LENGTH_SHORT).show();
                    mButtonAlarm.setImageResource(R.drawable.ic_alarm_light_outline);
                }
            }
        });
    }

    void turnOnAc() {
        mDatabase.getReference("ac").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "AC MENYALA", Toast.LENGTH_SHORT).show();
                    mButtonAc.setImageResource(R.drawable.ic_acon);
                }
            }
        });
    }

    void turnOffAc() {
        mDatabase.getReference("ac").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "AC MATI", Toast.LENGTH_SHORT).show();
                    mButtonAc.setImageResource(R.drawable.ic_acoff);
                }
            }
        });
    }

    }

