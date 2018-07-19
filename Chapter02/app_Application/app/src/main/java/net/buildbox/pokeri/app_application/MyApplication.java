package net.buildbox.pokeri.app_application;

import android.app.Application;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MyApplication extends Application {
    private static String mStartTime;

    @Override
    public void onCreate() {
        super.onCreate();

        // アプリの起動時間を保持する
        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.JAPAN);
        mStartTime = format.format(new Date(System.currentTimeMillis()));
    }

    public static String getStartTime() {
        return mStartTime;
    }
}
