package net.buildbox.pokeri.media_audiomanager;

import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import net.buildbox.pokeri.media_audiomanager.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setMainActivity(this);

        // 着信音量の取得
        mAudioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        if (mAudioManager != null) {
            int ringVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
            mBinding.volume.setText(String.valueOf(ringVolume));
        }
    }

    public void onMinusClick(View view) {
        // 着信音の取得
        int ringVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
        if (ringVolume > 1) {
            // 着信音の設定（ボリュームを1下げる）
            mAudioManager.setStreamVolume(AudioManager.STREAM_RING, --ringVolume, AudioManager.FLAG_SHOW_UI);
            mBinding.volume.setText(String.valueOf(ringVolume));
        } else {
            // 0を指定するとSecurityExceptionを出力してクラッシュするため、Toastでメッセージ表示
            Toast.makeText(this, "これ以上下げることができません", Toast.LENGTH_SHORT).show();
        }
    }

    public void onPlusClick(View view) {
        // 着信音の取得
        int ringVolume = mAudioManager.getStreamVolume(AudioManager.STREAM_RING);
        // 着信音の設定（ボリュームを１上げる）
        mAudioManager.setStreamVolume(AudioManager.STREAM_RING, ++ringVolume, AudioManager.FLAG_SHOW_UI);
        mBinding.volume.setText(String.valueOf(ringVolume));
    }
}
