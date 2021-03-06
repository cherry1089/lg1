package com.example.lg;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import java.util.HashMap;
public class loading extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    CollectionReference cr=db.collection("RentedV");
    String umail=user.getEmail();
    String rusername,rpnumber,rrno,rseater,rsdate,redate,rfaiPerHour,rlocation,rmail,rvtpe,rbrandModel;
    int fdp1,pnumber1,seaterrr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.loading);
        rvtpe=getIntent().getStringExtra("vtype1");
        rbrandModel=getIntent().getStringExtra("brandModel1");
        rlocation=getIntent().getStringExtra("location1");
        rrno=getIntent().getStringExtra("rno1");
        rmail=getIntent().getStringExtra("mail1");
        rfaiPerHour=getIntent().getStringExtra("fairPerHour1");
        rseater=getIntent().getStringExtra("seater1");
        rusername=getIntent().getStringExtra("username1");
        rpnumber=getIntent().getStringExtra("pnumber1");
        rsdate=getIntent().getStringExtra("sdate1");
        redate=getIntent().getStringExtra("edate1");
        fdp1=Integer.parseInt(rfaiPerHour);
        pnumber1=Integer.parseInt(rpnumber);
        seaterrr=Integer.parseInt(rseater);
        HashMap<String,Object> map=new HashMap<>();
        map.put("username",rusername);
        map.put("pnumber",pnumber1);
        map.put("vtype",rvtpe);
        map.put("brandModel",rbrandModel);
        map.put("seater",seaterrr);
        map.put("location",rlocation);
        map.put("umail",rmail);
        map.put("mail",umail);
        map.put("sdate",rsdate);
        map.put("edate",redate);
        map.put("rno",rrno);
        map.put("fairPerHour",fdp1);
        cr.add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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
        db.collection("HostedV").whereEqualTo("rno",rrno).get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful() && !task.getResult().isEmpty()){
                    DocumentSnapshot documentSnapshot=task.getResult().getDocuments().get(0);
                    String documentid=documentSnapshot.getId();
                    db.collection("HostedV").document(documentid).update("Rented",true).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(loading.this,"Successfully Rented",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(loading.this,"Renting Unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    });
                    db.collection("HostedV").document(documentid).update("renter",umail).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            Toast.makeText(loading.this,"Successfully Rented",Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            Toast.makeText(loading.this,"Renting Unsuccessful",Toast.LENGTH_SHORT).show();
                        }
                    });
                }else {
                    Toast.makeText(loading.this,"Failed",Toast.LENGTH_SHORT).show();
                }
            }
        })      ;
         startActivity(new Intent(loading.this, rentinghistory.class));
    }
}