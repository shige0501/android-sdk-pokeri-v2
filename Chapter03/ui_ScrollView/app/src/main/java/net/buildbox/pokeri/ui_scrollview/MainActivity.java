package net.buildbox.pokeri.ui_scrollview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ScrollView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // スクロールバーの表示位置の設定
        ScrollView sv = findViewById(R.id.scroll_view);
        sv.setVerticalScrollbarPosition(ScrollView.SCROLLBAR_POSITION_LEFT);
    }
}
