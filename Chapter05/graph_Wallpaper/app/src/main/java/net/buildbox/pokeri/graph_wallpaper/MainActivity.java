package net.buildbox.pokeri.graph_wallpaper;

import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private WallpaperManager mWallpaperManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWallpaperManager = WallpaperManager.getInstance(this);
    }

    public void onWallpaperSetting(View view) {
        // 壁紙の設定
        try {
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
            mWallpaperManager.setBitmap(bitmap);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void onWallpaperClear(View view) {
        // 壁紙のクリア
        try {
            mWallpaperManager.clear();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
