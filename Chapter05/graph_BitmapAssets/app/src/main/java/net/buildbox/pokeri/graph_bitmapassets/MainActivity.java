package net.buildbox.pokeri.graph_bitmapassets;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
            // https://commons.wikimedia.org/wiki/File:Android_7.0_Nougat.jpg?uselang=ja
            InputStream is = assetManager.open("nougat.jpg");
            BufferedInputStream buf = new BufferedInputStream(is);
            Bitmap bitmap = BitmapFactory.decodeStream(buf);

            // 画像をImageViewで表示
            ImageView nougatImageView = findViewById(R.id.nougat_image_view);
            nougatImageView.setImageBitmap(bitmap);

            // ストリームのクローズ
            buf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
