package net.buildbox.pokeri.window_configuration;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 画面の向きを表示
        Configuration config = getResources().getConfiguration();
        String orientation = "";
        if (config.orientation == Configuration.ORIENTATION_PORTRAIT) {
            orientation = "縦方向";
        } else if (config.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            orientation = "横方向";
        }
        Toast.makeText(this,
            "画面の向きは、" + orientation,
            Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(this, "縦向きに変わりました", Toast.LENGTH_SHORT).show();
        } else if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(this, "横向きに変わりました", Toast.LENGTH_SHORT).show();
        }
    }
}
