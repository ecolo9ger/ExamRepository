package com.example.administrator.helloservice;

import android.app.Activity;

/**
 * Created by Administrator on 2015-01-17.
 */
public class DataCommunity extends Activity{
    public int getmNumber() {
        return mNumber;
    }

    public void setmNumber(int mNumber) {
        this.mNumber = mNumber;
    }

    public String getmText() {
        return mText;
    }

    public void setmText(String mText) {
        this.mText = mText;
    }

    private int mNumber;
    private String mText;
}
