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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

}

