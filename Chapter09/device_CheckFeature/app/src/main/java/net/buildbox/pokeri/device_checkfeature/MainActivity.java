package net.buildbox.pokeri.device_checkfeature;

import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PackageManager packageManager = getPackageManager();
        if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
            Toast.makeText(this, "このデバイスはカメラ機能に対応しています", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "このデバイスはカメラ機能に対応していません", Toast.LENGTH_SHORT).show();
        }
    }
}
