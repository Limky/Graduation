package zebra.gcm;

import android.content.Intent;

import com.google.android.gms.iid.InstanceIDListenerService;

/**
 * Created by multimedia on 2016-06-01.
 */
public class MyInstanceIDListenerService  extends InstanceIDListenerService {

    private static final String TAG = "MyInstanceIDLS";

    @Override
    public void onTokenRefresh() {
        Intent intent = new Intent(this, RegistrationIntentService.class);
        startService(intent);
    }
}