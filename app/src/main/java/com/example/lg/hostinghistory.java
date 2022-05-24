package com.example.lg;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.FileObserver;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Button;

import com.example.lg.models.HostedV;
import com.example.lg.models.userss;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;

import org.w3c.dom.Document;

import java.util.ArrayList;
import java.util.Collections;

public class hostinghistory extends AppCompatActivity {


    FirebaseFirestore db = FirebaseFirestore.getInstance();


    RecyclerView recyclerView;
    ArrayList<HostedV> hostedVArrayList;
    MyHostAdapter myHostAdapter;
    ProgressDialog progressDialog;
    Button bi;
    FirebaseAuth mAuth;
    //  String currentUserId = mAuth.getCurrentUser().getUid();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid;
    String umail=user.getEmail();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.hostinghistory);
        progressDialog=new ProgressDialog(this);
        progressDialog.setCancelable(false);
        progressDialog.setMessage("Fetching data..");
        progressDialog.show();

        recyclerView=findViewById(R.id.recycleview2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        hostedVArrayList =new ArrayList<HostedV>();
        myHostAdapter =new MyHostAdapter(hostinghistory.this,hostedVArrayList);
        recyclerView.setAdapter(myHostAdapter);

        getData();



    }

    private void getData() {
        db.collection("HostedV").whereEqualTo("mail",umail)
                .addSnapshotListener(new EventListener<QuerySnapshot>() {
                    @Override
                    public void onEvent(@Nullable QuerySnapshot value,@Nullable FirebaseFirestoreException error) {
                        if(error!=null){
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                            Log.e("Firestore error",error.getMessage());
                            return;
                        }
                        for(com.google.firebase.firestore.DocumentChange dc :value.getDocumentChanges()){
                            if(dc.getType()== DocumentChange.Type.ADDED ){
                                hostedVArrayList.add(dc.getDocument().toObject(HostedV.class));


                            }
                            myHostAdapter.notifyDataSetChanged();
                            if(progressDialog.isShowing())
                                progressDialog.dismiss();
                        }
                    }
                });
    }

}




