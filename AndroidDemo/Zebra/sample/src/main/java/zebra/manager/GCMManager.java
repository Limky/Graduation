package zebra.manager;

import android.content.BroadcastReceiver;

/**
 * Created by multimedia on 2016-06-02.
 */
public class GCMManager {
    public static GCMManager instance;
    public static GCMManager getInstance(){
        if(instance == null){
            instance = new GCMManager();
        }
        return instance;
    }

    public GCMManager(){

    }

    String token;

    public void setToken(String token){
        this.token = token;
    }
    public String getToken(){
        return this.token;
    }
}
