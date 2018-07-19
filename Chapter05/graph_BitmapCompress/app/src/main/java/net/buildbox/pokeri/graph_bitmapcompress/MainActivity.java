package net.buildbox.pokeri.graph_bitmapcompress;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaScannerConnection;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    private static final int PERMISSIONS_REQUEST = 185;
    private static final String[] PERMISSIONS = {
        Manifest.permission.WRITE_EXTERNAL_STORAGE,
        Manifest.permission.READ_EXTERNAL_STORAGE
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBitmapCompress(View view) {
        if (checkPermission()) {
            bitmapCompress();
        } else {
            requestPermission();
        }
    }

    @Override
    public void onRequestPermissionsResult(
        int requestCode,
        @NonNull String[] permissions,
        @NonNull int[] grantResults
    ) {
        if (requestCode == PERMISSIONS_REQUEST) {
            if (checkPermission()) {
                bitmapCompress();
            } else {
                Toast.makeText(this,
                    "ストレージにアクセスする権限がありません", Toast.LENGTH_SHORT).show();
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    void bitmapCompress() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
            R.mipmap.ic_launcher_round);

        // 保存先を指定
        File dir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);

        // 日付でファイル名を作成
        Date date = new Date();
        SimpleDateFormat fileName = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.JAPANESE);
        try {
            // 保存処理開始
            FileOutputStream fos = new FileOutputStream(
                new File(dir, fileName.format(date) + ".jpg"));

            // jpegで保存
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            MediaScannerConnection.scanFile(this,
                new String[]{dir.getAbsolutePath()}, new String[]{"image/jpg"}, null);

            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean checkPermission() {
        return ActivityCompat.checkSelfPermission(
            this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
    }

    private void requestPermission() {
        ActivityCompat.requestPermissions(this, PERMISSIONS, PERMISSIONS_REQUEST);
    }
}
