package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private static final String CHANNEL_ID = "My Id";
    private static final int NOTIFY_ID = 736;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.sample_image, null);
        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
        Bitmap bitmap = bitmapDrawable.getBitmap();

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        Notification notification;
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            notification = new Notification.Builder(this)
                    .setLargeIcon(bitmap)
                    .setSmallIcon(R.drawable.sample_image)
                    .setSubText("New Message")
                    .setContentText("New Message Recevied")
                    .setChannelId(CHANNEL_ID)
                    .build();
            notificationManager.createNotificationChannel(new NotificationChannel(CHANNEL_ID, "My Channel", NotificationManager.IMPORTANCE_HIGH));
        }
        else{
            notification = new Notification.Builder(this)
                    .setLargeIcon(bitmap)
                    .setSmallIcon(R.drawable.sample_image)
                    .setSubText("New Message")
                    .setContentText("New Message Recevied")
                    .build();
        }
    notificationManager.notify(NOTIFY_ID, notification);
    }
}