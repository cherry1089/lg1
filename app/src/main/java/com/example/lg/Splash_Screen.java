package com.example.lg;



import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Splash_Screen extends AppCompatActivity {

    FirebaseAuth mAuth=FirebaseAuth.getInstance();
    private static int Splash_screen=4000;
    ImageView logo;
    TextView title,caption;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //for no status and action bars
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.splash_screen);
        mAuth = FirebaseAuth.getInstance();

        logo=findViewById(R.id.car_image);
        title=findViewById(R.id.app_Name);
        caption=findViewById(R.id.app_Caption);

        //animations
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator i_animation = ObjectAnimator.ofFloat(logo, "translationY", 200f);
        i_animation.setDuration(2000);
        i_animation.start();
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator n_animation = ObjectAnimator.ofFloat(title, "translationY", -200f);
        n_animation.setDuration(2000);
        n_animation.start();
        @SuppressLint("ObjectAnimatorBinding") ObjectAnimator c_animation = ObjectAnimator.ofFloat(caption, "translationY", -200f);
        c_animation.setDuration(2000);
        c_animation.start();

        if(mAuth.getCurrentUser()!=null){
            Intent intent = new Intent(Splash_Screen.this,home.class);
            startActivity(intent);
            finish();
                  }
        //delay 4 sec and move to next activation bar
       else{
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent=new Intent(Splash_Screen.this, Login.class);
                    startActivity(intent);
                    finish();
                }
            },Splash_screen);
        }

    }

}