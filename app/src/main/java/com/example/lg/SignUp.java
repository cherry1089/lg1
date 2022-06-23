package com.example.lg;
import androidx.appcompat.app.AppCompatActivity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;
public class SignUp extends AppCompatActivity {
    Button next;
    TextView su;
    TextInputLayout fullName, adhaar, panNumber, location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.signup);
        next = findViewById(R.id.next);
        su = findViewById(R.id.signup_name);
        fullName = findViewById(R.id.signup_full_name);
        adhaar = findViewById(R.id.signup_adhaar);
        panNumber = findViewById(R.id.pan);
        location = findViewById(R.id.loc);
    }
    public void callNextSignUp(View view) {
        if (!validateFullName() | !validateAdhaar() | !validatePan() | !validateLocation()) {
            return;
        }
        String names = fullName.getEditText().getText().toString();
        String adhaaar = adhaar.getEditText().getText().toString();
        String paan = panNumber.getEditText().getText().toString();
        String loca = location.getEditText().getText().toString();
        Intent intent = new Intent(getApplicationContext(),SignUP1.class);
        intent.putExtra("names",names);
        intent.putExtra("adhar",adhaaar);
        intent.putExtra("paaan",paan);
        intent.putExtra("locat",loca);
        Pair[] pairs = new Pair[2];
        pairs[0] = new Pair<View, String>(next,"Transition_Next_Signup");
        pairs[1] = new Pair<View, String>(su,"transition_signup_name");
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this,pairs);
        startActivity(intent,options.toBundle());
    }
    private boolean validateFullName() {
        String val = fullName.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field cannot be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateAdhaar() {
        String val = adhaar.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            adhaar.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 12) {
            adhaar.setError("Adhaar Number,limit exceeded");
            return false;
        } else {
            adhaar.setError(null);
            adhaar.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validatePan() {
        String val = panNumber.getEditText().getText().toString().trim();
        String checkspaces = "\\A\\w{1,10}";
        if (val.isEmpty()) {
            panNumber.setError("Field cannot be empty");
            return false;
        } else if (val.length() > 10) {
            panNumber.setError("PAN Number,limit exceeded");
            return false;
        } else if (!val.matches(checkspaces)) {
            panNumber.setError("No whitespaces are allowed");
            return false;

        } else {
            panNumber.setError(null);
            panNumber.setErrorEnabled(false);
            return true;
        }
    }
    private boolean validateLocation() {
        String val = location.getEditText().getText().toString().trim();
        if (val.isEmpty()) {
            location.setError("Field cannot be empty");
            return false;
        } else {
            location.setError(null);
            location.setErrorEnabled(false);
            return true;
        }
    }
}
