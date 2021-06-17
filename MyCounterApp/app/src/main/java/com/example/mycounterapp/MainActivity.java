 package com.example.mycounterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class MainActivity extends AppCompatActivity {


    TextView output;
    Button start, stop;
    int cValue = 0;
    Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = (TextView)findViewById(R.id.cValue);
        start = (Button)findViewById(R.id.start);
        stop = (Button)findViewById(R.id.stop);

        handler = new Handler();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.postDelayed(runnable,0);
            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.removeCallbacks(runnable);
            }
        });

    }





    public Runnable runnable = new Runnable() {
        @Override
        public void run() {
            cValue++;
            output.setText(String.format("%d",cValue));
            handler.postDelayed(this,1000);

        }
    };
}