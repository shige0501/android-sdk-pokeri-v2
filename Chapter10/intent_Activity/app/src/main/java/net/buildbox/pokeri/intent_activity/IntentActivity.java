package net.buildbox.pokeri.intent_activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class IntentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        Intent intent = new Intent();
        intent.putExtra("return_text", "テキストを返します");

        // 戻り値の設定
        setResult(RESULT_OK, intent);
    }
}
