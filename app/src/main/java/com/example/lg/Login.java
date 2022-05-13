package com.example.lg;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    TextInputLayout mail,password;
    Button login;
    FirebaseAuth mAuth=FirebaseAuth.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login);
        mail=findViewById(R.id.login_mail);
        password=findViewById(R.id.login_password);
        login=findViewById(R.id.login_button);
    }
    public void callHome(View view){
        if(!validateEmail()|!validatePassword()){
            return;
        }else {
            String emaill= mail.getEditText().getText().toString();
            String passwordl=password.getEditText().getText().toString();
            mAuth.signInWithEmailAndPassword(emaill,passwordl).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        Toast.makeText(Login.this,"Login Successful",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),home.class);
                        Pair[] pairs = new Pair[1];
                        pairs[0] = new Pair<View, String>(findViewById(R.id.login_button), "transition_loginToHome");
                        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this, pairs);
                        startActivity(intent, options.toBundle());

                    }else
                    {
                        Toast.makeText(Login.this,"login Unsuccessful:"+task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
    public void callSignUp(View view){
        Intent intent =new Intent(getApplicationContext(),SignUp.class);
        Pair[] pairs =new Pair[1];
        pairs[0]=new Pair<View,String>(findViewById(R.id.Signup_new_user),"transition_signup");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
        startActivity(intent,options.toBundle());
    }
    private boolean validateEmail(){
        String val= mail.getEditText().getText().toString().trim();
        String checkEmail="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
        if(val.isEmpty()){
            mail.setError("Field cannot be empty");
            return false;
        }else if(!val.matches(checkEmail)){
            mail.setError("Invalid Email");
            return false;
        }
        else
        {
            mail.setError(null);
            mail.setErrorEnabled(false);
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
}