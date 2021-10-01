package com.example.projekaplikasibergerak;

import android.opengl.Visibility;
//    import android.support.v7.app.AppCompatActivity; Java nya gabisa
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

    ToggleButton mButtonPower;
    ToggleButton mButtonAuto;
    ImageView mImageStatus;

    FirebaseDatabase mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mDatabase = FirebaseDatabase.getInstance();


        mButtonPower = findViewById(R.id.button_power);
        mButtonAuto = findViewById(R.id.button_auto);
        mImageStatus = findViewById(R.id.imageView);


        mButtonPower.setOnClickListener(this);
        mButtonAuto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_power:
                toggleLed();
                break;
        }
        switch (view.getId()) {
            case R.id.button_auto:
                toggleAuto();
                break;
        }
    }

    void toggleLed() {
        if (mButtonPower.isChecked()) {
            turnOnLed();
        } else {
            turnOffLed();
        }
    }

    void toggleAuto() {
        if (mButtonAuto.isChecked()) {
            mButtonPower.setVisibility(View.VISIBLE);
            turnOnAuto();
        } else {
            turnOffAuto();
        }
    }

    void turnOnLed() {
        mButtonPower.setEnabled(false);
        mDatabase.getReference("manual").
                setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "LAMPU MENYALA", Toast.LENGTH_SHORT).show();
                    mButtonPower.setChecked(true);
                    mImageStatus.setImageResource(R.drawable.light_on);
                }
                mButtonPower.setEnabled(true);
            }
        });
    }

    void turnOffLed() {
        mButtonPower.setEnabled(false);
        mDatabase.getReference("manual").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "LAMPU MATI", Toast.LENGTH_SHORT).show();
                    mButtonPower.setChecked(false);
                    mImageStatus.setImageResource(R.drawable.light_off);
                }
                mButtonPower.setEnabled(true);
            }
        });
    }

    void turnOnAuto() {
        mButtonAuto.setEnabled(false);
        mDatabase.getReference("otomatis").setValue(1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "FITUR OTOMATIS MENYALA", Toast.LENGTH_SHORT).show();
                    mButtonAuto.setChecked(true);
                    mImageStatus.setImageResource(R.drawable.light_off);
                }
                mButtonAuto.setEnabled(true);
            }
        });
    }

    void turnOffAuto() {
        mButtonAuto.setEnabled(false);
        mDatabase.getReference("otomatis").setValue(0).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    Toast.makeText(MainActivity.this, "FITUR OTOMATIS MATI", Toast.LENGTH_SHORT).show();
                    mButtonAuto.setChecked(false);
                    mImageStatus.setImageResource(R.drawable.light_off);
                }
                mButtonAuto.setEnabled(true);
            }
        });
    }
}
