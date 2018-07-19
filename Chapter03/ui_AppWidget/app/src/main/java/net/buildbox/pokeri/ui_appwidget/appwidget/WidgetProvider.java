package net.buildbox.pokeri.ui_appwidget.appwidget;

import android.app.PendingIntent;
import android.app.Service;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.widget.RemoteViews;

import net.buildbox.pokeri.ui_appwidget.R;

public class WidgetProvider extends AppWidgetProvider {
    private static final String KEY_COUNT = "KEY_COUNT";

    @Override
    public void onReceive(Context context, Intent intent) {
        // サービスの起動
        Intent serviceIntent = new Intent(context, CountService.class);
        context.startService(serviceIntent);

        super.onReceive(context, intent);
    }

    public static class CountService extends Service {
        private static final String ACTION_COUNT = "net.buildbox.pokeri.action.ACTION_COUNT";
        private static final int REQUEST_COUNT_UP = 1;

        @Override
        public int onStartCommand(Intent intent, int flags, int startId) {
            super.onStartCommand(intent, flags, startId);

            // AppWidget上のボタンがクリックされた時の処理用Intent
            Intent clickIntent = new Intent();
            clickIntent.setAction(ACTION_COUNT);
            PendingIntent pendingIntent = PendingIntent.getService(this, REQUEST_COUNT_UP, clickIntent, PendingIntent.FLAG_ONE_SHOT);
            RemoteViews remoteViews = new RemoteViews(getPackageName(), R.layout.appwidget_main);
            remoteViews.setOnClickPendingIntent(R.id.update_button, pendingIntent);

            // 受信したIntentの処理
            if (ACTION_COUNT.equals(intent.getAction())) {
                countUp();
                remoteViews.setTextViewText(R.id.count_view, "更新： " + getCount());
            }

            // AppWidgetの画面更新
            ComponentName widget = new ComponentName(this, WidgetProvider.class);
            AppWidgetManager widgetManager = AppWidgetManager.getInstance(this);
            widgetManager.updateAppWidget(widget, remoteViews);

            return START_STICKY;
        }

        @Override
        public IBinder onBind(Intent intent) {
            return null;
        }

        private int getCount() {
            SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
            return pref.getInt(KEY_COUNT, 0);
        }

        private void countUp() {
            PreferenceManager.getDefaultSharedPreferences(this).edit()
                .putInt(KEY_COUNT, getCount() + 1)
                .apply();
        }
    }
}
