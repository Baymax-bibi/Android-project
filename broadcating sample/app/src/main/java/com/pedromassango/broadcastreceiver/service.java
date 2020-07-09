package com.pedromassango.broadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;

public class service extends IntentService {
    public static volatile boolean shouldStop = false;
    public service() {
        super(service.class.getSimpleName());
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
    @Override
    protected void onHandleIntent(Intent intent) {
        Intent intent1 = new Intent("com.example.andy.myapplication");
        intent1.putExtra("someName", "87");
        LocalBroadcastManager.getInstance(this).sendBroadcast(intent1);
        if(shouldStop){
            stopSelf();
            return;
        }
    }
}