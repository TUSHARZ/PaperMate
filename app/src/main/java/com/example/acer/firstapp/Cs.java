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

public class Cs extends AppCompatActivity {
    public DownloadManager dm;
    public StorageReference sref;
    public Dialog pd;
    TextView notavail;
    FirebaseAuth auth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cs);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new NotesFragment()).commit();
        dm=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
        sref= FirebaseStorage.getInstance().getReference().child("Sem 4 IT");
        pd=new Dialog(this);
        auth=FirebaseAuth.getInstance();



        pd.setContentView(R.layout.notavailable);
        notavail=(TextView)pd.findViewById(R.id.notvailable);
        notavail.setText("NOT AVAILABLE \n Pls Check 'What's New' section'");
        notavail.setTextColor(Color.RED);

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
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();

                StorageReference assign1=sref.child("CS(IT)").child("Previous Years").child("CS_sessionals_1[1].pdf");
                assign1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        download(uri);
                        Log.d("uri",uri.toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

                break;
            case R.id.ibpreview12 :
                pd.show();
                break;
            case R.id.ibdownload22:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();

                StorageReference assign2=sref.child("CS(IT)").child("Previous Years").child("CS_sessionals_2[1].pdf");
                assign2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        download(uri);
                        Log.d("uri",uri.toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
                break;
            case R.id.ibpreview22:
                pd.show();
                break;
            case R.id.ibdownload32:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();

                StorageReference assign3=sref.child("CS(IT)").child("Previous Years").child("CS_End_term[1].pdf");
                assign3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                        download(uri);
                        Log.d("uri",uri.toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
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

                StorageReference assign1=sref.child("CS(IT)").child("Assignments").child("CS Assignment 1(K).pdf");
                assign1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                         download(uri);
                        Log.d("uri",uri.toString());
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
                break;
            case R.id.ibpreview11:
                Intent send1=new Intent(Cs.this,PreviewActivity.class);
                send1.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4MVNRY0Eya0xFZVE");
                startActivity(send1);
                break;
            case R.id.ibdownload21:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();

                StorageReference assign2=sref.child("CS(IT)").child("Assignments").child("CS assign 2(A).pdf");
                assign2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview21:
                Intent send2=new Intent(Cs.this,PreviewActivity.class);
                send2.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4WW5VMF96MXZIWDg");
                startActivity(send2);
                break;
            case R.id.ibdownload31:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();

                StorageReference assign3=sref.child("CS(IT)").child("Assignments").child("CS Assignment 3.pdf");

                assign3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                         download(uri);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(),"no",Toast.LENGTH_LONG).show();
                    }
                });
                break;
            case R.id.ibpreview31:
                Intent send3=new Intent(Cs.this,PreviewActivity.class);
                send3.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4YlR3Q1ZDNG9LWmc");
                startActivity(send3);
                break;
            case R.id.ibdownload41:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();

                StorageReference assign4=sref.child("CS(IT)").child("Assignments").child("all assignments CS.pdf");
                assign4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview41:
                Intent send4=new Intent(Cs.this,PreviewActivity.class);
                send4.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4WnVEYk9Vak4zNkU");
                startActivity(send4);
                break;
        }
    }

    public void Notes(View view) {
        switch (view.getId())
        {
            case R.id.ibdownload1:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes1=sref.child("CS(IT)").child("Notes").child("Unit 1 CS.zip");
                notes1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview1:
                Intent send1=new Intent(Cs.this,PreviewActivity.class);
                send1.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4WnVEYk9Vak4zNkU");
                startActivity(send1);
                break;
            case R.id.ibdownload2:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes2=sref.child("CS(IT)").child("Notes").child("Unit 2 CS.zip");
                notes2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview2:
                Intent send2=new Intent(Cs.this,PreviewActivity.class);
                send2.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4bXA1Tno4akxCUFE");
                startActivity(send2);
                break;
            case R.id.ibdownload3:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes3=sref.child("CS(IT)").child("Notes").child("Unit 3 CS.zip");
                notes3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview3:
                Intent send3=new Intent(Cs.this,PreviewActivity.class);
                send3.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4REZqTDN0OVRQYlE");
                startActivity(send3);
                break;
            case R.id.ibdownload4:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes4=sref.child("CS(IT)").child("Notes").child("Unit 4 CS.zip");
                notes4.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview4:
                Intent send4=new Intent(Cs.this,PreviewActivity.class);
                send4.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4Rk9HSEJxOVdoaG8");
                startActivity(send4);
                break;
            case R.id.ibpreview5:

                Intent send5=new Intent(Cs.this,PreviewActivity.class);
                send5.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4SEU2MjNkc1JPeTA");
                startActivity(send5);
                break;
            case R.id.ibdownload5:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes5=sref.child("CS(IT)").child("Notes").child("Extra CS(IT).zip");
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
                Intent start=new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/folderview?id=0Bzj6H64n6fe4N01Kb3k0VUNCZXc"));
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
        rq12.setNotificationVisibility(rq12.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
        dm.enqueue(rq12);
    }


}
