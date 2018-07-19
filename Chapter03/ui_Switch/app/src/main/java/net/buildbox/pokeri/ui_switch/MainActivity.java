package net.buildbox.pokeri.ui_switch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // スイッチの状態変化を検知
        SwitchCompat sw = findViewById(R.id.state_switch);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // スイッチがONの状態
                    Toast.makeText(getApplicationContext(), "On", Toast.LENGTH_SHORT).show();
                } else {
                    // スイッチがOFFの状態
                    Toast.makeText(getApplicationContext(), "Off", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
