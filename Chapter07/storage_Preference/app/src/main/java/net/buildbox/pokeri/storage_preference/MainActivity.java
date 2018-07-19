package net.buildbox.pokeri.storage_preference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // プリファレンスからの読み込み処理
    public void onReadEvent(View v) {
        // プリファレンスからの読み込み
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String message = prefs.getString("key_message", "");

        EditText messageView = findViewById(R.id.message_view);
        messageView.setText(message);
    }

    // プリファレンスへの書き込み処理
    public void onWriteEvent(View v) {
        EditText messageView = findViewById(R.id.message_view);
        String message = messageView.getText().toString();

        // プリファレンスへの書き込み処理
        PreferenceManager.getDefaultSharedPreferences(this).edit()
            .putString("key_message", message)
            .apply();
    }
}
