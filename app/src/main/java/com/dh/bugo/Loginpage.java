package com.dh.bugo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Loginpage extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    EditText emaillogin,pwlogin;
    TextView registorlink, passwordreset;
    Button lbutton,cb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginpage);
        firebaseAuth = FirebaseAuth.getInstance();
        emaillogin = findViewById(R.id.loginmail);
        pwlogin = findViewById(R.id.passwordlogin);
        lbutton = findViewById(R.id.loginbutton);
        registorlink = findViewById(R.id.logintext4);
        passwordreset = findViewById(R.id.fpw);
        Log.i("Login", "Done");
        if (firebaseAuth.getCurrentUser() != null) {
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        }
        String errorarray[] = {"", " ", "  ", "   ", "    "};
        lbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = emaillogin.getText().toString().trim();
                String Password = pwlogin.getText().toString().trim();
                if (Email.length() == 0 | Email.length() == 1 | errorarray.equals(Email)) {
                    emaillogin.setError("Enter a valid Gmail");
                    return;
                }
                if (Password.length() < 8 | Password.length() > 17) {
                    pwlogin.setError("Enter a valid password of length (8-16)");
                    return;
                }
                firebaseAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            if (firebaseAuth.getCurrentUser().isEmailVerified()) {
                                Toast.makeText(Loginpage.this, "Login Successfully", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                                finish();
                            }
                            else{
                                Toast.makeText(Loginpage.this, "Please Verify your EMAIL", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(Loginpage.this, " " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });
        registorlink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Registerpage.class));
                finish();
            }
        });
        cb=findViewById(R.id.cus);
        cb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CSupport.class));   //customer support
                finish();
            }
        });
    }
          public void forgotpassword(View view){
            passwordreset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //startActivity(new Intent(getApplicationContext(),CSupport.class));   //customer support
                EditText resetEmail= new EditText(view.getContext());
                AlertDialog.Builder resetdialog= new AlertDialog.Builder(view.getContext());
                //AlertDialog.Builder resetdialog= new AlertDialog.Builder(Loginpage.this);
                resetdialog.setTitle("RESET PASSWORD-");
                resetdialog.setMessage("Enter Gmail to reset the password.");
                resetdialog.setView(resetEmail);

                //Dialogs
                //if user click yes
                resetdialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //to get the email input and send password reset link.
                        String BUMAIL=resetEmail.getText().toString();
                        int Bennett=BUMAIL.indexOf("bennett");
                        //if (Bennett!=-1){
                        firebaseAuth.sendPasswordResetEmail(BUMAIL).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void unused) {
                                Toast.makeText(Loginpage.this, "Reset Link has benn sent to your Mail Id", Toast.LENGTH_SHORT).show();
                            }
                        })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Toast.makeText(Loginpage.this, "Enter Valid Email!  "+e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                });
                    //}
//                   else{
//                            Toast.makeText(Loginpage.this, "Enter Bennett Email Only!!", Toast.LENGTH_SHORT).show();
//                    }
                    }
                });
                //if user click no
                resetdialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // to redirect the user to the login page.
                    }
                });
            resetdialog.create().show();}

        });
    }
//    void Contactus(View view){
//        cb=findViewById(R.id.cus);
//        cb.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(getApplicationContext(),CSupport.class));   //customer support
//            }
//        });
//    }
}