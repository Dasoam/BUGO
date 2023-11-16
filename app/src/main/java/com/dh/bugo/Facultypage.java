package com.dh.bugo;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZoneId;

public class Facultypage extends AppCompatActivity {
    TextView username;
    FirebaseAuth firebaseAuth;
    FirebaseFirestore firebaseFirestore;
    String UserID;
    Spinner Fspin;
    Spinner Fspin2;
    String UserEmailId="";

    Button csp,home,faculty;
    String Fday;

    TextView Fclass1;
    TextView Fclass2;
    TextView Fclass3;
    TextView Fclass4;
    TextView Fclass5;
    TextView Fclass6;
    TextView Fclass7;
    TextView Fclass8;
    TextView Fclass9;
    TextView Fbreak;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_facultypage);
        username=findViewById(R.id.usnername);
        firebaseAuth=FirebaseAuth.getInstance();
        firebaseFirestore=FirebaseFirestore.getInstance();
        UserID=firebaseAuth.getCurrentUser().getUid();
        String UserIEmail=firebaseAuth.getCurrentUser().getEmail();
        Fspin = (Spinner) findViewById(R.id.spinner2);
        Fspin.setSelection(0);
        Fspin2 = (Spinner) findViewById(R.id.spinner3);
        Fspin2.setSelection(0);
        ZoneId zone = ZoneId.of( "Asia/Kolkata" );
        LocalDate today = LocalDate.now( zone );
        DayOfWeek dow = today.getDayOfWeek();
        String Day= dow.toString();
        //Fday = Day.substring(0, 1).toUpperCase() + Day.substring(1).toLowerCase();
        //Fday=Fspin2.getSelectedItem().toString();

        Fclass1=findViewById(R.id.Fclass1);
        Fclass2=findViewById(R.id.Fclass2);
        Fclass3=findViewById(R.id.Fclass3);
        Fclass4=findViewById(R.id.Fclass4);
        Fclass5=findViewById(R.id.Fclass5);
        Fclass6=findViewById(R.id.Fclass6);
        Fclass7=findViewById(R.id.Fclass7);
        Fclass8=findViewById(R.id.Fclass8);
        Fclass9=findViewById(R.id.Fclass9);
        Fbreak=findViewById(R.id.Fbreak);


//        for (int i=0;i<UserIEmail.length();i++){
//            if (UserIEmail.charAt(i)!=64){
//                UserEmailId+=UserIEmail.charAt(i);
//            }else break;
//        }
        firebaseFirestore.document("USERS/"+UserIEmail).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                String nm=documentSnapshot.getString("Name");
                String e[]=nm.split(" ");
                username.setText("Hi "+e[0]);
            }
        });


