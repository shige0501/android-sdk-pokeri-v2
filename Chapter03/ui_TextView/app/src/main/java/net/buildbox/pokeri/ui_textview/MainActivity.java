package net.buildbox.pokeri.ui_textview;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onMessageClick(View view) {
        TextView pokeriMessage = findViewById(R.id.pokeri_message);
        // TextViewのテキストを変更する
        pokeriMessage.setText("こんにちは、ポケットリファレンス");
        // テキストカラーを青に変更
        pokeriMessage.setTextColor(Color.BLUE);
        // テキストサイズを変更
        pokeriMessage.setTextSize(24.0f);
    }
}
