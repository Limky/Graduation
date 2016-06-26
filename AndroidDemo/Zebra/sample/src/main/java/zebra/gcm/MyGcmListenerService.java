package zebra.gcm;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.android.gms.gcm.GcmListenerService;

import java.net.URLDecoder;

import example.zxing.BuildConfig;
import example.zxing.R;
import zebra.activity.LoginActivity;
import zebra.activity.MainActivity;
import zebra.manager.ScanManager;

/**
 * Created by multimedia on 2016-06-01.
 */
public class MyGcmListenerService extends GcmListenerService {

    private static final String TAG = "MyGcmListenerService";
    private static final int REGIST_REJECTED = 0;
    private static final int REGIST_OK = 1;

    /**
     * @param from SenderID 값을 받아온다.
     * @param data Set형태로 GCM으로 받은 데이터 payload이다.
     */
    @Override
    public void onMessageReceived(String from, Bundle data) {
        String title = "";
        String titleTemp = "";
        String message = "";
        String messageTemp = "";
        String barcode = data.getString("barcode");
        if (BuildConfig.DEBUG) {
            try {
                titleTemp = data.getString("title");
                messageTemp = data.getString("message");
                title = URLDecoder.decode(titleTemp, "euc-kr");
                message = URLDecoder.decode(messageTemp, "euc-kr");
            } catch (Exception e) {
                Log.i("test", "[onMessage] Exception : " + e.getMessage());
            }
        }

        title.replace("+", "\t");
        message.replace("+", "\t");

        Log.d(TAG, "From: " + from);
        Log.d(TAG, "Title: " + title);
        Log.d(TAG, "Message: " + message);

        // GCM으로 받은 메세지를 디바이스에 알려주는 sendNotification()을 호출한다.
        sendNotification(title, message, barcode);
    }

    /**
     * 실제 디바에스에 GCM으로부터 받은 메세지를 알려주는 함수이다. 디바이스 Notification Center에 나타난다.
     *
     * @param title
     * @param message
     */
    private void sendNotification(String title, String message, String barcode) {

        PendingIntent pendingIntent;
        if (title.equals("감사합니다")) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pendingIntent = PendingIntent.getActivity(this, REGIST_OK, intent, PendingIntent.FLAG_ONE_SHOT);

            ScanManager.getInstance().setIsGCM(true);
            ScanManager.getInstance().setBarcode(barcode);

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.zebra_icon_logo)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(REGIST_OK, notificationBuilder.build());
        } else {
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            pendingIntent = PendingIntent.getActivity(this, REGIST_REJECTED, intent, PendingIntent.FLAG_ONE_SHOT);
            intent.putExtra("Direction","Main");
            intent.putExtra("Barcode", "");

            Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                    .setSmallIcon(R.drawable.zebra_icon_logo)
                    .setContentTitle(title)
                    .setContentText(message)
                    .setAutoCancel(true)
                    .setSound(defaultSoundUri)
                    .setContentIntent(pendingIntent);

            NotificationManager notificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(REGIST_REJECTED, notificationBuilder.build());
        }

        /*
        Intent intent = new Intent(this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);
        */


    }
}