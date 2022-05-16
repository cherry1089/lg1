package com.example.lg;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.time.Year;
import java.util.Calendar;

public class SignUP1 extends AppCompatActivity {
     Button next;
     TextView su;
   TextInputLayout phone;
    RadioGroup radioGroup;
    RadioButton gen;
    DatePicker datePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.signup1);


        next=findViewById(R.id.next);
        su=findViewById(R.id.signup_name);

        radioGroup=findViewById(R.id.rgroup);
        datePicker=findViewById(R.id.dp);
        phone=findViewById(R.id.phone);




    }
    public void callNextSignUp(View view){
        String _names=getIntent().getStringExtra("names");
        String _adhaaar=getIntent().getStringExtra("adhar");
        String _paan=getIntent().getStringExtra("paaan");
        String _loca=getIntent().getStringExtra("locat");
        String phoneNo=phone.getEditText().getText().toString();

       if( !validateGender() | !validateAge())
        {
            return;
        }

       gen=findViewById(radioGroup.getCheckedRadioButtonId());
       String _gender=gen.getText().toString();
       int day=datePicker.getDayOfMonth();
       int month=datePicker.getMonth();
       int year=datePicker.getYear();
       String _date=day+"/"+month+"/"+year;

        Intent intent=new Intent(getApplicationContext(),SignUP3.class);

        intent.putExtra("names",_names);
        intent.putExtra("adhar",_adhaaar);
        intent.putExtra("paaan",_paan);
        intent.putExtra("locat",_loca);
        intent.putExtra("gend",_gender);
        intent.putExtra("bday",_date);
        intent.putExtra("phoneNo",phoneNo);
        Pair[] pairs= new Pair[2];

        pairs[0]=new Pair<View,String>(next,"Transition_Next_Signup");
        pairs[1]=new Pair<View,String>(su,"transition_signup_name");

        ActivityOptions options=ActivityOptions.makeSceneTransitionAnimation(SignUP1.this,pairs);
        startActivity(intent,options.toBundle());


    }




   private boolean validateGender() {
       if (radioGroup.getCheckedRadioButtonId() == -1) {
           Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();

           return false;
       } else {
           return true;
       }

   }
   private boolean validateAge()
   {
       int currentYear= Calendar.getInstance().get(Calendar.YEAR);
       int userAge=datePicker.getYear();
       int isAgeValid= currentYear-userAge;
       if(isAgeValid<14){
           Toast.makeText(this, "Your not eligible to apply", Toast.LENGTH_SHORT).show();
           return false;
       }
       else
       {
           return true;
       }
   }





}
