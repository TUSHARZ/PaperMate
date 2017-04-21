package com.example.acer.firstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    private TextView tvabout,tvcontent ,tvversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tvabout=(TextView)findViewById(R.id.tvabout);
        tvcontent=(TextView)findViewById(R.id.tvcontent);
        tvversion=(TextView)findViewById(R.id.tvversion);

        tvabout.setText("ABOUT US");

        tvcontent.setText("\"PaperMate\" is the dream to fulfill every wannabe " +
                          "Engineer's most obvious requirement , hassle-free " +
                          "supply of some standard study material. So that you " +
                          "can focus on learning without worries. Be it the day one " +
                          "of the semester, or the end moment revision." +
                          "\nMeet the developer team from \" IT-Morning, 2nd year from 'Maharaja Surajmal Institute Of Technology'  \" " +
                          "who made it possible :" +
                          "\nTushar Gupta\nChhavi Aggarwal\nKomal Bansal\nAbhishek Verma"+
                          "\n\nWe owe a huge thanks for joining us on this awesome journey, " +
                          "and we hope that you’ll continue to be a part of our story.");

        tvversion.setText("VERSION 1.1");

        // android:textColor="#36369b"

    }
}
