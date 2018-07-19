package net.buildbox.pokeri.intent_activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class ReturnActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_return);

        // 戻り値の設定
        setResult(15);
    }
}
