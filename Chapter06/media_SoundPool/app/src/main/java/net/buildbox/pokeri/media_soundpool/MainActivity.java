package net.buildbox.pokeri.media_soundpool;

import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import net.buildbox.pokeri.media_soundpool.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int SOUND_COMPLETE_COUNT = 5;

    private SoundPool mSoundPool = null;
    private List<Integer> mSoundList = null;
    private int mSoundCompleteCount = 0;
    private ActivityMainBinding mBinding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mBinding.setMainActivity(this);

        // 音楽ファイルの読み込み
        mSoundPool = new SoundPool.Builder()
            .setMaxStreams(SOUND_COMPLETE_COUNT)
            .build();
        mSoundList = new ArrayList<>();
        mSoundList.add(0, mSoundPool.load(this, R.raw.cat, 1));
        mSoundList.add(1, mSoundPool.load(this, R.raw.crows, 1));
        mSoundList.add(2, mSoundPool.load(this, R.raw.door_chime, 1));
        mSoundList.add(3, mSoundPool.load(this, R.raw.knocking_iron_door1, 1));
        mSoundList.add(4, mSoundPool.load(this, R.raw.station_announce, 1));
        mSoundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status == 0) {
                    // 音楽ファイルの読み込みが完了
                    Log.d(TAG, "sampleId " + sampleId + "の読み込みが完了");
                    mSoundCompleteCount++;
                }
                if (mSoundCompleteCount == SOUND_COMPLETE_COUNT) {
                    mBinding.playSound.setEnabled(true);
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        if (mSoundPool != null) {
            mSoundPool.release();
        }
        super.onDestroy();
    }

    public void onSoundPool(View view) {
        // 乱数の生成
        int r = new Random().nextInt(SOUND_COMPLETE_COUNT);

        // 音楽の再生
        mSoundPool.play(mSoundList.get(r), 1.0f, 1.0f, 1, 0, 1.0f);
    }
}
