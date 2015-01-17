package com.example.administrator.helloservice;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
    private String DEBUG_NAME ="Ecolo9ger_Count";

    TimeService mTimerService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent _intent = new Intent(getBaseContext(), TimeService.class);
        bindService(_intent, mConnection,BIND_AUTO_CREATE);
    }

    public void onClick_btnAction(View v){
        Intent _intent = new Intent(getBaseContext(), TimeService.class);
        _intent.putExtra("CountRemaining", 25L);
        startService(_intent);
    }

    public void onClick_btnFinish(View v){
        Intent _intent = new Intent(getBaseContext(), TimeService.class);
        _intent.putExtra("CountRemaining",0L);
        stopService(_intent);
    }

    public void onClick_btnGetData(View v){

    }

    private ServiceConnection mConnection  = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            //서비스 연결됨
            Log.i(DEBUG_NAME, "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            //서비스 끊김
            Log.i(DEBUG_NAME, "onServiceDisconnected");
        }
    };

    @Override
    protected void onDestroy() {
        unbindService(mConnection);
        Log.i(DEBUG_NAME, "onDestroy");
        super.onDestroy();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if(id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
