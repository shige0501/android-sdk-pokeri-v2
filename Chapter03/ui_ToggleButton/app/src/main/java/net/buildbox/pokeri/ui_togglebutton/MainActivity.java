package net.buildbox.pokeri.ui_togglebutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton tbStatus = findViewById(R.id.status_toggle_button);
        tbStatus.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) { // チェック状態
                    Toast.makeText(getApplicationContext(), "チェック状態", Toast.LENGTH_LONG).show();
                } else { // 未チェック状態
                    Toast.makeText(getApplicationContext(), "未チェック状態", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
