package net.buildbox.pokeri.device_network;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import net.buildbox.pokeri.device_network.network.NetworkTask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new NetworkTask()
            .setNetworkListener(new NetworkTask.NetworkListener() {
                @Override
                public void onSuccess(Bitmap bitmap) {
                    ImageView qrCodeView = findViewById(R.id.qr_code_view);
                    qrCodeView.setImageBitmap(bitmap);
                }
            })
            .execute();
    }
}
