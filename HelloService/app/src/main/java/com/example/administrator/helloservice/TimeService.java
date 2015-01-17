package com.example.administrator.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

/**
 * Created by Administrator on 2015-01-17.
 */
public class TimeService extends Service {

    private long mCountRemaining;

    public long getmCountRemaining() {
        return mCountRemaining;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    private void excuteCount(){
        if(mCountRemaining == 0){
            for(int i=0; i <= mCountRemaining; i--){
                mCountRemaining--;
            }
        }
        else
        {
            //서비스 끝내라!
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
