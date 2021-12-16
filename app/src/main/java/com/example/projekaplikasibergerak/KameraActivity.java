package com.example.projekaplikasibergerak;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//import com.marcoscg.ipcamview.IPCamView;

public class KameraActivity extends AppCompatActivity {
    Button start;
    EditText URL;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kamera);
        start = findViewById(R.id.button);
        URL = findViewById(R.id.url);

//        IPCamView ipCamView = findViewById(R.id.ip_cam_view);
//        start.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                String l= URL.getText().toString();
//                if(l!=null){
//                    ipCamView.setUrl(l);
//                    ipCamView.setInterval(5);
//                    ipCamView.start();
//                }
//            }
//        });
    }
}