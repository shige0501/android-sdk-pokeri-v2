package net.buildbox.pokeri.media_volumecontrol;

import android.media.AudioManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // アプリ起動中のボリューム変更はアラートに変更
        setVolumeControlStream(AudioManager.STREAM_ALARM);
    }
}
