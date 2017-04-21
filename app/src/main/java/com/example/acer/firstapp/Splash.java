package com.example.acer.firstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class Splash extends AppCompatActivity {
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        progressBar= (ProgressBar) findViewById(R.id.progressBar);
        new Thread(new Runnable() {
            @Override
            public void run() {
                dowork();
                finish();
            }
        }).start();
    }

    private void dowork(){
        for(int progress=0;progress<100;progress+=1)
        {
            try {
                Thread.sleep(50);
                progressBar.setProgress(progress);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        startapp();
    }


    private void startapp(){
        Intent i=new Intent(Splash.this,MainScreen.class);
        startActivity(i);
    }
}
