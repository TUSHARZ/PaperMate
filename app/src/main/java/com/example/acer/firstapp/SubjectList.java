package com.example.acer.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class SubjectList extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_list);
        final int[] imglist={R.drawable.oops,R.drawable.coa2,R.drawable.dbms,R.drawable.cs,R.drawable.am,R.drawable.toc2,R.drawable.comsys};
        rv= (RecyclerView) findViewById(R.id.rv);
        rv.setAdapter(new RecyclerView.Adapter() {
            @Override
            public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
                View myview=getLayoutInflater().inflate(R.layout.img_item,parent,false);
                SubjectViewHolder imageViewHolder=new SubjectViewHolder(myview);
                return imageViewHolder;
            }

            @Override
            public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
                SubjectViewHolder imageViewHolder= (SubjectViewHolder) holder;
                imageViewHolder.img.setImageResource(imglist[position]);

            }

            @Override
            public int getItemCount() {
                return imglist.length;
            }
        });
        rv.setLayoutManager(new LinearLayoutManager(this));


    }
}
