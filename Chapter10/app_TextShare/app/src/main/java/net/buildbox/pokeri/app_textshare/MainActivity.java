package net.buildbox.pokeri.app_textshare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 受け取ったテキストをToastで表示する
        Intent intent = getIntent();
        if (intent != null) {
            Bundle bundle = intent.getExtras();
            String action = intent.getAction();
            if (bundle != null && action != null && action.equals(Intent.ACTION_SEND)) {
                String receiveText = bundle.getString(Intent.EXTRA_TEXT);
                Toast.makeText(this, "受け取ったテキスト: " + receiveText, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
