package com.example.lg;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityOptionsCompat;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class host<user> extends AppCompatActivity {
    TextInputLayout username,vtype,bmodel,locati,seat,pnumber,fairperhour,rno;
    String susername;
    String svtype;
    String sbmodel;
    String slocati;
    String sseat;
    String spnumber;
    String sfairperhour;
    int fpdi,spnumberi,sseati;
   String srno;
    Button bu;
    DatePicker dp1,dp2;
   /* ImageView imageView;
  int PHOTO_GET_CODE=1234;
   Uri photoUri;*/

    FirebaseFirestore db = FirebaseFirestore.getInstance();
   CollectionReference Hosted=db.collection("HostedV");

    FirebaseAuth mAuth;
  //  String currentUserId = mAuth.getCurrentUser().getUid();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
   String uid;
   String umail=user.getEmail();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.host);
        username=findViewById(R.id.username1);
        vtype=findViewById(R.id.vtype1);
        bmodel=findViewById(R.id.bmodel1);
        locati=findViewById(R.id.loccc);
        seat=findViewById(R.id.seate);
        fairperhour=findViewById(R.id.fpd1);
        rno=findViewById(R.id.rno1);
        pnumber=findViewById(R.id.pnumber1);
        dp1=findViewById(R.id.dp1);
        dp2=findViewById(R.id.dp2);


       // imageView=findViewById(R.id.imageview2);






    }




/*
    public void callSaveHostingData(View view)

    {
     if(user!=null){
         uid = user.getUid();
     }
        susername=username.getEditText().getText().toString();
        svtype=vtype.getEditText().getText().toString();
        sbmodel=bmodel.getEditText().getText().toString();
        slocati=locati.getEditText().getText().toString();
        sseat=seat.getEditText().getText().toString();
        srno=rno.getEditText().getText().toString();
        sfairperhour=fairperhour.getEditText().getText().toString();
        spnumber=pnumber.getEditText().getText().toString();
        fpdi=Integer.parseInt(sfairperhour);
        spnumberi=Integer.parseInt(spnumber);
        sseati=Integer.parseInt(sseat);
        int day=dp1.getDayOfMonth();
        int month=dp1.getMonth();
        int year=dp1.getYear();
        String Sdate=day+"/"+month+"/"+year;
        int day1=dp2.getDayOfMonth();
        int month1=dp2.getMonth();
        int year1=dp2.getYear();
        String Edate=day1+"/"+month1+"/"+year1;
        HashMap<String,Object> map=new HashMap<>();
        map.put("brandModel",sbmodel);
        map.put("location",slocati);
        map.put("fairPerHour",fpdi);
        map.put("pnumber",spnumberi);
        map.put("rno",srno);
        map.put("seater",sseati);
        map.put("username",susername);
        map.put("vtype",svtype);
        map.put("Rented",false);
        map.put("mail",umail);
        map.put("Sdate",Sdate);
        map.put("Edate",Edate);
        db.collection("HostedV").document(uid)
                .set(map)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        //Do what you want
                        Log.d(TAG, "DocumentSnapshot added with ID: " + uid);
                        Toast.makeText(host.this,"Hosting Successful",Toast.LENGTH_SHORT).show();
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);

                    }
                });
        startActivity(new Intent(host.this, home.class));
    }
*/
    public void callSaveHostingData(View view){
        susername=username.getEditText().getText().toString();
        svtype=vtype.getEditText().getText().toString();
        sbmodel=bmodel.getEditText().getText().toString();
        slocati=locati.getEditText().getText().toString();
        sseat=seat.getEditText().getText().toString();
        srno=rno.getEditText().getText().toString();
        sfairperhour=fairperhour.getEditText().getText().toString();
        spnumber=pnumber.getEditText().getText().toString();
        fpdi=Integer.parseInt(sfairperhour);
        spnumberi=Integer.parseInt(spnumber);
        sseati=Integer.parseInt(sseat);
        int day=dp1.getDayOfMonth();
        int month=dp1.getMonth();
        int year=dp1.getYear();
        String Sdate=day+"/"+month+"/"+year;
        int day1=dp2.getDayOfMonth();
        int month1=dp2.getMonth();
        int year1=dp2.getYear();
        String Edate=day1+"/"+month1+"/"+year1;
        HashMap<String,Object> map=new HashMap<>();
        map.put("brandModel",sbmodel);
        map.put("location",slocati);
        map.put("fairPerHour",fpdi);
        map.put("pnumber",spnumberi);
        map.put("rno",srno);
        map.put("seater",sseati);
        map.put("username",susername);
        map.put("vtype",svtype);
        map.put("Rented",false);
        map.put("mail",umail);
        map.put("sdate",Sdate);
        map.put("edate",Edate);
        Hosted.add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }

        });
        startActivity(new Intent(host.this, home.class));
    }

}