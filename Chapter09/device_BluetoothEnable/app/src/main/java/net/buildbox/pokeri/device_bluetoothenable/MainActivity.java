package net.buildbox.pokeri.device_bluetoothenable;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int BLUETOOTH_ENABLE_REQUEST = 796;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        if (bluetoothAdapter == null) {
            Toast.makeText(this, "Bluetoothが利用できません", Toast.LENGTH_SHORT).show();
            return;
        }
        boolean isEnabled = bluetoothAdapter.isEnabled();
        if (isEnabled) {
            Toast.makeText(this, "Bluetoothは有効です", Toast.LENGTH_SHORT).show();
        } else {
            // Bluetoothの有効化を行う
            Intent bluetoothIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(bluetoothIntent, BLUETOOTH_ENABLE_REQUEST);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == BLUETOOTH_ENABLE_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(this, "Bluetoothを有効化しました", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Bluetoothを有効化しませんでした", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
