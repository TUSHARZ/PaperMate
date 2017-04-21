package com.example.acer.firstapp;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainScreen extends AppCompatActivity {

    private ImageView iv;
    private Handler handler;
    public int counter=0;
    public ConnectivityManager cm;
    public Dialog d;
    public Boolean condition;
  public int request=1;
    private Runnable r;
    private ImageButton babout,bcontact,bsem,bsyllabus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        iv = (ImageView) findViewById(R.id.iv);
        condition=true;
        babout=(ImageButton)findViewById(R.id.btnAbout);
        bcontact=(ImageButton) findViewById(R.id.btnContact);
        android.support.v7.app.ActionBar ab= getSupportActionBar();


        ab.setTitle("PaperMate");
        ab.setDisplayShowHomeEnabled(true);
        d=new Dialog(this);
        d.setContentView(R.layout.dialog);
        d.setTitle("No Internet Connection");
        d.setCancelable(false);
        TextView text=(TextView)d.findViewById(R.id.textView);
        text.setText("Please Enable Your Internet");
        text.setTextColor(Color.RED);
        Button btn=(Button)d.findViewById(R.id.button2);
        bsem=(ImageButton)findViewById(R.id.btnSemester);
        bsyllabus=(ImageButton)findViewById(R.id.btnSyllabus);
        cm=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE) ;
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M) {
            if (checkSelfPermission(
                    android.Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Granted", Toast.LENGTH_LONG);

            } else {
                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, request);
            }

        }

        NetworkInfo info=cm.getActiveNetworkInfo();

            if(!(info!=null&&info.isConnected()==true)){
                condition=false;
                d.show();
                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),MainScreen.class));
                    }
                });


        }
        bsem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainScreen.this,SubjectList.class);
                startActivity(i);
            }
        });

        babout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainScreen.this,AboutActivity.class);
                startActivity(i);
            }
        });

        bcontact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(MainScreen.this,ContactActivity.class);
                startActivity(i);
            }
        });

        bsyllabus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent send=new Intent(MainScreen.this,PreviewActivity.class);
                send.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4c0JkS29lbTFKNkk");
                startActivity(send);

            }
        });

      final int[] images = {R.drawable.first, R.drawable.second, R.drawable.third,
                              R.drawable.fourth, R.drawable.fifth,R.drawable.sixth,
                              R.drawable.seventh,R.drawable.eight,R.drawable.ninth,
                              R.drawable.tenth,R.drawable.eleventh,R.drawable.twelveth,
                              R.drawable.thirteenth,R.drawable.fourteen,R.drawable.fifteenth };
     if(condition==true){
        handler = new Handler();
        r = new Runnable() {
            @Override
            public void run() {
                Log.d("KK", "run: " + counter);
                iv.setImageResource(images[counter]);
                if (counter >= images.length - 1) {
                    counter = 0;
                } else
                    counter++;
                handler.postDelayed(r, 4000);
            }
        };
        handler.postDelayed(r, 4000);
    }}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.newmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==R.id.share){
            Intent share=new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");

            share.putExtra(Intent.EXTRA_TEXT,"PaperMate \n" +
                    "Making Subjects Sensible\n" +
                    "\n" +
                    "Check it out :   https://goo.gl/C5mTME");
            startActivity(share);



        }
        if(item.getItemId()==R.id.help){
            startActivity(new Intent(getApplicationContext(),help.class));
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
