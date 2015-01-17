package com.example.administrator.helloservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;

/**
 * Created by Administrator on 2015-01-17.
 */
public class TimeService extends Service {

    private String DEBUG_NAME ="Ecolo9ger_Count";
    private long mCountRemaining;

    public long getmCountRemaining() {
        return mCountRemaining;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        mCountRemaining = intent.getLongExtra("CountRemaining", 0);
        excuteCount();
        return super.onStartCommand(intent, flags, startId);
    }

    private void excuteCount(){
        if(mCountRemaining > 0){
            for(int i=0; i <= mCountRemaining; i--){
                Log.i(DEBUG_NAME, "count : " + i);
                mCountRemaining--;
            }
        }
        else
        {
            stopSelf();
            Log.i(DEBUG_NAME, "서비스가 끝났습니다.");
        }

    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
