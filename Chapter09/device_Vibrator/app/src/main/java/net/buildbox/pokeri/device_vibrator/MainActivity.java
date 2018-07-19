package net.buildbox.pokeri.device_vibrator;

import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onVibrate(View view) {
        // バイブレーションの実行
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        if (vibrator != null) {
            vibrator.vibrate(1000); // 1秒実行
        }
    }

    public void onVibratePattern(View view) {
        // バイブレーションのパターン実行
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long[] pattern = {
            100, 500, // 停止：100ミリ秒、バイブレーション500ミリ秒
            100, 500, // 停止：100ミリ秒、バイブレーション500ミリ秒
            100, 500, // 停止：100ミリ秒、バイブレーション500ミリ秒
            100, 2000 // 停止：100ミリ秒、バイブレーション2000ミリ秒
        };
        if (vibrator != null) {
            vibrator.vibrate(pattern, -1);
        }
    }
}
