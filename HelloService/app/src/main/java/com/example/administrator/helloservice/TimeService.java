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

    private String DEBUG_NAME = "Ecolo9ger_Count";
    private long mCountRemaining;

    public long getmCountRemaining() {
        return mCountRemaining;
    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        Log.i(DEBUG_NAME, "onStartCommand");
        mCountRemaining = intent.getLongExtra("CountRemaining", 0);
        excuteCount();
        return super.onStartCommand(intent, flags, startId);
    }

    private void excuteCount() {
        Thread _thread = new Thread("TimerCount"){
            @Override
            public void run() {
                super.run();
                try {
                    if(mCountRemaining > 0) {
                        for(long i = mCountRemaining; i >= 0; i--) {
                            Log.i(DEBUG_NAME, "count : " + i);
                            mCountRemaining--;
                            try {
                                Thread.sleep(1000);
                            } catch(InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                } finally {
                    Log.i(DEBUG_NAME, "서비스가 끝났습니다.");
                }
            }
        };

        _thread.start();
    }

    @Override
    public void onDestroy() {
        Log.i(DEBUG_NAME, "onDestroy");
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
