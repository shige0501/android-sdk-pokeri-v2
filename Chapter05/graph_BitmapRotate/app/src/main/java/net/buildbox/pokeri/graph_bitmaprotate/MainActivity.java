package net.buildbox.pokeri.graph_bitmaprotate;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画像リソースの読み込み
        AssetManager assetManager = getAssets();
        try {
            // assetsから取得した画像からBitmapオブジェクトを取得
            InputStream is = assetManager.open("nougat.jpg");
            BufferedInputStream buf = new BufferedInputStream(is);
            Bitmap bitmap = BitmapFactory.decodeStream(buf);

            // ビットマップの回転を設定
            Matrix matrix = new Matrix();
            matrix.postRotate(90.0f);

            Bitmap rotateBitmap = Bitmap.createBitmap(bitmap, 0, 0,
                bitmap.getWidth(), bitmap.getHeight(), matrix, true);

            // 画像をImageViewで表示
            ImageView nougatRotateView = findViewById(R.id.nougat_rotate_view);
            nougatRotateView.setImageBitmap(rotateBitmap);

            // ストリームのクローズ
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
