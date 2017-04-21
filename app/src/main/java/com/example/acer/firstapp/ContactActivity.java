package com.example.acer.firstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ContactActivity extends AppCompatActivity {

    private TextView tvabout,tvcontent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        tvabout=(TextView)findViewById(R.id.tvabout);
        tvcontent=(TextView)findViewById(R.id.tvcontent);

        tvabout.setText("CONTACT US");

        tvcontent.setText("Contact No. :"+
                          "\n\n\nTushar Gupta : +91-9911374795\nAbhishek Verma : +91-8130986895 "+
                          "\n\n\n\nEmail Id :\n\nakvabhi2015@gmail.com \nchhavi.chhavi97@gmail.com\nkomalbansal97@gmail.com" +
                          "\ntusharrrrr97@gmail.com ");
    }
}
