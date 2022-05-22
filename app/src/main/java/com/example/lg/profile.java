package com.example.lg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;

public class profile extends AppCompatActivity {
    FirebaseAuth mAuth =FirebaseAuth.getInstance();
    Button btn,ri;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.profile);
         btn=findViewById(R.id.logout_button);
    }
    public void call_Logout(View view) {
        mAuth.signOut();
        Intent intent =new Intent(getApplicationContext(),Login.class);
        Pair[] pairs =new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.logout_button),"logout");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(profile.this,pairs);
        startActivity(intent,options.toBundle());
    }
    public void callHostHistory(View view) {
        Intent intent =new Intent(getApplicationContext(),hostinghistory.class);
        Pair[] pairs =new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.hostid),"tohostinghistory");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(profile.this,pairs);
        startActivity(intent,options.toBundle());
    }
    public void callRentHistory(View view) {
        Intent intent =new Intent(getApplicationContext(),rentinghistory.class);
        Pair[] pairs =new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.rentid),"torentinghistory");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(profile.this,pairs);
        startActivity(intent,options.toBundle());

    }
}