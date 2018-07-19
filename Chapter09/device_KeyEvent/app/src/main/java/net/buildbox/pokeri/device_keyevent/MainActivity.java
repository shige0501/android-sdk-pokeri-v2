package net.buildbox.pokeri.device_keyevent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_DOWN) {
            switch (event.getKeyCode()) {
                case KeyEvent.KEYCODE_BACK:
                    // false で次のイベント処理に流れ、
                    // true の時は以降の処理が行われない
                    return true;

                case KeyEvent.KEYCODE_VOLUME_UP:
                    // ボリュームアップでアプリを終了する
                    finish();
                    return true;
            }
        }
        return super.dispatchKeyEvent(event);
    }
}
