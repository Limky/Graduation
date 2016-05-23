package example.zxing;

import android.app.Application;
import android.content.Context;

//import com.squareup.leakcanary.LeakCanary;

/**
 *
 */
public class SampleApplication extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        //LeakCanary.install(this);
        mContext = this;
    }

    public static Context getContext() {
        return mContext;
    }
}
