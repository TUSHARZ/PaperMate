package com.example.acer.firstapp;

import android.app.Dialog;
import android.app.DownloadManager;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class CommSys extends AppCompatActivity {
    public DownloadManager dm;
    public StorageReference sref;
    public Dialog pd;
    public TextView notavail;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comm_sys);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new NotesFragment()).commit();
        dm=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        sref= FirebaseStorage.getInstance().getReference().child("Sem 4 IT");
        pd=new Dialog(this);
        pd.setContentView(R.layout.notavailable);
        notavail=(TextView)pd.findViewById(R.id.notvailable);
        notavail.setText("NOT AVAILABLE \n Pls Check 'What's New' section'");
        notavail.setTextColor(Color.RED);


        auth= FirebaseAuth.getInstance();

    }
    public void changeme(View view) {
        int btnid=view.getId();
        FragmentManager mgr=getSupportFragmentManager();
        FragmentTransaction tran=mgr.beginTransaction();

        switch (btnid){
            case R.id.btnNotes:
                tran.replace(R.id.fragment,new NotesFragment());
                break;
            case R.id.btnPrev:
                tran.replace(R.id.fragment,new PrevyrsFragment());
                break;
            case R.id.btnAssignments:
                tran.replace(R.id.fragment,new AssignFragment());
                break;
        }
        tran.commit();
    }

    public void Click(View view) {
        switch (view.getId())
        {
            case R.id.ibdownload12:
                pd.show();
                break;
            case R.id.ibpreview12 :
                pd.show();
                break;
            case R.id.ibdownload22:
                pd.show();
                break;
            case R.id.ibpreview22:
                pd.show();
                break;
            case R.id.ibdownload32:
                pd.show();
                break;
            case R.id.ibpreview32:
                pd.show();
                break;
        }
    }


    public void Assign(View view) {
        switch (view.getId())
        {
            case R.id.ibdownload11:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference assign1=sref.child("CSC(CSE)").child("Assignments").child("comm system assignments.pdf");
                assign1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                          download(uri);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
                break;
            case R.id.ibpreview11:
                Intent send=new Intent(CommSys.this,PreviewActivity.class);
                send.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4UHJHLXVvankwd2c");
                startActivity(send);
                break;
            case R.id.ibdownload21:
                pd.show();
                break;
            case R.id.ibpreview21:
                pd.show();
                break;
            case R.id.ibdownload31:
                pd.show();
                break;
            case R.id.ibpreview31:
                pd.show();
                break;
            case R.id.ibdownload41:
                pd.show();
                break;
            case R.id.ibpreview41:
                pd.show();
                break;
        }
    }

    public void Notes(View view) {
        switch (view.getId())
        {
            case R.id.ibdownload1:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
//                StorageReference notes1=sref.child("CSC(CSE)").child("Notes").child("Unit 1 CSC.zip");
//                notes1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
                          download(Uri.parse("https://firebasestorage.googleapis.com/v0/b/notes-database.appspot.com/o/Sem%204%20IT%2FCSC(CSE)%2FNotes%2FUnit%201%20CSC.zip?alt=media&token=42090d5a-6f69-46d1-9b88-b5403de06b01"));
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                    }
//                });
                break;
            case R.id.ibpreview1:
                Intent send=new Intent(CommSys.this,PreviewActivity.class);
                send.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4bEZFY200dG5tQUk");
                startActivity(send);
                break;
            case R.id.ibdownload2:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
              //  StorageReference notes2=sref.child("CSC(CSE)").child("Notes").child("Unit 2 CSC.zip");
              //  notes2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                   // @Override
                   // public void onSuccess(Uri uri) {
                          download(Uri.parse("https://firebasestorage.googleapis.com/v0/b/notes-database.appspot.com/o/Sem%204%20IT%2FCSC(CSE)%2FNotes%2FUnit%202%20CSC.zip?alt=media&token=71517ecf-a93b-4b87-8a16-f876052ee981"));
                  //  }
               // }).addOnFailureListener(new OnFailureListener() {
                  //  @Override
                 //   public void onFailure(@NonNull Exception e) {

                   // }

                break;
            case R.id.ibpreview2:
                Intent send1=new Intent(CommSys.this,PreviewActivity.class);
                send1.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4TlQxOERnQ1BhdWc");
                startActivity(send1);
                break;
            case R.id.ibdownload3:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
               // StorageReference notes3=sref.child("CSC(CSE)").child("Notes").child("UNIT 3 CSC.zip");
               // notes3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                  //  @Override
                  //  public void onSuccess(Uri uri) {
                        download(Uri.parse("https://firebasestorage.googleapis.com/v0/b/notes-database.appspot.com/o/Sem%204%20IT%2FCSC(CSE)%2FNotes%2FUnit%203%20CSC.zip?alt=media&token=7d8a3a60-2d70-4782-a1d5-d781f097bab1"));
                   // }
              //  }).addOnFailureListener(new OnFailureListener() {
               //     @Override
                ////    public void onFailure(@NonNull Exception e) {

                  //  }

                break;
            case R.id.ibpreview3:
                pd.show();
                break;
            case R.id.ibdownload4:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
//                StorageReference notes4=sref.child("CSC(CSE)").child("Notes").child("UNIT 4 CSC.zip");
//                notes4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//                    @Override
//                    public void onSuccess(Uri uri) {
                        download(Uri.parse("https://firebasestorage.googleapis.com/v0/b/notes-database.appspot.com/o/Sem%204%20IT%2FCSC(CSE)%2FNotes%2FUnit%204%20CSC.zip?alt=media&token=4d779386-cee4-4ca2-b0a5-6a1afa76f82d"));
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//
//                    }
//                });
                break;
            case R.id.ibpreview4:
                pd.show();
                break;
            case R.id.ibpreview5:
                pd.show();
                break;
            case R.id.ibdownload5:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes5=sref.child("CSC(CSE)").child("Notes").child("Extra CSC.zip");
                notes5.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                          download(uri);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
                break;
            case R.id.ibclick :
                Intent start=new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/folderview?id=0Bzj6H64n6fe4NWsybjNvNWpJZlk"));
                startActivity(start);


                break;
        }
    }
    @Override
    protected void onStart() {

        FirebaseUser user=auth.getCurrentUser();
        auth.signInAnonymously();
        if(auth.getCurrentUser()==null){
            auth.signInAnonymously();
        }
        super.onStart();


    }
    public void download(Uri uri){
        Uri downloaduri=uri;
        String sd12= URLUtil.guessFileName(downloaduri.toString(),null, MimeTypeMap.getFileExtensionFromUrl(downloaduri.toString()));
        DownloadManager.Request rq12=new DownloadManager.Request(downloaduri);
        rq12.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,sd12);
        rq12.setNotificationVisibility(rq12.VISIBILITY_VISIBLE);
        dm.enqueue(rq12);
    }
}
