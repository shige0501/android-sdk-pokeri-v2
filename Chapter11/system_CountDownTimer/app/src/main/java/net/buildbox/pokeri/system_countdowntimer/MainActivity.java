package net.buildbox.pokeri.system_countdowntimer;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // 10秒のカウントダウンを実施 (200ミリ秒ごとにインターバルの通知)
    private CountDownTimer mCountDownTimer = new CountDownTimer(10000, 200) {
        // カウントダウンの途中経過のコールバック処理
        @Override
        public void onTick(long millisUntilFinished) {
            Log.d(TAG, "あと、" + (millisUntilFinished / 1000) + "秒");
        }

        // カウントダウン終了のコールバック処理
        @Override
        public void onFinish() {
            Toast.makeText(getApplicationContext(), "カウント終了", Toast.LENGTH_SHORT).show();
            ToggleButton countDownButton = findViewById(R.id.countdown_button);
            countDownButton.setChecked(false);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ToggleButton countDownButton = findViewById(R.id.countdown_button);
        countDownButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // カウントダウンの開始
                    mCountDownTimer.start();
                } else {
                    // カウントダウンのキャンセル
                    mCountDownTimer.cancel();
                }
            }
        });
    }
}
