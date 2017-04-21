package com.example.acer.firstapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;


public class SubjectViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    public ImageView img;
    private Intent intent;
    private Context context;
    private final String TAG = "Aptech";

    public SubjectViewHolder(View itemView) {
        super(itemView);
        img = (ImageView) itemView.findViewById(R.id.img);
        context = itemView.getContext();
        img.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.d(TAG, "onClick: "+getAdapterPosition());
        switch (getAdapterPosition()) {
            case 0:
                intent = new Intent(context, Oops.class);
                break;
            case 1:
                intent = new Intent(context, COA.class);
                break;
            case 2:
                intent=new Intent(context,Dbms.class);
                break;
            case 3:
                intent=new Intent(context,Cs.class);
                break;
            case 4:
                intent=new Intent(context,AM.class);
                break;
            case 5:
                intent=new Intent(context,Toc.class);
                break;
            case 6:
                intent=new Intent(context,CommSys.class);
                break;
        }
        context.startActivity(intent);
    }
}
