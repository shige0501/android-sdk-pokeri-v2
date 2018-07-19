package net.buildbox.pokeri.device_battery.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // バッテリーの変化のIntentをチェック
        String action = intent.getAction();
        if (action != null && action.equals(Intent.ACTION_BATTERY_CHANGED)) {
            Bundle bundle = intent.getExtras();
            int status = bundle != null ?
                bundle.getInt(BatteryManager.EXTRA_STATUS) : BatteryManager.BATTERY_STATUS_UNKNOWN;
            switch (status) {
                case BatteryManager.BATTERY_STATUS_FULL: // フル充電の状態
                    Toast.makeText(context, "フル充電状態", Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_STATUS_CHARGING: // 充電中
                    Toast.makeText(context, "充電中", Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_STATUS_DISCHARGING: // 充電切断
                    Toast.makeText(context, "充電切断", Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_STATUS_NOT_CHARGING: // 放電中
                    Toast.makeText(context, "放電中", Toast.LENGTH_SHORT).show();
                    break;
                case BatteryManager.BATTERY_STATUS_UNKNOWN: // 状態不明
                    Toast.makeText(context, "充電状態が不明", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}