//        DocumentReference documentReference=firebaseFirestore.collection("USERS").document(UserID);
//        // <to get reterive the data from firestore
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {//ds=document sanpshot
//                //(ds.getString("Enrollment Number   sasa"));
//                username.setText("Hi "+UserEmailId);
//                //Toast.makeText(MainActivity.this, ""+usern, Toast.LENGTH_SHORT).show();
//                Log.d("showuser","ok"+UserID+"  "+UserIEmail+"  "+UserEmailId);
//            }
//        });//>
        FTT();
        dayslct();
    }
    public void logoutfn(View view){
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(getApplicationContext(),Loginpage.class));
        finish();
    }
    //SUPPORT PAGE
    public void csupport(View view){
        csp=findViewById(R.id.csupport);
//        csp.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),CSupport.class));   //customer support
            }
    //    });

    public void facultyfn(View view){
        faculty=findViewById(R.id.faculty2);
//        faculty.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                startActivity( new Intent(getApplicationContext(),Facultypage.class));
//            }
//        });
    }
    public void homefn(View view){
        home=findViewById(R.id.button);
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
//            }
//        });
    }
    public void FTT(){
        Fspin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String Fname=Fspin.getSelectedItem().toString();
                Fday=Fspin2.getSelectedItem().toString();
                if (!(Fname.equals("Select Faculty"))){
                    if(!(Fday.equals("Select Day"))){
                        /*Fbreak.setText("");
                        Fclass1.setText("Today is Holiday");
                        Fclass2.setText("");
                        Fclass3.setText("");
                        Fclass4.setText("");
                        Fclass5.setText("");
                        Fclass6.setText("");
                        Fclass7.setText("");
                        Fclass8.setText("");
                        Fclass9.setText("");*/

                        firebaseFirestore.document("F_TT/a/"+Fname+"/8:30-9:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass1.setText("Time:8:30-9:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass1.setText("Time:8:30-9:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/9:30-10:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass2.setText("Time:9:30-10:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass2.setText("Time:9:30-10:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/10:40-11:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass3.setText("Time:10:40-11:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass3.setText("Time:10:40-11:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/11:40-12:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass4.setText("Time:11:40-12:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass4.setText("Time:11:40-12:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/13:30-14:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass5.setText("Time:13:30-14:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass5.setText("Time:13:30-14:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/14:30-15:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass6.setText("Time:14:30-15:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass6.setText("Time:14:30-15:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/15:40-16:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass7.setText("Time:15:40-16:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass7.setText("Time:15:40-16:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/16:40-17:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass8.setText("Time:16:40-17:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass8.setText("Time:16:40-17:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/17:40-18:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass9.setText("Time:17:40-18:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass9.setText("Time:17:40-18:35\nNo Class");
                                }
                            }
                        });
                        Fbreak.setText("Time:12:40-1:30\nLunch Break");}
                    else{
                        Fbreak.setText("");
                        Fclass1.setText("");
                        Fclass2.setText("");
                        Fclass3.setText("");
                        Fclass4.setText("");
                        Fclass5.setText("");
                        Fclass6.setText("");
                        Fclass7.setText("");
                        Fclass8.setText("");
                        Fclass9.setText("");
                    }
                }
                else{
                    Fbreak.setText("");
                    Fclass1.setText("");
                    Fclass2.setText("");
                    Fclass3.setText("");
                    Fclass4.setText("");
                    Fclass5.setText("");
                    Fclass6.setText("");
                    Fclass7.setText("");
                    Fclass8.setText("");
                    Fclass9.setText("");
                }//till here
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
    public void dayslct(){
        Fspin2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String Fname=Fspin.getSelectedItem().toString();
                Fday=Fspin2.getSelectedItem().toString();
                if (!(Fname.equals("Select Faculty"))){
                    if(!(Fday.equals("Select Day"))){
                        /*Fbreak.setText("");
                        Fclass1.setText("Today is Holiday");
                        Fclass2.setText("");
                        Fclass3.setText("");
                        Fclass4.setText("");
                        Fclass5.setText("");
                        Fclass6.setText("");
                        Fclass7.setText("");
                        Fclass8.setText("");
                        Fclass9.setText("");*/

                        firebaseFirestore.document("F_TT/a/"+Fname+"/8:30-9:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass1.setText("Time:8:30-9:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass1.setText("Time:8:30-9:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/9:30-10:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass2.setText("Time:9:30-10:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass2.setText("Time:9:30-10:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/10:40-11:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass3.setText("Time:10:40-11:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass3.setText("Time:10:40-11:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/11:40-12:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass4.setText("Time:11:40-12:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass4.setText("Time:11:40-12:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/13:30-14:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass5.setText("Time:13:30-14:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass5.setText("Time:13:30-14:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/14:30-15:25").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass6.setText("Time:14:30-15:25\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass6.setText("Time:14:30-15:25\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/15:40-16:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass7.setText("Time:15:40-16:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass7.setText("Time:15:40-16:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/16:40-17:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass8.setText("Time:16:40-17:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass8.setText("Time:16:40-17:35\nNo Class");
                                }
                            }
                        });
                        firebaseFirestore.document("F_TT/a/"+Fname+"/17:40-18:35").get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
                            @Override
                            public void onSuccess(DocumentSnapshot documentSnapshot) {
                                String chk=documentSnapshot.getString(Fday);
                                if(!(chk.equals(""))){
                                    Fclass9.setText("Time:17:40-18:35\n"+"Class at\n"+chk);
                                }
                                else{
                                    Fclass9.setText("Time:17:40-18:35\nNo Class");
                                }
                            }
                        });
                        Fbreak.setText("Time:12:40-1:30\nLunch Break");}
                    else{
                        Fbreak.setText("");
                        Fclass1.setText("");
                        Fclass2.setText("");
                        Fclass3.setText("");
                        Fclass4.setText("");
                        Fclass5.setText("");
                        Fclass6.setText("");
                        Fclass7.setText("");
                        Fclass8.setText("");
                        Fclass9.setText("");
                    }
                }
                else{
                    Fbreak.setText("");
                    Fclass1.setText("");
                    Fclass2.setText("");
                    Fclass3.setText("");
                    Fclass4.setText("");
                    Fclass5.setText("");
                    Fclass6.setText("");
                    Fclass7.setText("");
                    Fclass8.setText("");
                    Fclass9.setText("");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}