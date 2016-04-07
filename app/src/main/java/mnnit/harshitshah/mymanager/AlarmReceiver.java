package mnnit.harshitshah.mymanager;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        /*NotificationManager notificationManager = (NotificationManager)context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent notificationintent;
        long when = System.currentTimeMillis();
        int MID=0;
        notificationintent = new Intent(context,MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                notificationintent, PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder mNotifyBuilder = (NotificationCompat.Builder) new NotificationCompat.Builder(
                context).setSmallIcon(R.drawable.photo)
                .setContentTitle("Alaram Fired")
                .setContentText("Events To be PErformed")
                .setAutoCancel(false).setWhen(when)
                .setContentIntent(pendingIntent)
                .setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
        notificationManager.notify(MID, mNotifyBuilder.build());
        MID++;*/
        Toast.makeText(context, "Alarm Triggered", Toast.LENGTH_SHORT).show();
    }
}
