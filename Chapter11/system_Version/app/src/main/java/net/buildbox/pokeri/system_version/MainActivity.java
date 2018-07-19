package net.buildbox.pokeri.system_version;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Androidのバージョン情報取得
        TextView codeNameView = findViewById(R.id.code_name_view);
        codeNameView.setText(String.format("CodeName: %s", Build.VERSION.CODENAME));
        TextView incrementalView = findViewById(R.id.incremenrtal_view);
        incrementalView.setText(String.format("Incremental: %s", Build.VERSION.INCREMENTAL));
        TextView releaseView = findViewById(R.id.release_view);
        releaseView.setText(String.format("Release: %s", Build.VERSION.RELEASE));
        TextView sdkView = findViewById(R.id.sdk_view);
        sdkView.setText(String.format("SDK_INT: %s", Build.VERSION.SDK_INT));
    }
}
