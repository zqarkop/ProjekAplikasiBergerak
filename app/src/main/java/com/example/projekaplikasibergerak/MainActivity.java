package com.example.projekaplikasibergerak;

import android.opengl.Visibility;
//    import android.support.v7.app.AppCompatActivity; Done
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
//    import android.support.annotation.NonNull;
import androidx.annotation.NonNull;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView mButtonKipas;
    ImageView mButtonLampu;
    ImageView mButtonAlarm;
    ImageView mButtonAc;

    boolean keadaanKipas = false;
    boolean keadaanLampu = false;
    boolean keadaanAlarm = false;
    boolean keadaanAc = false;

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

        mButtonKipas.setOnClickListener(this);
        mButtonLampu.setOnClickListener(this);
        mButtonAlarm.setOnClickListener(this);
        mButtonAc.setOnClickListener(this);
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
                    mButtonKipas.setImageResource(R.drawable.light_on);
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
                    mButtonKipas.setImageResource(R.drawable.ic_fan);
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
                    mButtonAlarm.setImageResource(R.drawable.light_on);
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
                    mButtonAc.setImageResource(R.drawable.light_on);
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
                    mButtonAc.setImageResource(R.drawable.ic_air_conditioner);
                }
            }
        });
    }
}
