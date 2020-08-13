package com.createsapp.riderappjava.Common;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;

import androidx.core.app.NotificationCompat;

import com.createsapp.riderappjava.R;
import com.createsapp.riderappjava.model.RiderModel;

public class Common {
    public static final String RIDER_INFO_REFERENCE = "Riders";
    public static final String TOKEN_REFERENCE = "Token";
    public static RiderModel currentRider;

    public static final String NOTI_TITLE = "title";
    public static final String NOTI_CONTENT = "body";

    public static String buildwelcomeMessage() {
        if (Common.currentRider != null) {
            return new StringBuilder("Welcome ")
                    .append(Common.currentRider.getFirstName())
                    .append("")
                    .append(Common.currentRider.getLastName()).toString();
        } else
            return "";
    }

    public static void showNotification(Context context, int id, String title, String body, Intent intent) {
        PendingIntent pendingIntent = null;
        if (intent != null)
            pendingIntent = PendingIntent.getActivity(context, id, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        String NOTIFICATION_CHANNEL_ID = "creates_app";
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID,
                    "uber Remake", NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.setDescription("Uber Remake");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);

            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID);
        builder.setContentTitle(title)
                .setContentText(body)
                .setAutoCancel(false)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                .setSmallIcon(R.drawable.ic_baseline_directions_car_24)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.ic_baseline_directions_car_24));

        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }

        Notification notification = builder.build();
        notificationManager.notify(id, notification);
    }
}
