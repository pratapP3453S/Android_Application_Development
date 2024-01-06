package com.example.custom_notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "first.com.id.channel1";
    private static final int NOTIFY_ID = 924;
    private static final int REQUEST_CODE = 319;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, REQUEST_CODE, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Notification.BigPictureStyle bigPictureStyle = new Notification.BigPictureStyle()
                .bigPicture(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.pratap, null)).getBitmap())
                .bigLargeIcon(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.sample_image, null)).getBitmap())
                .setBigContentTitle("Image Received")
                .setSummaryText("Pratap's Profile Photo");

        Notification.InboxStyle inboxStyle = new Notification.InboxStyle()
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .addLine("A")
                .setSummaryText("My name is pratap")
                .setBigContentTitle("chalna nikal ab");

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.sample_image)
                    .setLargeIcon(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.sample_image, null)).getBitmap())
                    .setSubText("new message from pratap")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
//                    .setStyle(inboxStyle)
                    .setOngoing(true)
                    .setAutoCancel(false)
                    .setChannelId(CHANNEL_ID)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "New Channel System", NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(this)
                    .setSmallIcon(R.drawable.sample_image)
                    .setLargeIcon(((BitmapDrawable) ResourcesCompat.getDrawable(getResources(), R.drawable.sample_image, null)).getBitmap())
                    .setSubText("new message from pratap")
                    .setContentIntent(pendingIntent)
                    .setStyle(bigPictureStyle)
//                    .setStyle(inboxStyle)
                    .setOngoing(true)
                    .setAutoCancel(false)
                    .build();
        }
        notificationManager.notify(NOTIFY_ID, notification);
    }
}