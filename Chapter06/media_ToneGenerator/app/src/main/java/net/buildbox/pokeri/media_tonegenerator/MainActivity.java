package net.buildbox.pokeri.media_tonegenerator;

import android.databinding.DataBindingUtil;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.buildbox.pokeri.media_tonegenerator.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;
    private ToneGenerator mToneGenerator;

    private View.OnClickListener mOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.button_1:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_1, 200);
                    break;
                case R.id.button_2:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_2, 200);
                    break;
                case R.id.button_3:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_3, 200);
                    break;
                case R.id.button_4:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_4, 200);
                    break;
                case R.id.button_5:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_5, 200);
                    break;
                case R.id.button_6:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_6, 200);
                    break;
                case R.id.button_7:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_7, 200);
                    break;
                case R.id.button_8:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_8, 200);
                    break;
                case R.id.button_9:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_9, 200);
                    break;
                case R.id.button_a:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_A, 200);
                    break;
                case R.id.button_0:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_0, 200);
                    break;
                case R.id.button_b:
                    mToneGenerator.startTone(ToneGenerator.TONE_DTMF_B, 200);
                    break;
            }
        }
    };

    //region Lifecycle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        // ToneGenerator の生成
        mToneGenerator = new ToneGenerator(AudioManager.STREAM_SYSTEM, ToneGenerator.MAX_VOLUME);

        initializeButton();
    }

    @Override
    public void onDestroy() {
        // ToneGeneratorの解放
        mToneGenerator.release();
        super.onDestroy();
    }

    ;
    //endregion

    //region Private
    private void initializeButton() {
        mBinding.button1.setOnClickListener(mOnClickListener);
        mBinding.button2.setOnClickListener(mOnClickListener);
        mBinding.button3.setOnClickListener(mOnClickListener);
        mBinding.button4.setOnClickListener(mOnClickListener);
        mBinding.button5.setOnClickListener(mOnClickListener);
        mBinding.button6.setOnClickListener(mOnClickListener);
        mBinding.button7.setOnClickListener(mOnClickListener);
        mBinding.button8.setOnClickListener(mOnClickListener);
        mBinding.button9.setOnClickListener(mOnClickListener);
        mBinding.buttonA.setOnClickListener(mOnClickListener);
        mBinding.button0.setOnClickListener(mOnClickListener);
        mBinding.buttonB.setOnClickListener(mOnClickListener);
    }
    //endregion
}
