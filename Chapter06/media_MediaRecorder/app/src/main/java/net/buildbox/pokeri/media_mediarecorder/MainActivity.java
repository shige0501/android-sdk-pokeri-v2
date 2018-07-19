package net.buildbox.pokeri.media_mediarecorder;

import android.Manifest;
import android.databinding.DataBindingUtil;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;

import net.buildbox.pokeri.media_mediarecorder.databinding.ActivityMainBinding;

import java.io.IOException;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.PermissionUtils;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {

    private MediaRecorder mRecorder = null;

    private CompoundButton.OnCheckedChangeListener mListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) { // 録音開始
                mRecorder = new MediaRecorder();
                mRecorder.setAudioSource(MediaRecorder.AudioSource.DEFAULT);
                mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
                mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.DEFAULT);

                // 保存先の指定
                String path = Environment.getExternalStorageDirectory() + "/record_audio.mp4";
                mRecorder.setOutputFile(path);

                // 録音準備
                try {
                    mRecorder.prepare();
                } catch (IllegalStateException | IOException e) {
                    e.printStackTrace();
                }

                // 録音開始
                mRecorder.start();
            } else {
                // 録音の停止
                if (mRecorder != null) {
                    mRecorder.stop();
                    mRecorder.reset();
                    mRecorder.release();
                    mRecorder = null;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.toggleRecord.setOnCheckedChangeListener(mListener);

        if (!PermissionUtils.hasSelfPermissions(this, Manifest.permission.RECORD_AUDIO)) {
            MainActivityPermissionsDispatcher.verifyRecordAudioWithPermissionCheck(this);
        }
        if (!PermissionUtils.hasSelfPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            MainActivityPermissionsDispatcher.verifyWriteExternalStorageWithPermissionCheck(this);
        }
    }

    @Override
    protected void onDestroy() {
        // 録音の停止
        if (mRecorder != null) {
            mRecorder.stop();
            mRecorder.reset();
            mRecorder.release();
            mRecorder = null;
        }
        super.onDestroy();
    }

    @NeedsPermission(Manifest.permission.RECORD_AUDIO)
    public void verifyRecordAudio() {
        Toast.makeText(this, "録音の権限を有効化しました", Toast.LENGTH_SHORT).show();
        if (!PermissionUtils.hasSelfPermissions(this, Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            MainActivityPermissionsDispatcher.verifyWriteExternalStorageWithPermissionCheck(this);
        }
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public void verifyWriteExternalStorage() {
        Toast.makeText(this, "書き込みの権限を有効化しました", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied(Manifest.permission.RECORD_AUDIO)
    void onRecordAudioDenied() {
        Toast.makeText(this, "録音の権限がありません", Toast.LENGTH_SHORT).show();
    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void onWriteExternalStorageDenied() {
        Toast.makeText(this, "書き込みの権限がありません", Toast.LENGTH_SHORT).show();
    }
}
