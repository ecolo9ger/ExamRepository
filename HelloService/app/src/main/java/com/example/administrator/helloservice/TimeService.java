package com.example.administrator.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Administrator on 2015-01-17.
 */
public class TimeService extends Service {
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
