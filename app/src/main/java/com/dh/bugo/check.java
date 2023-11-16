//package com.dh.bugo;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.EventListener;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreException;
//
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.ZoneId;
//
//public class check extends AppCompatActivity {
//    TextView usern;
//    FirebaseAuth firebaseAuth;
//    FirebaseFirestore firebaseFirestore;
//    String UserID;
//    String UserEmailId="";
//    String cbatch;
//    String cyear;
//    TextView class1;
//    TextView class2;
//    TextView class3;
//    TextView class4;
//    TextView class5;
//    TextView class6;
//    TextView class7;
//    TextView class8;
//    TextView class9;
//    TextView lbreak;
//    String day;
//    Spinner spin;
//    String UserIEmail;
//
//    Button csp,home,faculty;
//    // Calender
////    Calendar calendar;
////    String Date,Day;
////    SimpleDateFormat simpleDateFormat;//>
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // here bcz it should be with the activity
//        spin = (Spinner) findViewById(R.id.spinner);
//        spin.setSelection(0);
//        usern=findViewById(R.id.usnername);
//        firebaseAuth=FirebaseAuth.getInstance();
//        firebaseFirestore=FirebaseFirestore.getInstance();
//        UserID=firebaseAuth.getCurrentUser().getUid();
//        UserIEmail=firebaseAuth.getCurrentUser().getEmail();
//
//
//        for (int i=0;i<UserIEmail.length();i++){
//            if (UserIEmail.charAt(i)!=64){
//                UserEmailId+=UserIEmail.charAt(i);
//            }else break;
//        }
//
//
//        DocumentReference documentReference=firebaseFirestore.collection("USERS").document(UserID);
//        // <to get reterive the data from firestore
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {//ds=document sanpshot
//                //(ds.getString("Enrollment Number   sasa"));
//                usern.setText("Hi "+UserEmailId);
//                //Toast.makeText(MainActivity.this, ""+usern, Toast.LENGTH_SHORT).show();
//                Log.d("showuser","ok"+UserID+"  "+UserIEmail+"  "+UserEmailId);
//            }
//        });//>
//        // Time Table retrive.
//        class1=findViewById(R.id.class1);
//        class2=findViewById(R.id.class2);
//        class3=findViewById(R.id.class3);
//        class4=findViewById(R.id.class4);
//        class5=findViewById(R.id.class5);
//        class6=findViewById(R.id.class6);
//        class7=findViewById(R.id.class7);
//        class8=findViewById(R.id.class8);
//        class9=findViewById(R.id.class9);
//        lbreak=findViewById(R.id.lbreak);
//        lbreak.setText("Time:12:40-1:30\nLunch Break");
//        //DocumentReference dcrb=firebaseFirestore.document("USERS/"+UserIEmail);
////        calendar=Calendar.getInstance();
////        simpleDateFormat=new SimpleDateFormat("dd-mm-yyyy HH:mm");
////        Date=simpleDateFormat.format(calendar.getTime());
////        System.out.println(Date);
////        DayOfWeek Day= simpleDateFormat.getDayOfWeek();
//
//        //To know Day
//        ZoneId zone = ZoneId.of( "Asia/Kolkata" );
//        LocalDate today = LocalDate.now( zone );
//        DayOfWeek dow = today.getDayOfWeek();
//        String Day= dow.toString();
////        String d1 = Day.substring(0, 1).toUpperCase();
////        String d2 = Day.substring(1);
//        day = Day.substring(0, 1).toUpperCase() + Day.substring(1).toLowerCase();
//        //String day="Friday";
//        //System.out.println(day);
//
//        //System.out.println(dow);//
//        DocumentReference dcrb=firebaseFirestore.document("USERS/"+UserIEmail);
//        dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                cbatch =documentSnapshot.getString("Batch");
//                cyear =documentSnapshot.getString("Year");
//                int weekend=0;
//                //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                String weekends[]={"Saturday","Sunday"};
//                for (int i=0;i<2;i++){
//                    if (day.equals(weekends[i])){
//                        weekend+=1;
//                    }
//                }
//                if (weekend==0){
//                    DocumentReference dcr1=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/8:30-9:25");
//                    dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class1.setText("Time:8:30-9:25\nNo Class");
//                            }
//                            else {
//                                class1.setText("Time:8:30-9:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr2=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/9:30-10:25");
//                    dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class2.setText("Time:9:30-10:25\nNo Class");
//                            }
//                            else {
//                                class2.setText("Time:9:30-10:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr3=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/10:40-11:35");
//                    dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class3.setText("Time:10:40-11:35\nNo Class");
//                            }
//                            else {
//                                class3.setText("Time:10:40-11:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr4=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/11:40-12:35");
//                    dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class4.setText("Time:11:40-12:35\nNo Class");
//                            }
//                            else {
//                                class4.setText("Time:11:40-12:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr5=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/13:30-14:25");
//                    dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class5.setText("Time:13:30-14:25\nNo Class");
//                            }
//                            else {
//                                class5.setText("Time:13:30-14:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr6=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/14:30-15:25");
//                    dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class6.setText("Time:14:30-15:25\nNo Class");
//                            }
//                            else {
//                                class6.setText("Time:14:30-15:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr7=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/15:40-16:35");
//                    dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class7.setText("Time:15:40-16:35\nNo Class");
//                            }
//                            else {
//                                class7.setText("Time:15:40-16:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr8=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/16:40-17:35");
//                    dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class8.setText("Time:16:40-17:35\nNo Class");
//                            }
//                            else {
//                                class8.setText("Time:16:40-17:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr9=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/17:40-18:35");
//                    dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class9.setText("Time:17:40-18:35\nNo Class");
//                            }
//                            else {
//                                class9.setText("Time:17:40-18:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                }//if end here
//                else{
//                    lbreak.setText("");
//                    class1.setText("Today is "+day+"\n So Enjoy");
//                }
//            }
//        });// Time Table Retrieved.
//
//        //Spinner start
//        daych();
//
//    }
//    public void logoutfn(View view){
//        FirebaseAuth.getInstance().signOut();
//        startActivity(new Intent(getApplicationContext(),Loginpage.class));
//        finish();
//    }
//    //SUPPORT PAGE
//    public void csupport(View view){
//        csp=findViewById(R.id.csupport);
//        // csp.setOnClickListener(new View.OnClickListener() {
//        //  @Override
//        //  public void onClick(View view) {
//        startActivity(new Intent(getApplicationContext(),CSupport.class));   //customer support
//        //  }
//        // });
//    }
//    public void facultyfn(View view){
//        faculty=findViewById(R.id.faculty2);
////        faculty.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//        startActivity( new Intent(getApplicationContext(),Facultypage.class));
//        finish();
////            }
////        });
//    }
//    public void homefn(View view){
//        home=findViewById(R.id.button);
////        home.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//        startActivity(new Intent(getApplicationContext(),MainActivity.class));
////            }
////        });
//    }
//    public void daych() {
//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//        {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//            {
//                String chitm=spin.getSelectedItem().toString();
//                //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
//                if(chitm.equals("Today")) {
//
//
//                    DocumentReference dcrb = firebaseFirestore.document("USERS/" + UserIEmail);
//                    dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            cbatch = documentSnapshot.getString("Batch");
//                            cyear = documentSnapshot.getString("Year");
//                            int weekend = 0;
//                            //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                            String weekends[] = {"Saturday", "Sunday"};
//                            for (int i = 0; i < 2; i++) {
//                                if (day.equals(weekends[i])) {
//                                    weekend += 1;
//                                }
//                            }
//                            if (weekend == 0) {
//                                DocumentReference dcr1 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/8:30-9:25");
//                                dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class1.setText("Time:8:30-9:25\nNo Class");
//                                        } else {
//                                            class1.setText("Time:8:30-9:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr2 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/9:30-10:25");
//                                dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class2.setText("Time:9:30-10:25\nNo Class");
//                                        } else {
//                                            class2.setText("Time:9:30-10:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr3 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/10:40-11:35");
//                                dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class3.setText("Time:10:40-11:35\nNo Class");
//                                        } else {
//                                            class3.setText("Time:10:40-11:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr4 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/11:40-12:35");
//                                dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class4.setText("Time:11:40-12:35\nNo Class");
//                                        } else {
//                                            class4.setText("Time:11:40-12:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr5 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/13:30-14:25");
//                                dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class5.setText("Time:13:30-14:25\nNo Class");
//                                        } else {
//                                            class5.setText("Time:13:30-14:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr6 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/14:30-15:25");
//                                dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class6.setText("Time:14:30-15:25\nNo Class");
//                                        } else {
//                                            class6.setText("Time:14:30-15:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr7 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/15:40-16:35");
//                                dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class7.setText("Time:15:40-16:35\nNo Class");
//                                        } else {
//                                            class7.setText("Time:15:40-16:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr8 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/16:40-17:35");
//                                dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class8.setText("Time:16:40-17:35\nNo Class");
//                                        } else {
//                                            class8.setText("Time:16:40-17:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr9 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/17:40-18:35");
//                                dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class9.setText("Time:17:40-18:35\nNo Class");
//                                        } else {
//                                            class9.setText("Time:17:40-18:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                            }//if end here
//                            else {
//                                lbreak.setText("");
//                                class1.setText("Today is " + day + "\n So Enjoy");
//                            }
//                        }
//                    });
//                }
//                else if(chitm.equals("Saturday")| chitm.equals("Sunday")){
//                    lbreak.setText("");
//                    class1.setText("Today is holiday"+"\n So Enjoy");
//                    class2.setText("");
//                    class3.setText("");
//                    class4.setText("");
//                    class5.setText("");
//                    class6.setText("");
//                    class7.setText("");
//                    class8.setText("");
//                    class9.setText("");
//                }
//                else{
//                    DocumentReference dcrb = firebaseFirestore.document("USERS/" + UserIEmail);
//                    dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            cbatch = documentSnapshot.getString("Batch");
//                            cyear = documentSnapshot.getString("Year");
//                            int weekend = 0;
//                            //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                            String weekends[] = {"Saturday", "Sunday"};
//                            for (int i = 0; i < 2; i++) {
//                                if (chitm.equals(weekends[i])) {
//                                    weekend += 1;
//                                }
//                            }
//                            if (weekend == 0) {
//                                DocumentReference dcr1 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/8:30-9:25");
//                                dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class1.setText("Time:8:30-9:25\nNo Class");
//                                        } else {
//                                            class1.setText("Time:8:30-9:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr2 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/9:30-10:25");
//                                dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class2.setText("Time:9:30-10:25\nNo Class");
//                                        } else {
//                                            class2.setText("Time:9:30-10:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr3 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/10:40-11:35");
//                                dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class3.setText("Time:10:40-11:35\nNo Class");
//                                        } else {
//                                            class3.setText("Time:10:40-11:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr4 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/11:40-12:35");
//                                dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class4.setText("Time:11:40-12:35\nNo Class");
//                                        } else {
//                                            class4.setText("Time:11:40-12:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr5 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/13:30-14:25");
//                                dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class5.setText("Time:13:30-14:25\nNo Class");
//                                        } else {
//                                            class5.setText("Time:13:30-14:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr6 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/14:30-15:25");
//                                dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class6.setText("Time:14:30-15:25\nNo Class");
//                                        } else {
//                                            class6.setText("Time:14:30-15:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr7 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/15:40-16:35");
//                                dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class7.setText("Time:15:40-16:35\nNo Class");
//                                        } else {
//                                            class7.setText("Time:15:40-16:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr8 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/16:40-17:35");
//                                dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class8.setText("Time:16:40-17:35\nNo Class");
//                                        } else {
//                                            class8.setText("Time:16:40-17:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr9 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/17:40-18:35");
//                                dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class9.setText("Time:17:40-18:35\nNo Class");
//                                        } else {
//                                            class9.setText("Time:17:40-18:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                            }//if end here
//                            else {
//                                lbreak.setText("");
//                                class1.setText("Today is " + chitm + "\n So Enjoy");
//                            }
//                        }
//                    });
//                }
//            } // to close the onItemSelected
//            public void onNothingSelected(AdapterView<?> parent)
//            {
//
//            }
//        });
//
//    }
//
//
//}
//AGAIN AGAIN AGAIN AGAIN AGAIN AGAIN
//package com.dh.bugo;
//
//        import androidx.annotation.Nullable;
//        import androidx.appcompat.app.AppCompatActivity;
//
//        import android.content.Intent;
//        import android.os.Bundle;
//        import android.util.Log;
//        import android.view.View;
//        import android.widget.AdapterView;
//        import android.widget.Button;
//        import android.widget.Spinner;
//        import android.widget.TextView;
//
//        import com.google.android.gms.tasks.OnSuccessListener;
//        import com.google.firebase.auth.FirebaseAuth;
//        import com.google.firebase.firestore.DocumentReference;
//        import com.google.firebase.firestore.DocumentSnapshot;
//        import com.google.firebase.firestore.EventListener;
//        import com.google.firebase.firestore.FirebaseFirestore;
//        import com.google.firebase.firestore.FirebaseFirestoreException;
//        import com.google.android.gms.common.api.Batch;
//
//        import java.text.SimpleDateFormat;
//        import java.time.DayOfWeek;
//        import java.time.LocalDate;
//        import java.time.ZoneId;
//        import java.util.Calendar;
//        import java.util.GregorianCalendar;
//
//public class MainActivity extends AppCompatActivity {
//    TextView usern;
//    FirebaseAuth firebaseAuth;
//    FirebaseFirestore firebaseFirestore;
//    String UserID;
//    String UserEmailId="";
//
//    Button csp,home,faculty;
//    String cbatch;
//    String cyear;
//    TextView class1;
//    TextView class2;
//    TextView class3;
//    TextView class4;
//    TextView class5;
//    TextView class6;
//    TextView class7;
//    TextView class8;
//    TextView class9;
//    TextView lbreak;
//    String day;
//    Spinner spin;
//    String UserIEmail;
//    // Calender
////    Calendar calendar;
////    String Date,Day;
////    SimpleDateFormat simpleDateFormat;//>
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // here bcz it should be with the activity
//        usern=findViewById(R.id.usnername);
//        firebaseAuth=FirebaseAuth.getInstance();
//        firebaseFirestore=FirebaseFirestore.getInstance();
//        UserID=firebaseAuth.getCurrentUser().getUid();
//        String UserIEmail=firebaseAuth.getCurrentUser().getEmail();
//        spin = (Spinner) findViewById(R.id.spinner);
//        spin.setSelection(0);
//
//
//
//        for (int i=0;i<UserIEmail.length();i++){
//            if (UserIEmail.charAt(i)!=64){
//                UserEmailId+=UserIEmail.charAt(i);
//            }else break;
//        }
//
//
//        DocumentReference documentReference=firebaseFirestore.collection("USERS").document(UserID);
//        // <to get reterive the data from firestore
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {//ds=document sanpshot
//                //(ds.getString("Enrollment Number   sasa"));
//                usern.setText("Hi "+UserEmailId);
//                //Toast.makeText(MainActivity.this, ""+usern, Toast.LENGTH_SHORT).show();
//                Log.d("showuser","ok"+UserID+"  "+UserIEmail+"  "+UserEmailId);
//            }
//        });//>
//        // Time Table retrive.
//        class1=findViewById(R.id.class1);
//        class2=findViewById(R.id.class2);
//        class3=findViewById(R.id.class3);
//        class4=findViewById(R.id.class4);
//        class5=findViewById(R.id.class5);
//        class6=findViewById(R.id.class6);
//        class7=findViewById(R.id.class7);
//        class8=findViewById(R.id.class8);
//        class9=findViewById(R.id.class9);
//        lbreak=findViewById(R.id.lbreak);
//        lbreak.setText("Time:12:40-1:30\nLunch Break");
//        DocumentReference dcrb=firebaseFirestore.document("USERS/"+UserIEmail);
////        calendar=Calendar.getInstance();
////        simpleDateFormat=new SimpleDateFormat("dd-mm-yyyy HH:mm");
////        Date=simpleDateFormat.format(calendar.getTime());
////        System.out.println(Date);
////        DayOfWeek Day= simpleDateFormat.getDayOfWeek();
//
//        //To know Day
//        ZoneId zone = ZoneId.of( "Asia/Kolkata" );
//        LocalDate today = LocalDate.now( zone );
//        DayOfWeek dow = today.getDayOfWeek();
//        String Day= dow.toString();
////        String d1 = Day.substring(0, 1).toUpperCase();
////        String d2 = Day.substring(1);
//        day = Day.substring(0, 1).toUpperCase() + Day.substring(1).toLowerCase();
//        //String day="Friday";
//        //System.out.println(day);
//
//        //System.out.println(dow);//
//
//        dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                String cbatch =documentSnapshot.getString("Batch");
//                String cyear =documentSnapshot.getString("Year");
//                int weekend=0;
//                //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                String weekends[]={"Saturday","Sunday"};
//                for (int i=0;i<2;i++){
//                    if (day.equals(weekends[i])){
//                        weekend+=1;
//                    }
//                }
//                if (weekend==0){
//                    DocumentReference dcr1=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/8:30-9:25");
//                    dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class1.setText("Time:8:30-9:25\nNo Class");
//                            }
//                            else {
//                                class1.setText("Time:8:30-9:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr2=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/9:30-10:25");
//                    dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class2.setText("Time:9:30-10:25\nNo Class");
//                            }
//                            else {
//                                class2.setText("Time:9:30-10:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr3=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/10:40-11:35");
//                    dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class3.setText("Time:10:40-11:35\nNo Class");
//                            }
//                            else {
//                                class3.setText("Time:10:40-11:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr4=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/11:40-12:35");
//                    dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class4.setText("Time:11:40-12:35\nNo Class");
//                            }
//                            else {
//                                class4.setText("Time:11:40-12:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr5=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/13:30-14:25");
//                    dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class5.setText("Time:13:30-14:25\nNo Class");
//                            }
//                            else {
//                                class5.setText("Time:13:30-14:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr6=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/14:30-15:25");
//                    dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class6.setText("Time:14:30-15:25\nNo Class");
//                            }
//                            else {
//                                class6.setText("Time:14:30-15:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr7=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/15:40-16:35");
//                    dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class7.setText("Time:15:40-16:35\nNo Class");
//                            }
//                            else {
//                                class7.setText("Time:15:40-16:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr8=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/16:40-17:35");
//                    dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class8.setText("Time:16:40-17:35\nNo Class");
//                            }
//                            else {
//                                class8.setText("Time:16:40-17:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr9=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/17:40-18:35");
//                    dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class9.setText("Time:17:40-18:35\nNo Class");
//                            }
//                            else {
//                                class9.setText("Time:17:40-18:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                }//if end here
//                else{
//                    lbreak.setText("");
//                    class1.setText("Today is "+day+"\n So Enjoy");
//                }
//            }
//        });// Time Table Retrieved.
//        daych();
//
//    }
//    public void logoutfn(View view){
//        FirebaseAuth.getInstance().signOut();
//        startActivity(new Intent(getApplicationContext(),Loginpage.class));
//        finish();
//    }
//    //SUPPORT PAGE
//    public void csupport(View view){
//        csp=findViewById(R.id.csupport);
//        // csp.setOnClickListener(new View.OnClickListener() {
//        //  @Override
//        //  public void onClick(View view) {
//        startActivity(new Intent(getApplicationContext(),CSupport.class));   //customer support
//        //  }
//        // });
//    }
//    public void facultyfn(View view){
//        faculty=findViewById(R.id.faculty2);
////        faculty.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//        startActivity( new Intent(getApplicationContext(),Facultypage.class));
//        finish();
////            }
////        });
//    }
//    public void homefn(View view){
//        home=findViewById(R.id.button);
////        home.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//        startActivity(new Intent(getApplicationContext(),MainActivity.class));
////            }
////        });
//    }
//    public void daych() {
//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//        {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//            {
//                String chitm=spin.getSelectedItem().toString();
//                //Toast.makeText(getApplicationContext(),"Hello Javatpoint",Toast.LENGTH_SHORT).show();
//                if(chitm.equals("Today")) {
//
//
//                    DocumentReference dcrb = firebaseFirestore.document("USERS/" + UserIEmail);
//                    dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            cbatch = documentSnapshot.getString("Batch");
//                            cyear = documentSnapshot.getString("Year");
//                            int weekend = 0;
//                            //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                            String weekends[] = {"Saturday", "Sunday"};
//                            for (int i = 0; i < 2; i++) {
//                                if (day.equals(weekends[i])) {
//                                    weekend += 1;
//                                }
//                            }
//                            if (weekend == 0) {
//                                DocumentReference dcr1 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/8:30-9:25");
//                                dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class1.setText("Time:8:30-9:25\nNo Class");
//                                        } else {
//                                            class1.setText("Time:8:30-9:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr2 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/9:30-10:25");
//                                dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class2.setText("Time:9:30-10:25\nNo Class");
//                                        } else {
//                                            class2.setText("Time:9:30-10:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                }); DocumentReference dcr3 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/10:40-11:35");
//                                dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class3.setText("Time:10:40-11:35\nNo Class");
//                                        } else {
//                                            class3.setText("Time:10:40-11:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr4 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/11:40-12:35");
//                                dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class4.setText("Time:11:40-12:35\nNo Class");
//                                        } else {
//                                            class4.setText("Time:11:40-12:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr5 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/13:30-14:25");
//                                dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class5.setText("Time:13:30-14:25\nNo Class");
//                                        } else {
//                                            class5.setText("Time:13:30-14:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                }); DocumentReference dcr6 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/14:30-15:25");
//                                dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class6.setText("Time:14:30-15:25\nNo Class");
//                                        } else {
//                                            class6.setText("Time:14:30-15:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr7 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/15:40-16:35");
//                                dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class7.setText("Time:15:40-16:35\nNo Class");
//                                        } else {
//                                            class7.setText("Time:15:40-16:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr8 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/16:40-17:35");
//                                dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class8.setText("Time:16:40-17:35\nNo Class");
//                                        } else {
//                                            class8.setText("Time:16:40-17:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr9 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/17:40-18:35");
//                                dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class9.setText("Time:17:40-18:35\nNo Class");
//                                        } else {
//                                            class9.setText("Time:17:40-18:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                            }//if end here
//                            else {
//                                lbreak.setText("");
//                                class1.setText("Today is " + day + "\n So Enjoy");
//                            }
//                        }
//                    });
//                }
//                else if(chitm.equals("Saturday")| chitm.equals("Sunday")){
//                    lbreak.setText("");
//                    class1.setText("Today is holiday"+"\n So Enjoy");
//                    class2.setText("");
//                    class3.setText("");
//                    class4.setText("");
//                    class5.setText("");
//                    class6.setText("");
//                    class7.setText("");
//                    class8.setText("");
//                    class9.setText("");
//                }
//                else{
//                    DocumentReference dcrb = firebaseFirestore.document("USERS/" + UserIEmail);
//                    dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            cbatch = documentSnapshot.getString("Batch");
//                            cyear = documentSnapshot.getString("Year");
//                            int weekend = 0;
//                            //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                            String weekends[] = {"Saturday", "Sunday"};
//                            for (int i = 0; i < 2; i++) {
//                                if (chitm.equals(weekends[i])) {
//                                    weekend += 1;
//                                }
//                            }
//                            if (weekend == 0) {
//                                DocumentReference dcr1 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/8:30-9:25");
//                                dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class1.setText("Time:8:30-9:25\nNo Class");
//                                        } else {
//                                            class1.setText("Time:8:30-9:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr2 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/9:30-10:25");
//                                dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class2.setText("Time:9:30-10:25\nNo Class");
//                                        } else {
//                                            class2.setText("Time:9:30-10:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr3 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/10:40-11:35");
//                                dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class3.setText("Time:10:40-11:35\nNo Class");
//                                        } else {
//                                            class3.setText("Time:10:40-11:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr4 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/11:40-12:35");
//                                dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class4.setText("Time:11:40-12:35\nNo Class");
//                                        } else {
//                                            class4.setText("Time:11:40-12:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr5 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/13:30-14:25");
//                                dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class5.setText("Time:13:30-14:25\nNo Class");
//                                        } else {
//                                            class5.setText("Time:13:30-14:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr6 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/14:30-15:25");
//                                dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class6.setText("Time:14:30-15:25\nNo Class");
//                                        } else {
//                                            class6.setText("Time:14:30-15:25\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr7 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/15:40-16:35");
//                                dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class7.setText("Time:15:40-16:35\nNo Class");
//                                        } else {
//                                            class7.setText("Time:15:40-16:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr8 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/16:40-17:35");
//                                dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class8.setText("Time:16:40-17:35\nNo Class");
//                                        } else {
//                                            class8.setText("Time:16:40-17:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr9 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/17:40-18:35");
//                                dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(chitm);
//                                        if (check.equals("")) {
//                                            class9.setText("Time:17:40-18:35\nNo Class");
//                                        } else {
//                                            class9.setText("Time:17:40-18:35\n" + documentSnapshot.getString(chitm));
//                                        }
//                                    }
//                                });
//                            }//if end here
//                            else {
//                                lbreak.setText("");
//                                class1.setText("Today is " + chitm + "\n So Enjoy");
//                            }
//                        }
//                    });
//                }
//            } // to close the onItemSelected
//            public void onNothingSelected(AdapterView<?> parent)
//            {
//
//            }
//        });
//    }
//}



//
//package com.dh.bugo;
//
//import androidx.annotation.Nullable;
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.AdapterView;
//import android.widget.Button;
//import android.widget.Spinner;
//import android.widget.TextView;
//import android.widget.Toast;
//
//import com.google.android.gms.tasks.OnSuccessListener;
//import com.google.firebase.auth.FirebaseAuth;
//import com.google.firebase.auth.FirebaseUser;
//import com.google.firebase.firestore.DocumentReference;
//import com.google.firebase.firestore.DocumentSnapshot;
//import com.google.firebase.firestore.EventListener;
//import com.google.firebase.firestore.FirebaseFirestore;
//import com.google.firebase.firestore.FirebaseFirestoreException;
//import com.google.android.gms.common.api.Batch;
//
//import java.sql.Time;
//import java.text.SimpleDateFormat;
//import java.time.DayOfWeek;
//import java.time.LocalDate;
//import java.time.ZoneId;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
//import java.util.Timer;
//import java.util.TimerTask;
//
//public class MainActivity extends AppCompatActivity {
//    TextView usern;
//    FirebaseAuth firebaseAuth;
//    FirebaseFirestore firebaseFirestore;
//    String UserID;
//    String UserEmailId="";
//
//    Button csp,home,faculty;
//    String cbatch;
//    String cyear;
//    TextView class1;
//    TextView class2;
//    TextView class3;
//    TextView class4;
//    TextView class5;
//    TextView class6;
//    TextView class7;
//    TextView class8;
//    TextView class9;
//    TextView lbreak;
//    String day;
//    Spinner spin;
//    String UserIEmail;
//    // Calender
////    Calendar calendar;
////    String Date,Day;
////    SimpleDateFormat simpleDateFormat;//>
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        // here bcz it should be with the activity
//        usern=findViewById(R.id.usnername);
//        firebaseAuth=FirebaseAuth.getInstance();
//        firebaseFirestore=FirebaseFirestore.getInstance();
//        UserID=firebaseAuth.getCurrentUser().getUid();
//        spin = (Spinner) findViewById(R.id.spinner);
//        spin.setSelection(0);
//        UserIEmail=firebaseAuth.getCurrentUser().getEmail();
//
//        for (int i=0;i<UserIEmail.length();i++){
//            if (UserIEmail.charAt(i)!=64){
//                UserEmailId+=UserIEmail.charAt(i);
//            }else break;
//        }
//
//        firebaseFirestore.document("USERS/"+UserIEmail).get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                String nm=documentSnapshot.getString("Name");
//                String e[]=nm.split(" ");
//                usern.setText("Hi "+e[0]);
//            }
//        });
//
//        /*DocumentReference documentReference=firebaseFirestore.collection("USERS").document(UserID);
//        // <to get reterive the data from firestore
//        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
//            @Override
//            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException error) {//ds=document sanpshot
//                //(ds.getString("Enrollment Number   sasa"));
//                usern.setText("Hi "+UserEmailId);
//                //Toast.makeText(MainActivity.this, ""+usern, Toast.LENGTH_SHORT).show();
//                Log.d("showuser","ok"+UserID+"  "+UserIEmail+"  "+UserEmailId);
//            }
//        });//>*/
//        // Time Table retrive.
//        class1=findViewById(R.id.class1);
//        class2=findViewById(R.id.class2);
//        class3=findViewById(R.id.class3);
//        class4=findViewById(R.id.class4);
//        class5=findViewById(R.id.class5);
//        class6=findViewById(R.id.class6);
//        class7=findViewById(R.id.class7);
//        class8=findViewById(R.id.class8);
//        class9=findViewById(R.id.class9);
//        lbreak=findViewById(R.id.lbreak);
//        lbreak.setText("Time:12:40-1:30\nLunch Break");
//        //DocumentReference dcrb=firebaseFirestore.document("USERS/"+UserIEmail);
////        calendar=Calendar.getInstance();
////        simpleDateFormat=new SimpleDateFormat("dd-mm-yyyy HH:mm");
////        Date=simpleDateFormat.format(calendar.getTime());
////        System.out.println(Date);
////        DayOfWeek Day= simpleDateFormat.getDayOfWeek();
//
//        //To know Day
//        ZoneId zone = ZoneId.of( "Asia/Kolkata" );
//        LocalDate today = LocalDate.now( zone );
//        DayOfWeek dow = today.getDayOfWeek();
//        String Day= dow.toString();
////        String d1 = Day.substring(0, 1).toUpperCase();
////        String d2 = Day.substring(1);
//        day = Day.substring(0, 1).toUpperCase() + Day.substring(1).toLowerCase();
//        //String day="Friday";
//        //System.out.println(day);
//
//        //System.out.println(dow);//
//        DocumentReference dcrb=firebaseFirestore.document("USERS/"+UserIEmail);
//        dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//            @Override
//            public void onSuccess(DocumentSnapshot documentSnapshot) {
//                cbatch =documentSnapshot.getString("Batch");
//                cyear =documentSnapshot.getString("Year");
//                int weekend=0;
//                //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                String weekends[]={"Saturday","Sunday"};
//                for (int i=0;i<2;i++){
//                    if (day.equals(weekends[i])){
//                        weekend+=1;
//                    }
//                }
//                if (weekend==0){
//                    DocumentReference dcr1=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/8:30-9:25");
//                    dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class1.setText("Time:8:30-9:25\nNo Class");
//                            }
//                            else {
//                                class1.setText("Time:8:30-9:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr2=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/9:30-10:25");
//                    dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class2.setText("Time:9:30-10:25\nNo Class");
//                            }
//                            else {
//                                class2.setText("Time:9:30-10:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr3=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/10:40-11:35");
//                    dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class3.setText("Time:10:40-11:35\nNo Class");
//                            }
//                            else {
//                                class3.setText("Time:10:40-11:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr4=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/11:40-12:35");
//                    dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class4.setText("Time:11:40-12:35\nNo Class");
//                            }
//                            else {
//                                class4.setText("Time:11:40-12:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr5=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/13:30-14:25");
//                    dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class5.setText("Time:13:30-14:25\nNo Class");
//                            }
//                            else {
//                                class5.setText("Time:13:30-14:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr6=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/14:30-15:25");
//                    dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class6.setText("Time:14:30-15:25\nNo Class");
//                            }
//                            else {
//                                class6.setText("Time:14:30-15:25\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr7=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/15:40-16:35");
//                    dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class7.setText("Time:15:40-16:35\nNo Class");
//                            }
//                            else {
//                                class7.setText("Time:15:40-16:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr8=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/16:40-17:35");
//                    dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class8.setText("Time:16:40-17:35\nNo Class");
//                            }
//                            else {
//                                class8.setText("Time:16:40-17:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                    DocumentReference dcr9=firebaseFirestore.document("S_TT/"+cyear+"/"+cbatch+"/17:40-18:35");
//                    dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            String check=documentSnapshot.getString(day);
//                            if (check.equals("")){
//                                class9.setText("Time:17:40-18:35\nNo Class");
//                            }
//                            else {
//                                class9.setText("Time:17:40-18:35\n"+documentSnapshot.getString(day));
//                            }
//                        }
//                    });
//                }//if end here
//                else{
//                    lbreak.setText("");
//                    class1.setText("Today is "+day+"\n So Enjoy");
//                }
//            }
//        });// Time Table Retrieved.
//
//        //Spinner start
//        daych();
//        //verification checking
//        new Timer().schedule(new TimerTask() {
//            @Override
//            public void run() {
//                // this code will be executed after 10 minutes
//                ifnotverified();
//                //deleteaccount();
//            }
//        }, 1000*60*10);
//    }
//    public void logoutfn(View view){
//        FirebaseAuth.getInstance().signOut();
//        startActivity(new Intent(getApplicationContext(),Loginpage.class));
//        finish();
//    }
//    //SUPPORT PAGE
//    public void csupport(View view){
//        csp=findViewById(R.id.csupport);
//        // csp.setOnClickListener(new View.OnClickListener() {
//        //  @Override
//        //  public void onClick(View view) {
//        startActivity(new Intent(getApplicationContext(),CSupport.class));   //customer support
//        //  }
//        // });
//    }
//    public void facultyfn(View view){
//        faculty=findViewById(R.id.faculty2);
////        faculty.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//        startActivity( new Intent(getApplicationContext(),Facultypage.class));
//        finish();
////            }
////        });
//    }
//    public void homefn(View view){
//        home=findViewById(R.id.button);
////        home.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
//        startActivity(new Intent(getApplicationContext(),MainActivity.class));
////            }
////        });
//    }
//    public void daych() {
//        spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
//        {
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
//            {
//                String SelectedDay=spin.getSelectedItem().toString();
//                if(SelectedDay.equals("Today")) {
//
//
//                    DocumentReference dcrb = firebaseFirestore.document("USERS/" + UserIEmail);
//                    dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            cbatch = documentSnapshot.getString("Batch");
//                            cyear = documentSnapshot.getString("Year");
//                            int weekend = 0;
//                            //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
//                            String weekends[] = {"Saturday", "Sunday"};
//                            for (int i = 0; i < 2; i++) {
//                                if (day.equals(weekends[i])) {
//                                    weekend += 1;
//                                }
//                            }
//                            if (weekend == 0) {
//                                DocumentReference dcr1 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/8:30-9:25");
//                                dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class1.setText("Time:8:30-9:25\nNo Class");
//                                        } else {
//                                            class1.setText("Time:8:30-9:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr2 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/9:30-10:25");
//                                dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class2.setText("Time:9:30-10:25\nNo Class");
//                                        } else {
//                                            class2.setText("Time:9:30-10:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr3 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/10:40-11:35");
//                                dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class3.setText("Time:10:40-11:35\nNo Class");
//                                        } else {
//                                            class3.setText("Time:10:40-11:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr4 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/11:40-12:35");
//                                dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class4.setText("Time:11:40-12:35\nNo Class");
//                                        } else {
//                                            class4.setText("Time:11:40-12:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr5 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/13:30-14:25");
//                                dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class5.setText("Time:13:30-14:25\nNo Class");
//                                        } else {
//                                            class5.setText("Time:13:30-14:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr6 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/14:30-15:25");
//                                dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class6.setText("Time:14:30-15:25\nNo Class");
//                                        } else {
//                                            class6.setText("Time:14:30-15:25\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr7 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/15:40-16:35");
//                                dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class7.setText("Time:15:40-16:35\nNo Class");
//                                        } else {
//                                            class7.setText("Time:15:40-16:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr8 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/16:40-17:35");
//                                dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class8.setText("Time:16:40-17:35\nNo Class");
//                                        } else {
//                                            class8.setText("Time:16:40-17:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                DocumentReference dcr9 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/17:40-18:35");
//                                dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                    @Override
//                                    public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                        String check = documentSnapshot.getString(day);
//                                        if (check.equals("")) {
//                                            class9.setText("Time:17:40-18:35\nNo Class");
//                                        } else {
//                                            class9.setText("Time:17:40-18:35\n" + documentSnapshot.getString(day));
//                                        }
//                                    }
//                                });
//                                lbreak.setText("Time:12:40-1:30\nLunch Break");
//                            }//if end here
//                            else {
//                                lbreak.setText("");
//                                class1.setText("Today is " + day + "\n So Enjoy");
//                                class2.setText("");
//                                class3.setText("");
//                                class4.setText("");
//                                class5.setText("");
//                                class6.setText("");
//                                class7.setText("");
//                                class8.setText("");
//                                class9.setText("");
//                            }
//                        }
//                    });
//                }
//                else if(SelectedDay.equals("Saturday")| SelectedDay.equals("Sunday")){
//                    lbreak.setText("");
//                    if (SelectedDay.equals("Saturday"))
//                        class1.setText("Today is Saturday"+"\n So Enjoy");
//                    else
//                        class1.setText("Today is Sunday"+"\n So Enjoy");
//                    class2.setText("");
//                    class3.setText("");
//                    class4.setText("");
//                    class5.setText("");
//                    class6.setText("");
//                    class7.setText("");
//                    class8.setText("");
//                    class9.setText("");
//                }
//                else{
//                    DocumentReference dcrb = firebaseFirestore.document("USERS/" + UserIEmail);
//                    dcrb.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//
//                        @Override
//                        public void onSuccess(DocumentSnapshot documentSnapshot) {
//                            cbatch = documentSnapshot.getString("Batch");
//                            cyear = documentSnapshot.getString("Year");
////                            int weekend = 0;
////                            //String weekdays[]={"Monday","Tuesday","Wednesday","Thursday","Friday"};
////                            String weekends[] = {"Saturday", "Sunday"};
////                            for (int i = 0; i < 2; i++) {
////                                if (SelectedDay.equals(weekends[i])) {
////                                    weekend += 1;
////                                }
////                            }
////                            if (weekend == 0) {
//                            DocumentReference dcr1 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/8:30-9:25");
//                            dcr1.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class1.setText("Time:8:30-9:25\nNo Class");
//                                    } else {
//                                        class1.setText("Time:8:30-9:25\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr2 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/9:30-10:25");
//                            dcr2.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class2.setText("Time:9:30-10:25\nNo Class");
//                                    } else {
//                                        class2.setText("Time:9:30-10:25\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr3 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/10:40-11:35");
//                            dcr3.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class3.setText("Time:10:40-11:35\nNo Class");
//                                    } else {
//                                        class3.setText("Time:10:40-11:35\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr4 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/11:40-12:35");
//                            dcr4.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class4.setText("Time:11:40-12:35\nNo Class");
//                                    } else {
//                                        class4.setText("Time:11:40-12:35\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr5 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/13:30-14:25");
//                            dcr5.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class5.setText("Time:13:30-14:25\nNo Class");
//                                    } else {
//                                        class5.setText("Time:13:30-14:25\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr6 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/14:30-15:25");
//                            dcr6.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class6.setText("Time:14:30-15:25\nNo Class");
//                                    } else {
//                                        class6.setText("Time:14:30-15:25\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr7 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/15:40-16:35");
//                            dcr7.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class7.setText("Time:15:40-16:35\nNo Class");
//                                    } else {
//                                        class7.setText("Time:15:40-16:35\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr8 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/16:40-17:35");
//                            dcr8.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class8.setText("Time:16:40-17:35\nNo Class");
//                                    } else {
//                                        class8.setText("Time:16:40-17:35\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            DocumentReference dcr9 = firebaseFirestore.document("S_TT/" + cyear + "/" + cbatch + "/17:40-18:35");
//                            dcr9.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
//                                @Override
//                                public void onSuccess(DocumentSnapshot documentSnapshot) {
//                                    String check = documentSnapshot.getString(SelectedDay);
//                                    if (check.equals("")) {
//                                        class9.setText("Time:17:40-18:35\nNo Class");
//                                    } else {
//                                        class9.setText("Time:17:40-18:35\n" + documentSnapshot.getString(SelectedDay));
//                                    }
//                                }
//                            });
//                            lbreak.setText("Time:12:40-1:30\nLunch Break");
//                        }//if end here
////                            else {
////                                lbreak.setText("");
////                                class1.setText("Today is " + SelectedDay + "\n So Enjoy");
////                            }
////                        }
//                    });
//                }
//            } // to close the onItemSelected
//            public void onNothingSelected(AdapterView<?> parent)
//            {
//            }
//        });
//    }
//    public void ifnotverified() {
//        try {
//            if (firebaseAuth.getCurrentUser().isEmailVerified() == false) {
//                FirebaseAuth.getInstance().signOut();
//                startActivity(new Intent(getApplicationContext(),Loginpage.class));
//                finish();
//            }
//        }catch (Exception ex){
//            Log.d("exception in logout fn", "ifnotverified:+ "+ex.getMessage());
//            Toast.makeText(this, "Some error occurred please fill the form on Support/Contact Us", Toast.LENGTH_SHORT).show();
//        }
//    }
////    public void deleteaccount(){
////        if (firebaseAuth.getCurrentUser().isEmailVerified() ==false){
////            //To delete Account
////                FirebaseUser user = firebaseAuth.getCurrentUser();
////                user.delete();
////                Toast.makeText(this, "Account Deleted", Toast.LENGTH_SHORT).show();
////                startActivity(new Intent(getApplicationContext(),Registerpage.class));
////                finish();
////        }
////    }
//}