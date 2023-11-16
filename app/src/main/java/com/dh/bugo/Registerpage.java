package com.dh.bugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;


public class Registerpage extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    EditText name ,enrollnumber,batch, email,pw,Year;
    Button rbutton;
    TextView loginb;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registerpage);
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        name = findViewById(R.id.fname);
        enrollnumber = findViewById(R.id.enrollnumber);
        batch = findViewById(R.id.batch);
        email = findViewById(R.id.bumail);
        pw = findViewById(R.id.password);
        rbutton = findViewById(R.id.resgisterbutton);
        loginb = findViewById(R.id.logintext);
        Year=findViewById(R.id.year);
        Log.i("Rgister", "Done");
        // getting user data
        String Name = name.getText().toString().trim();
        String EnrollmentNumber = enrollnumber.getText().toString().trim();
        String Batch = batch.getText().toString().trim();
        //if (Name.isEmpty() != true & EnrollmentNumber.isEmpty() != true & Batch.isEmpty() != true) {
            if (firebaseAuth.getCurrentUser() != null) {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
            String errorarray[] = {"", " ", "  ", "   ", "    "};
            rbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String Email = email.getText().toString().trim();
                    String Password = pw.getText().toString().trim();
                    // to store the data <
                    String Name=name.getText().toString();
                    String EnrollMentno=enrollnumber.getText().toString();
                    String BATCHstring =batch.getText().toString();
                    Integer BATCHinteger=Integer.parseInt(BATCHstring);
                    String BATCH1=""+BATCHinteger;
                    String BATCH;
                    if (BATCH1.length()==2 & BATCHinteger>=1 & BATCHinteger<53){
                        BATCH= "B-"+BATCH1;}
                    else if (BATCH1.length()==1 & BATCHinteger>=1 & BATCHinteger<53){
                        BATCH="B-0"+BATCH1;
                    }
                    else{
                        batch.setError("Enter Batch");
                        return;
                    }
                    String YEAR =Year.getText().toString();
                    int YEAR1=Integer.parseInt(YEAR);
                    //getting user batch

                    // getting data to text>
                    if (Email.length() == 0 | Email.length() == 1 | errorarray.equals(Email)) {
                        email.setError("Enter a valid Gmail");
                        return;
                    }
                    if (Password.length() < 8 | Password.length() > 17) {
                        pw.setError("Enter a valid password of length (8-16)");
                        return;
                    }
                    //conditions
                    if (YEAR1 !=1){
                        Year.setError("Enter your current course year like 1,2,etc");
                        return;
                    }
//                    if (BATCH1.length()==1 | BATCH1.length()==2){
//                        batch.setError("Enter Batch");
//                        return;
//                    }
                    //
                    firebaseAuth.createUserWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // user verification
                                firebaseAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(Registerpage.this, "Email Verification Link has been sent to your Email", Toast.LENGTH_SHORT).show();
                                            Toast.makeText(Registerpage.this, "Please verify to login again", Toast.LENGTH_SHORT).show();
                                        }
                                        else{
                                            Toast.makeText(Registerpage.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });//
                                Toast.makeText(Registerpage.this, "Successfully Registered", Toast.LENGTH_SHORT).show();
                                //
                                Log.d("BATCH",BATCH);
                                // < to store user data to firestore.
                                //userid=firebaseAuth.getCurrentUser().getUid(); //for random user id.
                                userid = Email;
                                DocumentReference documentReference= firebaseFirestore.collection("USERS").document(userid);
                                Map<String,Object> user = new HashMap<>();
                                user.put("Name",Name);
                                user.put("Enrollment Number",EnrollMentno);
                                user.put("Batch",BATCH);
                                user.put("Email",Email);
                                user.put("Year",YEAR);
                                user.put("pw",Password);// saving user password.
                                documentReference.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                    @Override
                                    public void onSuccess(Void unused) {
                                        Log.d("Userdata of %s is created",userid);
                                    }
                                });
                                // storing of data is completed>
                                //if (firebaseAuth.getCurrentUser().isEmailVerified()){
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            //}
                            } else {
                                Toast.makeText(Registerpage.this, "Some Error Occur " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            });
            loginb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(getApplicationContext(), Loginpage.class));
                    finish();
                }
            });
        //}
//        else{
//            //startActivity(new Intent(getApplicationContext(), Registerpage.class));
//            Toast.makeText(this, "All Fields are required ", Toast.LENGTH_SHORT).show();
//            //finish();
//        }
    }
    }
