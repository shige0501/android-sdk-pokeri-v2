package net.buildbox.pokeri.window_brightness;

import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画面の明るさを取得
        String brightness = Settings.System.getString(
            getContentResolver(),
            Settings.System.SCREEN_BRIGHTNESS);

        TextView brightnessMessage = findViewById(R.id.brightness_message);
        brightnessMessage.setText(String.format("画面の明るさ: %s", brightness));
    }
}
