package net.buildbox.pokeri.device_wifistate;

import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Wi-Fiの有効状態を取得
        WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService(WIFI_SERVICE);
        if (wifiManager == null) {
            Toast.makeText(this, "Wi-Fi の状態が取得できませんでした", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isEnabled = wifiManager.isWifiEnabled();

        TextView wifiEnabledView = findViewById(R.id.wifi_enabled);
        wifiEnabledView.setText(String.format("Wi-Fiの有効状態: %s", isEnabled ? "true" : "false"));

        // Wi-Fiの状態を取得
        int wifiState = wifiManager.getWifiState();
        TextView wifiStateView = findViewById(R.id.wifi_state);
        switch (wifiState) {
            case WifiManager.WIFI_STATE_DISABLING: // 無効化中
                wifiStateView.setText("Wi-Fiの状態： 無効化中");
                break;
            case WifiManager.WIFI_STATE_DISABLED: // 無効状態
                wifiStateView.setText("Wi-Fiの状態： 無効");
                break;
            case WifiManager.WIFI_STATE_ENABLING: // 有効化中
                wifiStateView.setText("Wi-Fiの状態: 有効化中");
                break;
            case WifiManager.WIFI_STATE_ENABLED: // 有効状態
                wifiStateView.setText("Wi-Fiの状態： 有効");
                break;
            case WifiManager.WIFI_STATE_UNKNOWN: // 不定
                wifiStateView.setText("Wi-Fiの状態: 不明");
                break;
        }
    }
}
