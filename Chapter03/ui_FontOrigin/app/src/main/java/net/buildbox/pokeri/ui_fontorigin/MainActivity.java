package net.buildbox.pokeri.ui_fontorigin;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // オリジナルフォントを用いたTypefaceの作成
        Typeface originTypeface = Typeface.createFromAsset(getAssets(), "HuiFontP29.ttf");

        // タイプフェイスの設定
        TextView helloView = findViewById(R.id.hello_view);
        helloView.setTypeface(originTypeface);
    }
}
