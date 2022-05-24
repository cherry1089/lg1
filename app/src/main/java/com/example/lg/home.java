package com.example.lg;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ActivityOptions;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.example.lg.models.HostedV;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.common.collect.ImmutableList;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.SetOptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class home extends AppCompatActivity  {
    FirebaseFirestore db = FirebaseFirestore.getInstance();


    RecyclerView recyclerView;
    ArrayList<HostedV> hostedVArrayList;
    MyAdapter myAdapter;
    ProgressDialog progressDialog;
  Button bi;
    FirebaseAuth mAuth;
    //  String currentUserId = mAuth.getCurrentUser().getUid();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid1;
    String umail=user.getEmail();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.home);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data..");
        progressDialog.show();

        recyclerView=findViewById(R.id.recycleview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
         hostedVArrayList =new ArrayList<HostedV>();
         myAdapter =new MyAdapter(home.this,hostedVArrayList);
          recyclerView.setAdapter(myAdapter);
          myAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener() {




              @Override
              public void onDeleteClick(int position) {

                  removeItem(position);
              }
          });

       getData();

    }
    public void removeItem(int position){
        if(user!=null){
            uid1 = user.getUid();
        }
        hostedVArrayList.remove(position);
        myAdapter.notifyItemRemoved(position);
        // Update one field, creating the document if it does not already exist.

        //db.collection("HostedV").whereEqualTo("rns",rno)



    }


    private void getData() {
        db.collection("HostedV").whereEqualTo("Rented",false)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot value,@Nullable FirebaseFirestoreException error) {
                if(error!=null){
                    if(progressDialog.isShowing())
                        progressDialog.dismiss();
                    Log.e("Firestore error",error.getMessage());
                    return;
                }
                  for(DocumentChange dc :value.getDocumentChanges()){
                      if(dc.getType()==DocumentChange.Type.ADDED ){
                          hostedVArrayList.add(dc.getDocument().toObject(HostedV.class));


                      }
                      myAdapter.notifyDataSetChanged();
                      if(progressDialog.isShowing())
                          progressDialog.dismiss();
                  }
            }
        });

    }


    public void callProfile(View view) {
        Intent intent =new Intent(getApplicationContext(),profile.class);
        Pair[] pairs =new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.pb),"toProfile");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home.this,pairs);
        startActivity(intent,options.toBundle());
    }

    public void callHost(View view) {
        Intent intent =new Intent(getApplicationContext(),host.class);
        Pair[] pairs =new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.hb),"toHosting");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(home.this,pairs);
        startActivity(intent,options.toBundle());
    }





}