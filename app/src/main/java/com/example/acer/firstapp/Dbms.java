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

public class Dbms extends AppCompatActivity {
    public DownloadManager dm;
    public Dialog pd;
    TextView notavail;
    public StorageReference sref;
    FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbms);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,new NotesFragment()).commit();
        sref= FirebaseStorage.getInstance().getReference().child("Sem 4 IT");
        pd=new Dialog(this);
        pd.setContentView(R.layout.notavailable);
        notavail=(TextView)pd.findViewById(R.id.notvailable);
        notavail.setText("NOT AVAILABLE \n Pls Check 'What's New' section'");
        notavail.setTextColor(Color.RED);
        dm=(DownloadManager)getSystemService(DOWNLOAD_SERVICE);
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
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference sref1=sref.child("DBMS").child("Previous Years").child("DBMS_Sessionals_1[1].pdf");
                sref1.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview12 :
              pd.show();
                break;
            case R.id.ibdownload22:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference sref2=sref.child("DBMS").child("Previous Years").child("DBMS_Sessionals_2_PaperMate[1].pdf");
                sref2.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview22:
              pd.show();
                break;
            case R.id.ibdownload32:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference sref3=sref.child("DBMS").child("Previous Years").child("DBMS_End_Term_PaperMate[1].pdf");
                sref3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
                StorageReference assign1=sref.child("DBMS").child("Assignments").child("DBMS 1(A).pdf");
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
                Intent send1=new Intent(Dbms.this,PreviewActivity.class);
                send1.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4Y3YtVWZQMDFKa1U");
                startActivity(send1);
                break;
            case R.id.ibdownload21:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference assign2=sref.child("DBMS").child("Assignments").child("DBMS 2(A).pdf");
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
                Intent send2=new Intent(Dbms.this,PreviewActivity.class);
                send2.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4LXI1dTNxOFNJNEU");
                startActivity(send2);
                break;
            case R.id.ibdownload31:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference assign3=sref.child("DBMS").child("Assignments").child("all assignments DBMS.pdf");
                assign3.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
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
            case R.id.ibpreview31:
                Intent send3=new Intent(Dbms.this,PreviewActivity.class);
                send3.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4MVc3b0M2QVQ2V1U");
                startActivity(send3);
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
                StorageReference notes1=sref.child("DBMS").child("Notes").child("Unit 1 DBMS.zip");
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
                Intent send1=new Intent(Dbms.this,PreviewActivity.class);
                send1.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4a3MzNm9SeUw1UmM");
                startActivity(send1);
                break;
            case R.id.ibdownload2:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes2=sref.child("DBMS").child("Notes").child("Unit 2 DBMS.zip");
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
                Intent send2=new Intent(Dbms.this,PreviewActivity.class);
                send2.putExtra("values","https://drive.google.com/open?id=1z2RfEe1R5mFBy8sdYq2DOEO2JaLwLtXfSV9cVKdcFGg");
                startActivity(send2);
                break;
            case R.id.ibdownload3:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes3=sref.child("DBMS").child("Notes").child("Unit 3 DBMS.zip");
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
                Intent send3=new Intent(Dbms.this,PreviewActivity.class);
                send3.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4MW9qQ0tPc0NmUzA");
                startActivity(send3);
                break;
            case R.id.ibdownload4:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes4=sref.child("DBMS").child("Notes").child("NoticeUnit4notes.docx");
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
                Intent send4=new Intent(Dbms.this,PreviewActivity.class);
                send4.putExtra("values","https://drive.google.com/open?id=1W5DKSsywHVPCIuhJqYdwu79VFw0UuAReca8OsmU8umc");
                startActivity(send4);
                break;
            case R.id.ibpreview5:
                Intent send5=new Intent(Dbms.this,PreviewActivity.class);
                send5.putExtra("values","https://drive.google.com/open?id=0Bzj6H64n6fe4c2Q0TlNzLWtadGs");
                startActivity(send5);
                break;
            case R.id.ibdownload5:
                Toast.makeText(getApplicationContext(),"Fetching Download Url\n Please Wait",Toast.LENGTH_LONG).show();
                StorageReference notes5=sref.child("DBMS").child("Notes").child("Extra DBMS.zip");
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
                Intent start=new Intent(Intent.ACTION_VIEW,Uri.parse("https://drive.google.com/folderview?id=0Bzj6H64n6fe4ZTVoSXE3c1F0Tm8"));
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
