package net.buildbox.pokeri.device_headsetplug;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BroadcastReceiver handsetPlug = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                // イヤホンの状態を確認
                if (action != null && action.equalsIgnoreCase(Intent.ACTION_HEADSET_PLUG)) {
                    switch (intent.getIntExtra("state", 0)) {
                        case 0: // 未接続状態
                            Toast.makeText(context, "イヤホンは未接続です", Toast.LENGTH_SHORT).show();
                            break;
                        case 1: // 接続状態
                            Toast.makeText(context, "イヤホンが接続しました", Toast.LENGTH_SHORT).show();
                            break;
                    }
                }

            }
        };

        // イヤホン接続のBroadcastReceiverの登録
        registerReceiver(handsetPlug, new IntentFilter(Intent.ACTION_HEADSET_PLUG));
    }
}
