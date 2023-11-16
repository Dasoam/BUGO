package com.dh.bugo;

import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class BrodcastNF extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context,"Push Notification")
        .setContentTitle("")
        .setContentText("")
        .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat= NotificationManagerCompat.from(context);

        //notificationManagerCompat.notify(1,builder.build());


    }
}
