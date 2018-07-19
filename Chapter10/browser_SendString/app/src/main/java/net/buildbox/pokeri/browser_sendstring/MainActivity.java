package net.buildbox.pokeri.browser_sendstring;

import android.os.Bundle;
import android.provider.Browser;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onTextShare(View view) {
        // 暗黙的Intentで文字列の送信
        Browser.sendString(this, "文字列の送信サンプルです");
    }
}
