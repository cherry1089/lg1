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
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class host extends AppCompatActivity {
    TextInputLayout username,vtype,bmodel,locati,seat,pnumber,fairperhour,rno;
    String susername,svtype,sbmodel,slocati,sseat,spnumber,sfairperhour,srno;
    Button bu;
   /* ImageView imageView;
  int PHOTO_GET_CODE=1234;
   Uri photoUri;*/

   /* FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference HostedV=db.collection("HostedV");*/
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.host);
        username=findViewById(R.id.username);
        vtype=findViewById(R.id.vtype);
        bmodel=findViewById(R.id.bmodel);
        locati=findViewById(R.id.loccc);
        seat=findViewById(R.id.seate);
        fairperhour=findViewById(R.id.fpd);
        rno=findViewById(R.id.rnoo);
        pnumber=findViewById(R.id.pnumber);
       // imageView=findViewById(R.id.imageview2);


       // ho.findViewById(R.id.uploadimage);
        bu=findViewById(R.id.buu);
          bu.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  susername=username.getEditText().getText().toString();
                  svtype=vtype.getEditText().getText().toString();
                  sbmodel=bmodel.getEditText().getText().toString();
                  slocati=locati.getEditText().getText().toString();
                  sseat=seat.getEditText().getText().toString();
                  sfairperhour=fairperhour.getEditText().getText().toString();
                  spnumber=pnumber.getEditText().getText().toString();
                  srno=rno.getEditText().getText().toString();
                  HashMap<String,Object> map=new HashMap<>();
                  map.put("brandModel",sbmodel);
                  map.put("location",slocati);
                  map.put("fairPerHour",sfairperhour);
                  map.put("pnumber",spnumber);
                  map.put("rno",srno);
                  map.put("seater",sseat);
                  map.put("username",susername);
                  map.put("vtype",svtype);
                  FirebaseDatabase.getInstance().getReference().child("Hosts").child(susername).updateChildren(map);
                  startActivity(new Intent(host.this, home.class));

              }
          });


    }

   /* @Override
    protected void onActivityResult(int requestCode,int resultCode,@Nullable Intent data) {
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode==PHOTO_GET_CODE){
            if(resultCode== Activity.RESULT_OK){
                         photoUri = data.getData();
                        imageView.setImageURI(photoUri);
                }else {
                Toast.makeText(host.this,"Image Picker Action Canceled",Toast.LENGTH_SHORT).show();
            }
        }
    }*/

   /* public void callSaveHostingData(View view) {

        HashMap<String,Object> map=new HashMap<>();
        map.put("brandModel",sbmodel);
        map.put("location",slocati);
        map.put("fairPerHour",sfairperhour);
        map.put("pnumber",spnumber);
        map.put("rno",srno);
        map.put("seater",sseat);
        map.put("username",susername);
        map.put("vtype",svtype);

     //   FirebaseDatabase.getInstance().getReference().child("HostedV").child(load_type_v).updateChildren(map);

       *//* HostedV.add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {
                Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                Toast.makeText(host.this,"Hosting Successful",Toast.LENGTH_SHORT).show();
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });*//*
        Intent intent =new Intent(getApplicationContext(),hostinghistory.class);
        Pair[] pairs =new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.Signup_new_user),"hostingHistory");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(host.this,pairs);
        startActivity(intent,options.toBundle());



    }*/
}