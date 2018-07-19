package net.buildbox.pokeri.ui_timepicker;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TimePicker picker = findViewById(R.id.time_picker);
        picker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // 時刻が変更された時にToastを出力
                Toast.makeText(getApplicationContext(),
                    hourOfDay + ":" + minute + "です。",
                    Toast.LENGTH_SHORT).show();
            }
        });
    }
}
