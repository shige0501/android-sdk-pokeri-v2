package net.buildbox.pokeri.app_alarmmanager.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // 受信したらトーストを表示
        Toast.makeText(context, "AlarmManagerの通知を受信しました", Toast.LENGTH_SHORT).show();
    }
}