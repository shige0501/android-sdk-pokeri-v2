package net.buildbox.pokeri.device_wifichange;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

import net.buildbox.pokeri.device_wifichange.receiver.WifiChangeReceiver;

public class MainActivity extends AppCompatActivity {
    private BroadcastReceiver mBroadcastReceiver = new WifiChangeReceiver();
    private IntentFilter mIntentFilter = new IntentFilter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wi-Fiの有効状態の取得
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        boolean bEnabled = false;
        if (wifiManager != null) {
            bEnabled = wifiManager.isWifiEnabled();
        }

        // Wi-Fiの有効状態をトグルボタンに反映
        ToggleButton wifiChangeButton = findViewById(R.id.wifi_change_button);
        wifiChangeButton.setChecked(bEnabled);

        // 有効状態の切り替え
        wifiChangeButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                // Wi-Fiの有効状態の変更
                WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
                if (wifiManager != null) {
                    wifiManager.setWifiEnabled(isChecked);
                }
            }
        });

        // インテントフィルタの設定
        mIntentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(mBroadcastReceiver, mIntentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(mBroadcastReceiver);
        super.onPause();
    }
}
