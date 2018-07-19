package net.buildbox.pokeri.media_mediaplayer;

import android.databinding.DataBindingUtil;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.buildbox.pokeri.media_mediaplayer.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setMainActivity(this);
    }

    @Override
    protected void onPause() {
        if (mMediaPlayer != null) {
            mMediaPlayer.stop();
            mMediaPlayer.release();
        }
        super.onPause();
    }

    public void onButtonClick(View view) {
        mMediaPlayer = MediaPlayer.create(this, R.raw.waltz);
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // 読み込みが完了したら、再生を開始
                mediaPlayer.start();
            }
        });
    }
}
