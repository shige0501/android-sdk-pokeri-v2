package net.buildbox.pokeri.graph_bitmapwidth;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ビットマップの幅、高さの取得
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();

        // 幅、高さの表示設定
        TextView widthText = findViewById(R.id.image_width_text);
        widthText.setText("幅: " + width);
        TextView heightText = findViewById(R.id.image_height_text);
        heightText.setText("高さ: " + height);
    }
}
