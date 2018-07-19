package net.buildbox.pokeri.system_boot.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BootReceiver extends BroadcastReceiver {
    // ブロードキャストの受信処理
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "端末起動をトリガーに表示しました。", Toast.LENGTH_LONG).show();
    }
}