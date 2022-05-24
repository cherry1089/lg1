package com.example.lg;

import static android.widget.Toast.LENGTH_SHORT;
import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;

public class SignUP3 extends AppCompatActivity {
    TextInputLayout Mail,password,cpassword;
    Button sub;
    FirebaseAuth mAuth=FirebaseAuth.getInstance();
    //String id=mAuth.getCurrentUser().getUid();
    String fullname,adhaar,paan,loca,gender,date,mail,passwordd,phoneNo;
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    CollectionReference UserS=db.collection("UserS");
   // DocumentReference documentReference =db.collection("UserS").document(id);
    FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
    String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup3);
        Mail=findViewById(R.id.mail);
        password=findViewById(R.id.pwd);
        cpassword=findViewById(R.id.pwd1);
        sub=findViewById(R.id.signupNAME);
      /*  fullname=getIntent().getStringExtra("names");
        adhaar=getIntent().getStringExtra("adhar");
        paan=getIntent().getStringExtra("paaan");
        loca=getIntent().getStringExtra("locat");
        gender=getIntent().getStringExtra("gend");
        date=getIntent().getStringExtra("bday");
        phoneNo=getIntent().getStringExtra("phoneNo");*/

    }
    public void call_login(View view){

        mail=Mail.getEditText().getText().toString();
        passwordd=password.getEditText().getText().toString();

        if(!validateEmail() | !validatePassword() |!validateCPassword()){
            return;
        }else{
            mAuth.createUserWithEmailAndPassword(mail,passwordd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){

                        Toast.makeText(SignUP3.this,"Sign Up Successful",LENGTH_SHORT).show();

                        Intent intent =new Intent(getApplicationContext(),Login.class);

                        Pair[] pairs =new Pair[1];
                        pairs[0]=new Pair<View,String>(findViewById(R.id.signupNAME),"transition_login");
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUP3.this, pairs);
                        startActivity(intent,options.toBundle());
                        storeUserData();
                    }else
                    {
                        Toast.makeText(SignUP3.this,"Sign Up Unsuccessful:"+task.getException().getMessage(),LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void storeUserData() {
        fullname=getIntent().getStringExtra("names");
        adhaar=getIntent().getStringExtra("adhar");
        paan=getIntent().getStringExtra("paaan");
        loca=getIntent().getStringExtra("locat");
        gender=getIntent().getStringExtra("gend");
        date=getIntent().getStringExtra("bday");
        phoneNo=getIntent().getStringExtra("phoneNo");
        HashMap<String,Object> map=new HashMap<>();
        map.put("Username",fullname);
        map.put("PhoneNumber",phoneNo);
        map.put("adhar",adhaar);
        map.put("dob",date);
        map.put("gender",gender);
        map.put("location",loca);
        map.put("mail",mail);
        map.put("pan",paan);
        UserS.add(map).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
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


    }
//   public void storeUserData(){
//       String umaill=user.getEmail();
//        fullname=getIntent().getStringExtra("names");
//        adhaar=getIntent().getStringExtra("adhar");
//        paan=getIntent().getStringExtra("paaan");
//        loca=getIntent().getStringExtra("locat");
//        gender=getIntent().getStringExtra("gend");
//        date=getIntent().getStringExtra("bday");
//        phoneNo=getIntent().getStringExtra("phoneNo");
//        mail=Mail.getEditText().getText().toString();
//        passwordd=password.getEditText().getText().toString();
//        HashMap<String,Object> map=new HashMap<>();
//        map.put("Username",fullname);
//        map.put("PhoneNumber",phoneNo);
//        map.put("adhar",adhaar);
//        map.put("dob",date);
//        map.put("gender",gender);
//        map.put("location",loca);
//        map.put("mail",mail);
//        map.put("pan",paan);
//        db.collection("UserS").document(umaill)
//                .set(map)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        //Do what you want
//                        Log.d(TAG, "DocumentSnapshot added with ID: " + uid);
//                        Toast.makeText(SignUP3.this,"Hosting Successful",Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.w(TAG, "Error adding document", e);
//
//                    }
//                });
//
//    }
    private boolean validateEmail(){
        String val=Mail.getEditText().getText().toString().trim();
        String checkEmail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            Mail.setError("Field cannot be empty");
            return false;
        }else if(!val.matches(checkEmail)){
            Mail.setError("Invalid Email");
            return false;
        }
        else
        {
            Mail.setError(null);
            Mail.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatePassword(){
        String val=password.getEditText().getText().toString().trim();
        String checkPassword="^"+"(?=.*[0-9])"+"(?=.*[a-zA-Z])"+"(?=.*[@#$%^&+=])"+"(?=\\S+$)"+".{4,}"+"$";
        if(val.isEmpty()){
            password.setError("Field cannot be empty");
            return false;
        }else if(!val.matches(checkPassword)){
            password.setError("Give a Strong password");
            return false;
        }
        else
        {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateCPassword(){
        String mval=password.getEditText().getText().toString().trim();
        String val=cpassword.getEditText().getText().toString().trim();
        if(val.isEmpty()){
            cpassword.setError("Field cannot be empty");
            return false;
        }else if(!val.equals(mval)){
            cpassword.setError("Both password fields must be identical");
            return false;
        }
        else
        {
            cpassword.setError(null);
            cpassword.setErrorEnabled(false);
            return true;
        }
    }
}