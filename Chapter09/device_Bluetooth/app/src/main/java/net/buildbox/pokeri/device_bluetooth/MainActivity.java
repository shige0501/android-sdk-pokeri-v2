package net.buildbox.pokeri.device_bluetooth;

import android.bluetooth.BluetoothAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Bluetoothの有効状態をチェック
        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter != null && bluetoothAdapter.isEnabled()) {
            Toast.makeText(this, "Bluetoothは有効です", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Bluetoothは無効です", Toast.LENGTH_SHORT).show();
        }
    }
}
