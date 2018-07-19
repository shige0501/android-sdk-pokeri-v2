package net.buildbox.pokeri.ui_seekbar;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;

import net.buildbox.pokeri.ui_seekbar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // シークバーの最大値と初期値を設定
        mBinding.sampleSeekBar.setMax(100); // 最大値
        mBinding.sampleSeekBar.setProgress(0); // 初期値

        mBinding.sampleSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // トラッキング開始時に実施したい処理を記述します
            }

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                // トラッキング中の処理
                mBinding.progressMessage.setText(progress + " %...");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // トラッキング終了時に実施したい処理を記述します
            }
        });
    }
}
