package com.dh.bugo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class CSupport extends AppCompatActivity {
    TextView contactlink;
    Button conatctbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_csupport);
        contactlink=findViewById(R.id.Contactform);
        contactlink.setMovementMethod(LinkMovementMethod.getInstance()); //to send the user to google form.

        // using button
        conatctbutton=findViewById(R.id.Contactusbutton);
        conatctbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gotoform =new Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSeV8HCapC0fVA-xp9A9x4lbmKcR1lUYUFwntgp0j2i2DoewsA/viewform?usp=sf_link"));
                startActivity(gotoform);
            }
        });
    }
}