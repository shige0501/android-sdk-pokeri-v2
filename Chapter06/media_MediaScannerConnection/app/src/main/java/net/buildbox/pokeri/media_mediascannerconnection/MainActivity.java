package net.buildbox.pokeri.media_mediascannerconnection;

import android.Manifest;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.OnPermissionDenied;
import permissions.dispatcher.RuntimePermissions;

@RuntimePermissions
public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();

    // スキャンが完了したときのコールバック処理
    private MediaScannerConnection.OnScanCompletedListener mListener = new MediaScannerConnection.OnScanCompletedListener() {
        @Override
        public void onScanCompleted(String path, Uri uri) {
            Log.d(TAG, "path = " + path);
            Log.d(TAG, "uri = " + uri);
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainActivityPermissionsDispatcher.generateSampleFileWithPermissionCheck(this);
    }

    @NeedsPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    public void generateSampleFile() {
        // SDカードにファイルを作成
        String fileName = "pokeri_test.txt";
        String mimeType = "plain/text";
        File file = new File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            fileName);
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello, Android SDKポケットリファレンス");
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        // MediaScannerConnectionでスキャン
        MediaScannerConnection.scanFile(
            this,
            new String[]{file.getPath()},
            new String[]{mimeType},
            mListener);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        MainActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @OnPermissionDenied(Manifest.permission.WRITE_EXTERNAL_STORAGE)
    void onWriteExternalStorageDenied() {
        Toast.makeText(this, "書き込みの権限がありません", Toast.LENGTH_SHORT).show();
    }
}
